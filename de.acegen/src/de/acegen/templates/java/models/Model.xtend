/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


package de.acegen.templates.java.models

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.TypeExtension
import javax.inject.Inject

class Model {
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension TypeExtension
	
	def generateAbstractModel() '''
		«copyright»
		
		package de.acegen;
		
		public abstract class AbstractModel {
			public abstract void freeze();
		}
		
		
		«sdg»
	'''
	
	def generateClass(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.modelPackageName»;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

		import java.util.List;
		import java.util.ArrayList;

		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		import de.acegen.AbstractModel;

		@SuppressWarnings("all")
		public class «modelClassName» extends AbstractModel {
		
			«FOR attribute : allAttributes»
				«attribute.declaration»

			«ENDFOR»
			
			private Boolean frozen = false;
		
			«IF allAttributes.length > 0»
				public «modelClassName»() {
				}
			«ENDIF»
		
			public «modelClassName»(
				«FOR attribute : allAttributes SEPARATOR ','»
					«attribute.paramAsJsonProperty»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : allAttributes»
				«attribute.jsonProperty»
				«attribute.getter»
				
				«attribute.jsonProperty»
				«attribute.setterWithFrozen»
				
			«ENDFOR»
			
			«FOR superModel : superModels»
				public «superModel.modelClassNameWithPackage» mapTo«superModel.modelClassName»() {
					«superModel.modelClassNameWithPackage» model = new «superModel.modelClassNameWithPackage»();
					«FOR attribute : superModel.allAttributes»
						model.«attribute.setterName()»(this.«attribute.getterName()»());
					«ENDFOR»
					return model;
				}	
			«ENDFOR»
			
			@Override
			public void freeze() {
				this.frozen = true;
				«FOR attribute : allAttributes»
					«IF attribute.model !== null»
						if (this.«attribute.propertyName» != null) {
							«IF attribute.list»
								for ( int i = 0; i < «attribute.propertyName».size(); i++ ) {
									«attribute.propertyName».get(i).freeze();
								}
							«ELSE»
									this.«attribute.propertyName».freeze();
							«ENDIF»
						}
					«ENDIF»
				«ENDFOR»
			}

			public «modelClassNameWithPackage» deepCopy() {
				«modelClassNameWithPackage» copy = new «modelClassName»();
				«FOR attribute : allAttributes»
					«attribute.deepCopy»
				«ENDFOR»
				return copy;
			}
			
			public static «modelClassName» generateTestData() {
				java.util.Random random = new java.util.Random();
				«IF allAttributes.filter[a | a.list].size > 0»
					int n;
				«ENDIF»
				«modelClassName» testData = new «modelClassName»();
				«FOR attribute : allAttributes»
					«IF attribute.model !== null»
						«IF attribute.list»
							java.util.List<«attribute.model.modelClassNameWithPackage»> «attribute.propertyName»List = new java.util.ArrayList<«attribute.model.modelClassNameWithPackage»>();
							n = random.nextInt(20) + 1;
							for ( int i = 0; i < n; i++ ) {
								«attribute.propertyName»List.add(«attribute.model.modelClassNameWithPackage».generateTestData());
							}
							testData.«attribute.setterName()»(«attribute.name.toFirstLower»List);
						«ELSE»
							testData.«attribute.setterName()»(«attribute.model.modelClassNameWithPackage».generateTestData());
						«ENDIF»
					«ELSE»
						«IF attribute.list»
							«attribute.javaType» «attribute.propertyName»List = new «attribute.javaTypeNew»();
							n = random.nextInt(20) + 1;
							for ( int i = 0; i < n; i++ ) {
								«attribute.propertyName»List.add(«attribute.randomValue»);
							}
							testData.«attribute.setterName()»(«attribute.name.toFirstLower»List);
						«ELSE»
							testData.«attribute.setterName()»(«attribute.randomValue»);
						«ENDIF»
					«ENDIF»
				«ENDFOR»
				return testData;
			}
			
			private static String randomString(java.util.Random random) {
				String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
				int n = random.nextInt(20) + 5;
				StringBuilder sb = new StringBuilder(n);
				for (int i = 0; i < n; i++) {
					int index = random.nextInt(chars.length());
					sb.append(chars.charAt(index));
				}
				String string  = sb.toString(); 
				return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
			}

		}
		
		«sdg»
		
	'''	
	
	private def String deepCopy(Attribute it) '''
		«IF !list»
			«IF type !== null»
				copy.«setterName»(this.«getterName»());
			«ELSEIF model !== null»
				if (this.«getterName»() != null) {
					copy.«setterName»(this.«getterName»().deepCopy());
				}
			«ENDIF»
		«ELSE»
			«IF type !== null»
				List<«type»> «name»Copy = new ArrayList<«type»>();
				if (this.«getterName»() != null) {
					for(«type» item: this.«getterName»()) {
						«name»Copy.add(item);
					}
				}
			«ELSEIF model !== null»
				List<«model.modelClassNameWithPackage»> «name»Copy = new ArrayList<«model.modelClassNameWithPackage»>();
				if (this.«getterName»() != null) {
					for(«model.modelClassNameWithPackage» item: this.«getterName»()) {
						«propertyName»Copy.add(item.deepCopy());
					}
				}
			«ENDIF»
			copy.«setterName»(«propertyName»Copy);
		«ENDIF»
	'''
	
	
}