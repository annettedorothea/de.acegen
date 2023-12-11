/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


package de.acegen.templates.java

import de.acegen.extensions.CommonExtension

class AceOperation {
	
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen;
		
		public class AceOperation {
		
			private ITimelineItem action;
			private ITimelineItem command;
			private ITimelineItem event;
			private String uuid;
		
			public AceOperation(String uuid) {
				super();
				this.uuid = uuid;
			}
			public ITimelineItem getAction() {
				return action;
			}
			public ITimelineItem getCommand() {
				return command;
			}
			public ITimelineItem getEvent() {
				return event;
			}
			public void setAction(ITimelineItem action) {
				this.action = action;
			}
			public void setCommand(ITimelineItem command) {
				this.command = command;
			}
			public void setEvent(ITimelineItem event) {
				this.event = event;
			}
			public String getUuid() {
				return uuid;
			}
			
		}
		
		«sdg»
		
	'''

}