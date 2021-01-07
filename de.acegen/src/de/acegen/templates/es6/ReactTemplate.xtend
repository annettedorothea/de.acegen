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

		import React, {useState} from 'react';
		import { uiElement } from "«folderPrefix»../../src/components«subFolder»/«componentName»";
		
		export const set«componentName»State = (newState) => {
		    if (functions.setState) {
		        functions.setState(newState);
		    }
		}
		
		let functions = {};
		
		export const «reactComponentName» = (props) => {
		    const [state, setState] = useState();
		    functions.setState = setState;
		    return uiElement({...props, ...state});
		}
		
		«sdg»
		
	'''
	
	def generateContainer() '''
		«copyright»


		import React, {useState} from 'react';
		import { uiElement } from "../../src/components/Container";
		import * as AppState from "../ace/AppState";
		
		export const setContainerState = (newState) => {
		    if (functions.setState) {
		        functions.setState(newState);
		    }
		}
		
		let functions = {};
		
		export const ContainerComponent = (props) => {
		    const [state, setState] = useState(AppState.getAppState());
		    functions.setState = setState;
		    return uiElement({...props, ...state});
		}
		
		«sdg»
		
	'''
	
	def generateComponentStruct(ClientAttribute it, String folderPrefix) '''
		«copyright»

		import { div } from "«folderPrefix»../../gen/components/ReactHelper";
		
		export function uiElement(attributes) {
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

		const normalize = (options) => {
		    if (options && options.class !== undefined) {
		        options.className = options.class
		        delete options.class;
		    }
		    if (options) {
		    	options.key = options.id;
		    }
		    return options;
		}
		
		export const generic = (type, options, children) => {
		    return React.createElement(
		        type,
		        normalize(options),
		        children ? [...children] : undefined
		    )
		}
		
		export const br = () => {
		    return generic("br");
		}
		
		export const hr = () => {
		    return generic("hr");
		}
		
		export const p = (options, children) => {
		    return generic("p", options, children);
		}
		
		export const ul = (options, children) => {
		    return generic("ul", options, children);
		}
		
		export const ol = (options, children) => {
		    return generic("ol", options, children);
		}
		
		export const li = (options, children) => {
		    return generic("li", options, children);
		}
		
		export const label = (options, children) => {
		    return generic("label", options, children);
		}
		
		export const button = (options, children) => {
		    return generic("button", options, children);
		}
		
		export const div = (options, children) => {
		    return generic("div", options, children);
		}
		
		export const span = (options, children) => {
		    return generic("span", options, children);
		}
		
		export const a = (options, children) => {
		    return generic("a", options, children);
		}
		
		export const h1 = (options, children) => {
		    return generic("h1", options, children);
		}
		
		export const h2 = (options, children) => {
		    return generic("h2", options, children);
		}
		
		export const h3 = (options, children) => {
		    return generic("h3", options, children);
		}
		
		export const h4 = (options, children) => {
		    return generic("h4", options, children);
		}
		
		export const h5 = (options, children) => {
		    return generic("h5", options, children);
		}
		
		export const h6 = (options, children) => {
		    return generic("h6", options, children);
		}
		
		export const pre = (options, children) => {
		    return generic("pre", options, children);
		}
		
		export const input = (options) => {
		    return <input {...normalize(options)}/>
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
			    return <«reactComponentName» {...normalize(options)}/>
			}
			«FOR attribute: attributes»
				«components(attribute)»
			«ENDFOR»
		«ENDIF»
	''' 
	
	def dispatch CharSequence components(GroupedClientAttribute it) '''
		export const «reactTagName» = (options) => {
		    return <«reactComponentName» {...normalize(options)}/>
		}
		«IF attributeGroup.size > 0»
			«FOR attribute: attributeGroup»
				«components(attribute)»
			«ENDFOR»
		«ENDIF»
	'''
	
	
	
}