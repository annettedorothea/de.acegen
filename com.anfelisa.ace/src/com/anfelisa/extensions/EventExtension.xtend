package com.anfelisa.extensions

import com.anfelisa.ace.Event
import com.anfelisa.ace.Project

class EventExtension {
	def String eventName(Event it) '''«name.toFirstUpper»Event'''
	def String abstractEventName(Event it) '''Abstract«name.toFirstUpper»Event'''
	def String eventNameWithPackage(Event it) '''«(eContainer as Project).name».events.«eventName»'''
	
}