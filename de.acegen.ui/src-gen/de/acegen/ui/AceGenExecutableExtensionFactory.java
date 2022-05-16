/*
 * generated by Xtext 2.26.0
 */
package de.acegen.ui;

import com.google.inject.Injector;
import de.acegen.ui.internal.AcegenActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class AceGenExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(AcegenActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		AcegenActivator activator = AcegenActivator.getInstance();
		return activator != null ? activator.getInjector(AcegenActivator.DE_ACEGEN_ACEGEN) : null;
	}

}
