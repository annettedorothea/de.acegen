package de.acegen.templates.cs

import de.acegen.aceGen.AuthUser
import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.TypeExtension
import javax.inject.Inject

class Controller {
	@Inject
	extension CommonExtension

	@Inject
	extension TypeExtension

	def generate(HttpServer it, AuthUser authUser) '''
		«copyright»

		using Microsoft.AspNetCore.Mvc;
		
		namespace «controllerNamespace»;
		
		[ApiController]
		public class «controllerName»
		{
			«FOR ace : it.aceOperations»
				[Http«ace.type.toLowerCase().toFirstUpper»("«ace.url»")]
				public ActionResult «ace.name.toFirstUpper»([FromQuery] string? uuid)
				{
				    return new OkResult();
				}
			«ENDFOR»
		}
		
		«sdg»
	'''
}