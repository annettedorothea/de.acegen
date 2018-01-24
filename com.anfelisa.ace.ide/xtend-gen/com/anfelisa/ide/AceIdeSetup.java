/**
 * generated by Xtext 2.12.0
 */
package com.anfelisa.ide;

import com.anfelisa.AceRuntimeModule;
import com.anfelisa.AceStandaloneSetup;
import com.anfelisa.ide.AceIdeModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class AceIdeSetup extends AceStandaloneSetup {
  @Override
  public Injector createInjector() {
    AceRuntimeModule _aceRuntimeModule = new AceRuntimeModule();
    AceIdeModule _aceIdeModule = new AceIdeModule();
    return Guice.createInjector(Modules2.mixin(_aceRuntimeModule, _aceIdeModule));
  }
}