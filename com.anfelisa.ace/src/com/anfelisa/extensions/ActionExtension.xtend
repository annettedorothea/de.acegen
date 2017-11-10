package com.anfelisa.extensions

import com.anfelisa.ace.Action
import com.anfelisa.ace.Project
import javax.inject.Inject
import java.util.List
import com.anfelisa.ace.View
import java.util.ArrayList

class ActionExtension {
	
	@Inject
	extension DataExtension
	
	def String abstractActionName(Action it) '''Abstract«name.toFirstUpper»Action'''
	
	def String actionName(Action it) '''«name.toFirstUpper»Action'''
	
	def String abstractName(Action it) '''Abstract«name.toFirstUpper»'''
	
	def String nameUppercase(Action it) '''«name.toFirstUpper»'''
	
	def String resourceName(Action it) '''«name.toFirstUpper»Resource'''
	
	def String actionNameWithPackage(Action it) '''«(eContainer as Project).name».actions.«actionName»'''
	
	def String newAction(
		Action it) '''final «actionNameWithPackage» action = new «actionNameWithPackage»(«data.newFromCommandData», DatabaseService.getDatabaseHandle());'''
	
	def List<View> preAndPostUpdateUIViews(Action it) {
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
}
