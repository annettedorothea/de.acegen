package de.acegen.templates.cs.controller

import de.acegen.aceGen.AuthUser
import de.acegen.aceGen.HttpServer
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.cs.CsHttpServerExtension
import javax.inject.Inject

class Controller {

	@Inject
	extension CommonExtension

	@Inject
	extension CsHttpServerExtension

	def generate(HttpServer it, AuthUser authUser) '''
		«copyright»
		
		using Microsoft.AspNetCore.Mvc;
		
		namespace «controllerNamespace».Controller;
		
		[ApiController]
		[Route("[controller]")]
		public class «controllerName» : ControllerBase
		{
		
		    private readonly ILogger<«controllerName»> _logger;
		
		    public «controllerName»(ILogger<«controllerName»> logger)
		    {
		        _logger = logger;
		    }
		    
		    «FOR aceOperation : aceOperations»
		    	//«aceOperation.name»
		    «ENDFOR»
		}
		
		«sdg»
	'''
}
