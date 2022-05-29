package de.acegen.templates.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject
import de.acegen.aceGen.HttpClient

class JsxTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	def generateComponent(ClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import React from "react";
		
		«componentImports»
		
		export const «componentName» = (props) => {
			«IF isInput»
				return <input 
					type="«inputType»"
					«IF childrenContain("value")»value={props.value}«ENDIF»
					«IF childrenContain("disabled")»value={props.disabled}«ENDIF»
					«IF childrenContain("readonly")»value={props.readonly}«ENDIF»
					«IF childrenContain("checked")»checked={props.checked}«ENDIF»
					placeholder="«name»"
					className="text-input"
					id="«name»"
					«FOR action : actions»
						«action.type»={(event) => «action.target.getName.toFirstLower»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}
					«ENDFOR»
				/>
			«ELSEIF isSelect»
				const options = [
					{value: 1, option: "1"},
					{value: 2, option: "2"},
					{value: 3, option: "3"},
				]
				return <select 
					«IF childrenContain("value")»value={props.value}«ENDIF»
					«IF childrenContain("disabled")»value={props.disabled}«ENDIF»
					«IF childrenContain("readonly")»value={props.readonly}«ENDIF»
					className="select"
					id="«name»"
					«FOR action : actions»
						«action.type»={(event) => «action.target.getName.toFirstLower»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}
					«ENDFOR»
				>
					{options.map(item => <option value={item.value}>{item.option}</option>)}
				</select>
			«ELSEIF isButton»
				return <button 
					«IF childrenContain("disabled")»value={props.disabled}«ENDIF»
					«IF childrenContain("readonly")»value={props.readonly}«ENDIF»
					className="button"
					id="«name»"
					«FOR action : actions»
						«action.type»={(event) => «action.target.getName.toFirstLower»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}
					«ENDFOR»
				>
					«name»
				</button>
			«ELSE»
				return <>
					«FOR attribute: attributes»
						«attribute.renderChild»
					«ENDFOR»
					«IF hasComplexAttribute»
						{props.children}
					«ENDIF»
				</> 
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	def generateComponentContainer(ClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import React from "react";
		
		«componentContainerImports("")»
		
		export const «componentContainerName» = (props) => {
			«IF hasComplexAttribute»
				return <«componentName» {...props}>
					«FOR attribute: attributes»
						«IF !attribute.isTag»
							«attribute.renderChildContainer»
						«ENDIF»
					«ENDFOR»
				</«componentName»> 
			«ELSE»
				return <«componentName» {...props} /> 
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	def generateRootComponentContainer(ClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import React, {useState} from "react";
		
		«componentContainerImports("")»
		
		export let setContainerState;
		
		export const «componentContainerName» = () => {
			
			const [props, setProps] = useState();
			setContainerState = setProps;
		
			if (!props) {
				return null;
			}
			
			«IF hasComplexAttribute»
				return <«componentName» {...props}>
					«FOR attribute: attributes»
						«IF !attribute.isTag»
							«attribute.renderChildContainer»
						«ENDIF»
					«ENDFOR»
				</«componentName»> 
			«ELSE»
				return <«componentName» {...props} /> 
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	def renderChild(ClientAttribute it) '''
		«IF isTag»
			<«componentName» {...props} />
		«ELSEIF attributes.size == 0»
			<div>«name.toFirstLower»: {props.«name.toFirstLower»}</div>
		«ELSEIF list»
			{ props.«name» ? props.«name».map(i => <«componentName» {...i} />) : [] }
		«ENDIF»
	'''
	
	def renderChildContainer(ClientAttribute it) '''
		«IF isComponent»
			«IF !list»
				{ props.«name» && <«componentContainerName» {...props.«name.toFirstLower»} /> }
			«ENDIF»
		«ENDIF»
	'''
	
	def CharSequence componentContainerImports(ClientAttribute it, String subFolder) '''
		import { «componentName» } from "«depth()»src/components/«subFolder»«path»«componentName»";
		«FOR attribute : attributes»
			«IF !attribute.isTag && !attribute.isList»
				«attribute.importComponentContainer('''«subFolder»/«name.toFirstLower»''')»
			«ENDIF»
		«ENDFOR»
	''' 
	
	def CharSequence componentImports(ClientAttribute it) '''
		«FOR attribute : attributes»
			«attribute.importComponent(name.toFirstLower)»
		«ENDFOR»
		«FOR action : actions»
			import { «action.target.name.toFirstLower» } from "«depth()»gen/«(action.target.eContainer as HttpClient).name»/ActionFunctions";
		«ENDFOR»
	''' 
	
}