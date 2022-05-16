/**
 * generated by Xtext 2.14.0
 */
package de.acegen.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.acegen.AceGenRuntimeModule;
import de.acegen.AceGenStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class AceGenIdeSetup extends AceGenStandaloneSetup {
  @Override
  public Injector createInjector() {
    AceGenRuntimeModule _aceGenRuntimeModule = new AceGenRuntimeModule();
    AceGenIdeModule _aceGenIdeModule = new AceGenIdeModule();
    return Guice.createInjector(Modules2.mixin(_aceGenRuntimeModule, _aceGenIdeModule));
  }
}
