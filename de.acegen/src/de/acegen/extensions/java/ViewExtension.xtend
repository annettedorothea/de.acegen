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


 

package de.acegen.extensions.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerView
import de.acegen.aceGen.HttpServerViewFunction

class ViewExtension {
	def String viewName(HttpServerView it) '''«getName.toFirstUpper»View'''
	def String viewInterfaceName(HttpServerView it) '''I«getName.toFirstUpper»View'''
	def String viewNameWithPackage(HttpServerView it) '''«(eContainer as HttpServer).getName».views.«viewName»'''
	def String viewNameAsVariable(HttpServerView it) '''«getName.toFirstLower»View'''
	def String viewFunctionWithViewName(HttpServerViewFunction it) '''«(it.eContainer as HttpServerView).viewName».«getName»'''
	def String viewFunctionWithViewNameAsVariable(HttpServerViewFunction it) '''«(it.eContainer as HttpServerView).viewNameAsVariable».«getName»'''
	def HttpServerView view(HttpServerViewFunction it) {
		return it.eContainer as HttpServerView;
	}
	
}
	
	
/******* S.D.G. *******/
	
	
