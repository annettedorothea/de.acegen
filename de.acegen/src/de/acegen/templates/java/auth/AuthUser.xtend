package de.acegen.templates.java.auth

import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AttributeExtension
import javax.inject.Inject

class AuthUser {

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def generateAuthUser(de.acegen.aceGen.AuthUser it) '''
		«copyright»
		
		package de.acegen.auth;
		
		import java.security.Principal;
		
		public class «name.toFirstUpper» implements Principal {
		
			«FOR attribute : attributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «name.toFirstUpper» (
				«FOR attribute : attributes SEPARATOR ','»
					«attribute.param»
				«ENDFOR»
			) {
				«FOR attribute : attributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : attributes»
				«attribute.getter(false)»
				
			«ENDFOR»
			public String getName() {
				return "AuthUser";
			}
		}
		
		«sdg»
		
	'''

	
}