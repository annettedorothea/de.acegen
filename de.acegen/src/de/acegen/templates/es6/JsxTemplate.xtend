package de.acegen.templates.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class JsxTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	def generateComponentStruct(ClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import React from "react";
		
		«componentImports("")»
		
		export const «componentName» = (props) => {
			const json = JSON.stringify(props, null, '\t');
			return <div>
				«FOR attribute: attributes»
					«attribute.renderChild»
				«ENDFOR»
				<pre>{json}</pre>
			</div> 
		}
		
		«sdg»
		
	'''
	
	def renderChild(ClientAttribute it) '''
		«IF !noComponent && attributes.size > 0»
			«IF list»
				{ props.«name» ? props.«name».map(i => <«componentName» {...i} />) : [] }
			«ELSE»
				<«componentName» {...props.«name.toFirstLower»} />
			«ENDIF»
		«ELSEIF noComponent && attributes.size > 0»
			{props.«name.toFirstLower» && <div>
				«FOR attribute: attributes»
					<div>{props.«name.toFirstLower».«attribute.name.toFirstLower»}</div>
				«ENDFOR»
			</div>}
		«ELSE»
			<div>{props.«name.toFirstLower»}</div>
		«ENDIF»
	'''
	
	def CharSequence componentImports(ClientAttribute it, String subFolder) '''
		«FOR attribute : attributes»
			«attribute.importComponent('''«subFolder»/«name.toFirstLower»''')»
		«ENDFOR»
	''' 
	
}