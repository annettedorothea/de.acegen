package de.acegen.templates.cs.models

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.AttributeExtension
import de.acegen.extensions.cs.TypeExtension
import javax.inject.Inject

class Model {
	
	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension

	@Inject
	extension TypeExtension

	def generateAbstractModel(HttpServer it) '''
		«copyright»
		
		namespace «acegenNamespace»;
		
		public abstract class AbstractModel {
			public abstract void Freeze();
		}
		
		
		«sdg»
	'''

	def generateClass(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		«copyright»
		
		using «httpServer.acegenNamespace»;
		
		namespace «httpServer.modelNamespace»;
		
		public class «modelClassName» : AbstractModel {
		
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
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR superModel : superModels»
				public «superModel.modelClassNameWithPackage» MapTo«superModel.modelClassName»() {
					«superModel.modelClassNameWithPackage» model = new «superModel.modelClassNameWithPackage»();
					«FOR attribute : superModel.allAttributes»
						model.«attribute.propertyName» = this.«attribute.propertyName»;
					«ENDFOR»
					return model;
				}	
			«ENDFOR»
			
			public override void Freeze() {
				this.frozen = true;
				«FOR attribute : allAttributes»
					«IF attribute.model !== null»
						if (this.«attribute.propertyName» != null) {
							«IF attribute.list»
								for ( int i = 0; i < «attribute.propertyName».Count(); i++ ) {
									«attribute.propertyName»[i].Freeze();
								}
							«ELSE»
								this.«attribute.propertyName».Freeze();
							«ENDIF»
						}
					«ENDIF»
				«ENDFOR»
			}
		
		}
		
		«sdg»
		
	'''

}
