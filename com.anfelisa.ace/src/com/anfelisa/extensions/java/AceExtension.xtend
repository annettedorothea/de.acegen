package com.anfelisa.extensions.java

import com.anfelisa.ace.JAVA
import com.anfelisa.ace.JAVA_ACE
import com.anfelisa.ace.JAVA_Outcome
import javax.inject.Inject

class AceExtension {
	
	@Inject
	extension ModelExtension
	
	def String abstractActionName(JAVA_ACE it) '''Abstract«name.toFirstUpper»Action'''
	
	def String actionName(JAVA_ACE it) '''«name.toFirstUpper»Action'''

	def String actionNameWithPackage(JAVA_ACE it, JAVA java) '''«java.name».actions.«actionName»'''
	
	def String abstractName(JAVA_ACE it) '''Abstract«name.toFirstUpper»'''
	
	def String nameUppercase(JAVA_ACE it) '''«name.toFirstUpper»'''
	
	def String resourceName(JAVA_ACE it) '''«name.toFirstUpper»Resource'''
	
	def String actionNameWithPackage(JAVA_ACE it) '''«(eContainer as JAVA).name».actions.«actionName»'''
	
	def String newAction(JAVA_ACE it) '''final «actionNameWithPackage» action = new «actionNameWithPackage»(«model.newFromCommandData», DatabaseService.getDatabaseHandle());'''
	
	def String abstractCommandName(JAVA_ACE it) '''Abstract«name.toFirstUpper»Command'''

	def String commandName(JAVA_ACE it) '''«name.toFirstUpper»Command'''

	def String commandNameWithPackage(JAVA_ACE it, JAVA java) '''«java.name».commands.«commandName»'''

	def String eventName(JAVA_ACE it, JAVA_Outcome outcome) '''«name.toFirstUpper»«outcome.name.toFirstUpper»Event'''

	def String eventNameWithPackage(JAVA_ACE it, JAVA_Outcome outcome) '''«(eContainer as JAVA).name».events.«eventName(outcome)»'''

	def String responseDataName(JAVA_ACE  it) '''«name.toFirstUpper»Response'''
	def String responseDataNameWithPackage(JAVA_ACE  it, JAVA java) '''«java.name».data.«name.toFirstUpper»Response'''
	def String responseDataInterfaceName(JAVA_ACE it) '''I«name.toFirstUpper»Response'''
	
}