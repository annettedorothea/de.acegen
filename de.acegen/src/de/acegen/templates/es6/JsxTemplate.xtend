package de.acegen.templates.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject
import de.acegen.aceGen.HttpClient
import java.util.List

class JsxTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	def generateComponent(ClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import React from "react";
		
		export const «componentName» = (props) => {
			«IF isInput»
				return <input 
					type="«inputType»"
					«FOR attribute: attributes»
						«attribute.name.toFirstLower»={props.«attribute.name.toFirstLower»}
					«ENDFOR»
					placeholder="«name»"
					className="text-input"
					{...props}
					«FOR action : actions»
						«action.name»={(event) => props.«action.name»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}
					«ENDFOR»
				/>
			«ELSEIF isSelect»
				const options = [
					«FOR option : options»
						{value: "«option»", option: "«option»"},
					«ENDFOR»
				]
				return <select 
					«FOR attribute: attributes»
						«attribute.name.toFirstLower»={props.«attribute.name.toFirstLower»}
					«ENDFOR»
					className="select"
					{...props}
					«FOR action : actions»
						«action.name»={(event) => props.«action.name»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}
					«ENDFOR»
				>
					{options.map(item => <option value={item.value} key={item.value}>{item.option}</option>)}
				</select>
			«ELSEIF isButton»
				return <button 
					«FOR attribute: attributes»
						«attribute.name.toFirstLower»={props.«attribute.name.toFirstLower»}
					«ENDFOR»
					className="button"
					{...props}
					«FOR action : actions»
						«action.name»={(event) => props.«action.name»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}
					«ENDFOR»
				>
					«name»
				</button>
			«ELSE»
				return <>
					<h1>«componentName»</h1>
					<ul>
						«FOR attribute: attributes»
							«attribute.renderChild»
						«ENDFOR»
					</ul>
					«FOR action : actions»
						<a «action.name»={(event) => props.«action.name»(«FOR param: action.target.input SEPARATOR ','»«IF param.name == "value"»event.target.value«ELSEIF param.name == "keyCode"»event.keyCode«ELSE»props.«param.name»«ENDIF»«ENDFOR»)}>
							«action.target.name»
						</a>
					«ENDFOR»
					«IF hasComplexAttribute || isTree»
						{props.children}
					«ENDIF»
				</> 
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	def generateComponentContainer(ClientAttribute it, String folderPrefix, boolean root) '''
		«copyright»
		
		import React«IF root», {useState}«ENDIF» from "react";
		
		«componentContainerImports("")»
		
		«IF root»
			export let setContainerState;
		«ENDIF»
		
		export const «componentContainerName» = («IF !root» props «ENDIF») => {
			
			«IF root»
				const [props, setProps] = useState();
				setContainerState = setProps;
							
				if (!props) {
					return null;
				}
				
			«ENDIF»
			«IF hasComplexAttribute»
				return <«componentName» {...props} «actionProps»>
					«FOR attribute: attributes»
						«attribute.renderChildContainer(attributes, exclusiveView)»
					«ENDFOR»
				</«componentName»> 
			«ELSEIF tree»				
				return <«componentName» {...props} «actionProps»>
					{ props.«name» ? props.«name».map((item, index) => <«componentContainerName» {...item} key={item.«keyAttributeName»} depth={props.depth+1} index={index} «fromParentTreeProps» «storageAndLocationPart» />) : [] }
				</«componentName»> 
			«ELSE»
				return <«componentName» {...props} «actionProps» /> 
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	def renderChild(ClientAttribute it) '''
		«IF attributes.size == 0 && !isTag»
			<li>«name.toFirstLower»: {props.«name.toFirstLower» !== null && props.«name.toFirstLower» !== undefined ? props.«name.toFirstLower».toString() : ""}</li>
		«ENDIF»
	'''
	
	def renderChildContainer(ClientAttribute it, List<ClientAttribute> parentAttributes, boolean parentIsGroup) '''
		«IF isTag»
			<«componentName» «props(parentAttributes)» «actionProps» />
		«ELSEIF isComponent»
			«IF !list && !tree»
				«IF parentIsGroup»
					{ props.«name» && <«componentContainerName» «props(parentAttributes)» «actionProps» /> }
				«ELSE»
					<«componentContainerName» «props(parentAttributes)» «actionProps» />
				«ENDIF»
			«ELSE»
				{ props.«name» ? props.«name».map((item, index) => <«componentContainerName» {...item} key={item.«keyAttributeName»} «IF isList»index={index} «parentPart(parentAttributes)» «ELSE»depth={1} index={index} «fromParentTreeProps» «ENDIF»«storageAndLocationPart» «actionProps» />) : [] }
			«ENDIF»
		«ENDIF»
	'''
	
	def props(ClientAttribute it, List<ClientAttribute> parentAttributes) '''{...props.«name.toFirstLower» } «storageAndLocationPart» «parentPart(parentAttributes)»'''
	
	def storageAndLocationPart(ClientAttribute it) '''«FOR attribute: attributes»«IF attribute.storage || attribute.location»«attribute.name.toFirstLower»={«attribute.stateFunctionCall("get", "data")»} «ENDIF»«ENDFOR»'''
	
	def parentPart(ClientAttribute it, List<ClientAttribute> parentAttributes) '''«FOR attribute:attributes»«IF parentAttributes.attributesContain(attribute)»«attribute.name.toFirstLower»={props.«attribute.name.toFirstLower»} «ENDIF»«ENDFOR»'''
	
	def actionProps(ClientAttribute it) '''«FOR action:actions»«action.name»={«action.target.getName.toFirstLower»} «ENDFOR»'''
	
	def fromParentTreeProps(ClientAttribute it) '''«FOR attribute: attributes»«IF attribute.fromParent»«attribute.name.toFirstLower»={props.«attribute.name.toFirstLower»} «ENDIF»«ENDFOR»'''
	
	def CharSequence componentContainerImports(ClientAttribute it, String subFolder) '''
		import { «componentName» } from "«depth("../../")»src/components/«subFolder»«path»«componentName»";
		«FOR attribute : attributes»
			«IF attribute.isTag»
				import { «attribute.componentName» } from "«depth("../../")»src/components/«subFolder»«path»«name.toFirstLower»/«attribute.componentName»";
			«ELSE»
				«attribute.importComponentContainer('''«subFolder»/«name.toFirstLower»''')»
			«ENDIF»
		«ENDFOR»
		«IF oneChildIsLocationOrStorage»
			import * as AppState from "«depth("../../")»src/AppState";
		«ENDIF»
		«FOR action : uniqueActions»
			import { «action.target.name.toFirstLower» } from "«depth("../")»«(action.target.eContainer as HttpClient).name»/ActionFunctions";
		«ENDFOR»
	'''
	
}