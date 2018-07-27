package com.anfelisa.extensions

import com.anfelisa.ace.ACE
import com.anfelisa.ace.Outcome
import com.anfelisa.ace.Project
import com.anfelisa.ace.View
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class AceExtension {
	@Inject
	extension DataExtension
	
	def String abstractActionName(ACE it) '''Abstract«name.toFirstUpper»Action'''
	
	def String actionName(ACE it) '''«name.toFirstUpper»Action'''
	
	def String abstractName(ACE it) '''Abstract«name.toFirstUpper»'''
	
	def String nameUppercase(ACE it) '''«name.toFirstUpper»'''
	
	def String resourceName(ACE it) '''«name.toFirstUpper»Resource'''
	
	def String actionNameWithPackage(ACE it) '''«(eContainer as Project).name».actions.«actionName»'''
	
	def String newAction(ACE it) '''final «actionNameWithPackage» action = new «actionNameWithPackage»(«data.newFromCommandData», DatabaseService.getDatabaseHandle());'''
	
	def List<View> preAndPostUpdateUIViews(ACE it) {
		var list = new ArrayList<View>();
		for (viewFuction : preUpdateUI) {
			val view = viewFuction.eContainer as View;		
			if (!list.contains(view)) {
				list.add(view);
			}
		}
		for (viewFuction : postUpdateUI) {
			val view = viewFuction.eContainer as View;		
			if (!list.contains(view)) {
				list.add(view);
			}
		}
		return list;
	}
	
	def String abstractCommandName(ACE it) '''Abstract«name.toFirstUpper»Command'''

	def String commandName(ACE it) '''«name.toFirstUpper»Command'''

	def List<ACE> triggeredAceOperations(ACE it) {
		var list = new ArrayList<ACE>();
		for (outcome : outcomes) {
			for (aceOperation : outcome.aceOperations) {
				if (!list.contains(aceOperation)) {
					list.add(aceOperation);
				}
			}
		}
		return list;
	}
	
	def String eventName(ACE it, Outcome outcome) '''«name.toFirstUpper»«outcome.name.toFirstUpper»Event'''
	def String eventNameWithPackage(ACE it, Outcome outcome) '''«(eContainer as Project).name».events.«eventName(outcome)»'''
	
}