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


package de.acegen.ui

import com.google.inject.Binder
import de.acegen.generator.ACEOutputConfigurationProvider
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import jakarta.inject.Singleton

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class AceGenUiModule extends AbstractAceGenUiModule {
	
	override void configure(Binder binder) {
	    super.configure(binder);

	    binder.bind(typeof(IOutputConfigurationProvider)).to(typeof(ACEOutputConfigurationProvider)).in(typeof(Singleton));		
	}
}
