/*
 * generated by Xtext 2.16.0
 */
package de.acegen.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractAceGenValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(de.acegen.aceGen.AceGenPackage.eINSTANCE);
		return result;
	}
}
