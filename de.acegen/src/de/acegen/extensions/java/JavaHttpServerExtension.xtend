package de.acegen.extensions.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import java.util.ArrayList
import javax.inject.Inject

class JavaHttpServerExtension {
	@Inject
	extension AttributeExtension

	def String packageFolder(HttpServer it) '''«getName.replace('.', '/')»'''

	def String projectName(HttpServer it) '''«getName.toFirstUpper»'''

	def String fileExtension() '''.java'''

	def String abstractActionName(HttpServerAce it) '''Abstract«getName.toFirstUpper»Action'''

	def String actionName(HttpServerAce it) '''«getName.toFirstUpper»Action'''

	def String actionNameWithPackage(HttpServerAce it) '''«(eContainer as HttpServer).name».actions.«actionName»'''

	def String abstractName(HttpServerAce it) '''Abstract«getName.toFirstUpper»'''

	def String nameUppercase(HttpServerAce it) '''«getName.toFirstUpper»'''

	def String resourceName(HttpServerAce it) '''«getName.toFirstUpper»Resource'''

	def String abstractCommandName(HttpServerAce it) '''Abstract«getName.toFirstUpper»Command'''

	def String commandName(HttpServerAce it) '''«getName.toFirstUpper»Command'''

	def String commandNameWithPackage(HttpServerAce it) '''«(eContainer as HttpServer).name».commands.«commandName»'''

	def String eventName(HttpServerAce it,
		HttpServerOutcome outcome) '''«getName.toFirstUpper»«outcome.getName.toFirstUpper»Event'''

	def String eventNameWithPackage(HttpServerAce it,
		HttpServerOutcome outcome) '''«(eContainer as HttpServer).getName».events.«eventName(outcome)»'''

	def String responseDataName(HttpServerAce it) '''«getName.toFirstUpper»Response'''

	def String responseDataNameWithPackage(
		HttpServerAce it) '''«(eContainer as HttpServer).name».data.«getName.toFirstUpper»Response'''

	def String responseDataInterfaceName(HttpServerAce it) '''I«name.toFirstUpper»Response'''

	def String payloadDataName(HttpServerAce it) '''«getName.toFirstUpper»Payload'''

	def String payloadDataNameWithPackage(
		HttpServerAce it) '''«(eContainer as HttpServer).name».data.«getName.toFirstUpper»Payload'''

	def String payloadDataInterfaceName(HttpServerAce it) '''I«name.toFirstUpper»Payload'''

	def boolean isRead(HttpServerAce it) {
		return it instanceof HttpServerAceRead
	}

	def String packageFor(HttpServerAce it) {
		val java = eContainer as HttpServer;
		return '''«java.getName»'''
	}

	def String urlWithPathParams(HttpServerAce it, String dataVarName, boolean generateQueryParams) {
		if (pathParams.size == 0) {
			var retUrl = url +
				'''«IF generateQueryParams»«FOR queryParam : queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=" + «IF queryParam.attribute.type == "String"»«urlEncodedValue('''«dataVarName».«queryParam.attribute.getterCall»''')»«ELSE»«dataVarName».«queryParam.attribute.getterCall»«ENDIF» + "«ENDFOR»«ENDIF»'''
			return retUrl
		}
		val split1 = getUrl.split('\\{')
		var urlElements = new ArrayList();
		for (split : split1) {
			val split2 = split.split('\\}');
			urlElements.addAll(split2)
		}
		var urlWithPathParam = "";
		for (var i = 0; i < urlElements.size; i++) {
			if (i % 2 == 0) {
				urlWithPathParam += urlElements.get(i)
			} else {
				urlWithPathParam +=
					'''" + «urlEncodedValue('''«dataVarName».get«urlElements.get(i).toFirstUpper»()''')» + "'''
			}
		}
		urlWithPathParam +=
			'''«IF generateQueryParams»«FOR queryParam : queryParams BEFORE "?" SEPARATOR "&"»«queryParam.attribute.name»=" + «urlEncodedValue('''«dataVarName».«queryParam.attribute.getterCall»''')» + "«ENDFOR»«ENDIF»'''
		return urlWithPathParam;
	}

	def String urlEncodedValue(
		String valueVar) '''(«valueVar» != null ? URLEncoder.encode(«valueVar», StandardCharsets.UTF_8.toString()) : "")'''

}
