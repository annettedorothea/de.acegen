package de.acegen.templates.es6

import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class ReactTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	dispatch def generateComponent(SingleClientAttribute it, String subFolder, String folderPrefix) '''
		«copyright»

		import React, {useState, useEffect} from 'react';
		import { uiElement } from "«folderPrefix»../../src/components«subFolder»/«componentName»";
		
		«IF !list»
			export const set«componentName»State = (newState) => {
			    if (functions.setState) {
			        functions.setState(newState);
			    }
			}
			
			let functions = {};
		«ENDIF»
		
		export const «reactComponentName» = (props) => {
			«IF !list»
				const [state, setState] = useState();
				functions.setState = setState;
				return uiElement({...props, ...state});
			«ELSE»
			    return uiElement({...props});
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	dispatch def generateComponent(GroupedClientAttribute it, String subFolder, String folderPrefix) '''
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
	
	def dispatch generateComponentStruct(SingleClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import React from "react";
		
		export function uiElement(attributes) {
			const json = JSON.stringify(attributes, null, '\t');
			return <pre>{json}</pre>
		}
		
		«sdg»
		
	'''
	
	def dispatch generateComponentStruct(GroupedClientAttribute it, String folderPrefix) '''
		«copyright»

		import React from "react";
		
		export function uiElement(props) {
			«FOR attribute: attributeGroup»
				if (props.is«attribute.name.toFirstUpper» === true) {
					return <«attribute.reactTagName» {...props}/>;
				}
			«ENDFOR»
			return null;
		}
		
		«sdg»
		
	'''
	
	def dispatch CharSequence componentImports(SingleClientAttribute it, String subFolder) '''
		«IF attributes.size > 0 && !noComponent»
			import { «reactComponentName» } from ".«subFolder»/«reactComponentName»";
			«FOR attribute: attributes»
				«componentImports(attribute, '''«subFolder»/«name.toFirstLower»''')»
			«ENDFOR»
		«ENDIF»
	''' 
	
	def dispatch CharSequence components(SingleClientAttribute it, boolean isGroupedChild) '''
		«IF attributes.size > 0 && !noComponent»
			export const «reactTagName» = (options) => {
				options.key = "«reactTagName»";
			    return <«reactComponentName» {...normalize(options)}/>
			}
			«FOR attribute: attributes»
				«components(attribute, false)»
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
	
	def dispatch CharSequence components(GroupedClientAttribute it, boolean isGroupedChild) '''
		export const «reactTagName» = (options) => {
			options.key = "«reactTagName»";
		    return <«reactComponentName» {...normalize(options)}/>
		}
		«IF attributeGroup.size > 0»
			«FOR attribute: attributeGroup»
				«components(attribute, true)»
			«ENDFOR»
		«ENDIF»
	'''
	
	
	
}