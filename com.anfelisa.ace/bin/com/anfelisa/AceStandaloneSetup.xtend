/*
 * generated by Xtext 2.10.0
 */
package com.anfelisa


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class AceStandaloneSetup extends AceStandaloneSetupGenerated {

	def static void doSetup() {
		new AceStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
