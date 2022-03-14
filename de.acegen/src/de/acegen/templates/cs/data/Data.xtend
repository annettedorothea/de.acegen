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


package de.acegen.templates.cs.data

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.CsHttpServerExtension
import de.acegen.extensions.cs.AttributeExtension
import de.acegen.extensions.cs.ModelExtension
import javax.inject.Inject

class Data {

	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension CsHttpServerExtension

	def generateDataInterface(Model it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Data;
		
		«importModel»
		
		public interface «dataInterfaceName» : «modelName», IDataContainer {
			«FOR superModel : superModels»
				void mapFrom(«superModel.interfaceWithPackage» model);
			«ENDFOR»
			
		}
		
		«sdg»
		
	'''
	
	def generateAbstractData(Model it, HttpServer httpServer) '''
		«copyright»
		
		«importModel»
		«FOR superModel : superModels»
			«superModel.importModel»
		«ENDFOR»
		
		namespace «httpServer.namespace».Data;

		public abstract class «abstractDataName» : AbstractData, «dataInterfaceName» {
			
			«FOR attribute : allAttributes»
				public «attribute.getSet»
				
			«ENDFOR»
		
			public «abstractDataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param»
				«ENDFOR»
				string uuid
			) : base(uuid) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«IF allAttributes.length > 0»
				public «abstractDataName»( string uuid ) : base(uuid) {
				}
			«ENDIF»
		
			«FOR superModel : superModels»
				public void mapFrom(«superModel.interfaceWithPackage» model) {
					«FOR attribute: superModel.allAttributes»
						this.«attribute.name» = model.«attribute.getterCall»;
					«ENDFOR»
				}
			«ENDFOR»
			
		}
		
		«sdg»
		
	'''
	
	def generateData(Model it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Data;

		public class «dataName» : «abstractDataName», «dataInterfaceName» {
			
			public «dataName»(
				«FOR attribute : allAttributes»
					«attribute.param», 
				«ENDFOR»
				string uuid
			) : base(«FOR attribute : allAttributes»«attribute.name», «ENDFOR»uuid) {
			}

			«IF allAttributes.length > 0»
				public «dataName»( string uuid ) : base(uuid) {
				}

			«ENDIF»
			override public void MigrateLegacyData(String json) {
			}
		
			public static «dataInterfaceName» GenerateTestData() {
				Random random = new Random();
				«IF allAttributes.filter[a | a.list].size > 0»
					int n;
				«ENDIF»
				«dataInterfaceName» testData = («dataInterfaceName») new «modelClassNameWithPackage»();
				«FOR attribute : allAttributes»
					«IF attribute.model !== null»
						«IF attribute.list»
							List<«attribute.model.interfaceWithPackage»> «attribute.name.toFirstLower»List = new List<«attribute.model.interfaceWithPackage»>();
							n = random.Next(20) + 1;
							for ( int i = 0; i < n; i++ ) {
								«attribute.name.toFirstLower»List.Add(«attribute.model.dataNameWithPackage».GenerateTestData());
							}
							testData.«attribute.name.toFirstUpper» = «attribute.name.toFirstLower»List;
						«ELSE»
							testData.«attribute.name.toFirstUpper» = «attribute.model.dataNameWithPackage».GenerateTestData();
						«ENDIF»
					«ELSE»
						«IF attribute.list»
							«attribute.csType» «attribute.name.toFirstLower»List = new «attribute.csTypeNew»();
							n = random.Next(20) + 1;
							for ( int i = 0; i < n; i++ ) {
								«attribute.name.toFirstLower»List.Add(«attribute.randomValue»);
							}
							testData.«attribute.name.toFirstUpper» = «attribute.name.toFirstLower»List;
						«ELSE»
							testData.«attribute.name.toFirstUpper» = «attribute.randomValue»;
						«ENDIF»
					«ENDIF»
				«ENDFOR»
				return testData;
			}
			
			private static String RandomString(Random random) {
				String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
				int length = random.Next(20) + 5;
				return new string(Enumerable.Repeat(chars, length).Select(s => s[random.Next(s.Length)]).ToArray());
			}
			
			private static bool RandomBool(Random random) {
				return random.Next() > (Int32.MaxValue / 2);
			}
			
			private static float RandomFloat(Random random) {
			    double mantissa = (random.NextDouble() * 2.0) - 1.0;
			    double exponent = Math.Pow(2.0, random.Next(-126, 128));
			    return (float)(mantissa * exponent);
			}
			
			
		}
		
		«sdg»
		
	'''
	
	def generateResponseData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Data;
		
		public class «responseDataName» : «responseDataInterfaceName» {
			
			«FOR attribute : response»
				public «attribute.get»
				
			«ENDFOR»

			public «responseDataName»() {
			}
			
			public «responseDataName»(«getModel.modelName» data) {
				«FOR attribute : response»
					«attribute.name.toFirstUpper» = data.«attribute.name.toFirstUpper»;
				«ENDFOR»
			}
			
		}
		
		«sdg»
		
	'''
	
	def generateReponseDataInterface(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Data;
		
		public interface «responseDataInterfaceName» {
			«FOR attribute : response»
				«attribute.get»
				
			«ENDFOR»
		
		}
		
		«sdg»
		
	'''
	
	def generatePayloadData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Data;
		
		public class «payloadDataName» : «payloadDataInterfaceName» {
			
			«FOR attributeRef : payload»
				public «attributeRef.attribute.get»
				
			«ENDFOR»

			public «payloadDataName»() {
			}
			
			public «payloadDataName»(«getModel.interfaceWithPackage» data) {
				«FOR attributeRef : payload»
					«attributeRef.attribute.name.toFirstUpper» = data.«attributeRef.attribute.name.toFirstUpper»;
				«ENDFOR»
			}
			
		}
		
		«sdg»
		
	'''
	
	def generatePayloadDataInterface(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		namespace «httpServer.namespace».Data;
		
		public interface «payloadDataInterfaceName» {
			«FOR attributeRef : payload»
				«attributeRef.attribute.get»
				
			«ENDFOR»
		
		}
		
		«sdg»
		
	'''
	
	def generateIDataContainer() '''
		«copyright»
		
		namespace AceGen;
		
		public interface IDataContainer
		{
		
		    string Uuid { get; }
		
		    bool HasOutcome(string outcome);
		
		    List<string> Outcomes { get; }
		
		    void AddOutcome(string outcome);
		
		    DateTime SystemTime {get; set;}
		
		    void MigrateLegacyData(string json);
					
		}		
		
		«sdg»
		
	'''
	
	def generateAbstractData() '''
		«copyright»
		
		namespace AceGen;
		
		public abstract class AbstractData : IDataContainer {
		
		    public string Uuid { get; }
		
			public DateTime SystemTime {get; set;}
		
			public List<string> Outcomes { get; }
		
			public AbstractData( string uuid ) {
				this.Uuid = uuid;
				Outcomes = new List<string>();
			}
		
			public bool HasOutcome(string outcome) {
				return Outcomes.Contains(outcome);
			}
		
			public void AddOutcome(string outcome) {
				Outcomes.Add(outcome);
			}
		
			public abstract void MigrateLegacyData(string json);
			
		}		
		
		«sdg»
		
	'''
	
	
}