package com.anfelisa.extensions

import com.anfelisa.ace.Command
import java.util.List
import com.anfelisa.ace.Event
import java.util.ArrayList
import com.anfelisa.ace.Action

class CommandExtension {
	def String abstractCommandName(Command it) '''Abstract«name.toFirstUpper»Command'''

	def String commandName(Command it) '''«name.toFirstUpper»Command'''

	def List<Event> eventsOfCommand(Command it) {
		var list = new ArrayList<Event>();
		for (eventOnOutcome : eventsOnOutcome) {
			for (event : eventOnOutcome.events) {
				if (!list.contains(event)) {
					list.add(event);
				}
			}
		}
		return list;
	}
	
	def List<Action> triggeredActionsOfCommand(Command it) {
		var list = new ArrayList<Action>();
		for (eventOnOutcome : eventsOnOutcome) {
			for (action : eventOnOutcome.actions) {
				if (!list.contains(action)) {
					list.add(action);
				}
			}
		}
		return list;
	}
}
