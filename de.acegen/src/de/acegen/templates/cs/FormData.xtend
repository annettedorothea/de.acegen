package de.acegen.templates.cs

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class FormData {
	
	@Inject
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		namespace AceGen;
		
		public class FormData {
		
		}
		
		«sdg»
	'''
}