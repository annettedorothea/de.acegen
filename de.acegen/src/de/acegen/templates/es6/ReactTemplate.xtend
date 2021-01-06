package de.acegen.templates.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class ReactTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	def generateComponent(ClientAttribute it, String subFolder, String folderPrefix) '''
		«copyright»

		import React from 'react';
		import { jsx } from "«folderPrefix»../../src/components«subFolder»/«componentName»";
		
		export const «reactComponentName» = (props) => {
		    return jsx(props);
		}
		
		«sdg»
		
	'''
	
	def generateContainer() '''
		«copyright»

		import React from 'react';
		import { jsx } from "../../src/components/ContainerNew";
		
		export const ContainerComponent = (props) => {
		    return jsx(props);
		}
		
		«sdg»
		
	'''
	
	def generateComponentStruct(ClientAttribute it, String folderPrefix) '''
		«copyright»

		import { div } from "«folderPrefix»../../gen/components/ReactHelper";
		
		export function jsx(attributes) {
			return div("«it === null ? "container" : componentName»", {}, []);
		}
		
		«sdg»
		
	'''
	
	def generateReactHelper(HttpClient httpClient) '''
		«copyright»

		import React from 'react';
		«FOR attribute: httpClient.ui»
			«attribute.componentImports("")»
		«ENDFOR»
		
		export const li = (value, options, children) => {
		    return <li {...options} key={options && options.id ? options.id : ""}>{value ? value : children}</li>
		}
		
		export const ul = (options, children) => {
		    return <ul {...options} key={options && options.id ? options.id : ""}>{children}</ul>
		}
		
		export const label = (value, options, children) => {
		    return <label {...options} key={options && options.id ? options.id : ""}>{value ? value : children}</label>
		}
		
		export const button = (value, options, children) => {
		    return <button {...options} key={options && options.id ? options.id : ""}>{value ? value : children}</button>
		}
		
		export const div = (value, options, children) => {
		    return <div {...options} key={options && options.id ? options.id : ""}>{value ? value : children}</div>
		}
		
		export const pre = (value, options, children) => {
		    return <pre {...options} key={options && options.id ? options.id : ""}>{value ? value : children}</pre>
		}

		export const input = (options) => {
		    return <input {...options} key={options && options.id ? options.id : ""}/>
		}
		
		«FOR attribute: httpClient.ui»
			«attribute.components»
		«ENDFOR»

		«sdg»
		
	'''
	
	def dispatch CharSequence componentImports(SingleClientAttribute it, String subFolder) '''
		«IF attributes.size > 0»
			import { «reactComponentName» } from ".«subFolder»/«reactComponentName»";
			«FOR attribute: attributes»
				«componentImports(attribute, '''«subFolder»/«name.toFirstLower»''')»
			«ENDFOR»
		«ENDIF»
	''' 
	
	def dispatch CharSequence componentImports(GroupedClientAttribute it, String subFolder) '''
		import { «reactComponentName» } from ".«subFolder»/«reactComponentName»";
		«IF attributeGroup.size > 0»
			«FOR attribute: attributeGroup»
				«componentImports(attribute, '''«subFolder»/«name.toFirstLower»''')»
			«ENDFOR»
		«ENDIF»
	'''
	
	def dispatch CharSequence components(SingleClientAttribute it) '''
		«IF attributes.size > 0»
			export const «reactTagName» = (options) => {
			    return <«reactComponentName» {...options} key={options && options.id ? options.id : ""}/>
			}
			«FOR attribute: attributes»
				«components(attribute)»
			«ENDFOR»
		«ENDIF»
	''' 
	
	def dispatch CharSequence components(GroupedClientAttribute it) '''
		export const «reactTagName» = (options) => {
		    return <«reactComponentName» {...options} key={options && options.id ? options.id : ""}/>
		}
		«IF attributeGroup.size > 0»
			«FOR attribute: attributeGroup»
				«components(attribute)»
			«ENDFOR»
		«ENDIF»
	'''
	
	
	
}