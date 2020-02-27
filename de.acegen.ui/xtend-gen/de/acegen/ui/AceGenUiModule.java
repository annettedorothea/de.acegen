/**
 * generated by Xtext 2.14.0
 */
package de.acegen.ui;

import com.google.inject.Binder;
import de.acegen.generator.ACEOutputConfigurationProvider;
import de.acegen.ui.AbstractAceGenUiModule;
import javax.inject.Singleton;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class AceGenUiModule extends AbstractAceGenUiModule {
  @Override
  public void configure(final Binder binder) {
    super.configure(binder);
    binder.<IOutputConfigurationProvider>bind(IOutputConfigurationProvider.class).to(ACEOutputConfigurationProvider.class).in(Singleton.class);
  }
  
  public AceGenUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}