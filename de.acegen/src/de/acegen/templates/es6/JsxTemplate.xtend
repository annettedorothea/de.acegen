package de.acegen.templates.es6

import de.acegen.aceGen.ClientAttribute
import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class JsxTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	def dispatch generateComponentStruct(SingleClientAttribute it, String folderPrefix) '''
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
	
	def dispatch generateComponentStruct(GroupedClientAttribute it, String folderPrefix) '''
		«copyright»

		import React from "react";

		«componentImports("")»
		
		export const «componentName» = (props) => {
			«FOR attribute: attributeGroup»
				if (props.is«attribute.name.toFirstUpper» === true) {
					return <«attribute.componentName» {...props}/>;
				}
			«ENDFOR»
			return null;
		}
		
		«sdg»
		
	'''
	
	def dispatch renderChild(SingleClientAttribute it) '''
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
	
	def dispatch renderChild(GroupedClientAttribute it) '''
		<«componentName» {...props} />
	'''
	
	def dispatch CharSequence componentImports(ClientAttribute it, String subFolder) '''
	'''
	
	def dispatch CharSequence componentImports(SingleClientAttribute it, String subFolder) '''
		«FOR attribute : attributes»
			«attribute.importComponent('''«subFolder»/«name.toFirstLower»''')»
		«ENDFOR»
	''' 
	
	def dispatch CharSequence componentImports(GroupedClientAttribute it, String subFolder) '''
		«FOR attribute: attributeGroup»
			«attribute.importComponent('''«subFolder»/«name.toFirstLower»''')»
		«ENDFOR»
	'''
	
}