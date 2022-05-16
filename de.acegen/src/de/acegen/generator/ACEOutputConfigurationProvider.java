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



package de.acegen.generator;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

public class ACEOutputConfigurationProvider implements IOutputConfigurationProvider {

	public final static String DEFAULT_JAVASCRIPT_OUTPUT_ONCE = "DEFAULT_JAVASCRIPT_OUTPUT_ONCE";
	public final static String DEFAULT_JAVASCRIPT_TEST_OUTPUT = "DEFAULT_JAVASCRIPT_TEST_OUTPUT";
	public final static String DEFAULT_JAVASCRIPT_TEST_OUTPUT_ONCE = "DEFAULT_JAVASCRIPT_TEST_OUTPUT_ONCE";
	
	public final static String DEFAULT_JAVA_OUTPUT = "DEFAULT_JAVA_OUTPUT";
	public final static String DEFAULT_RESOURCE_OUTPUT = "DEFAULT_RESOURCE_OUTPUT";
	public final static String DEFAULT_JAVA_OUTPUT_ONCE = "DEFAULT_JAVA_OUTPUT_ONCE";
	public final static String DEFAULT_JAVA_TEST_OUTPUT_ONCE = "DEFAULT_JAVA_TEST_OUTPUT_ONCE";
	public final static String DEFAULT_JAVA_TEST_OUTPUT = "DEFAULT_JAVA_TEST_OUTPUT";

	public final static String DEFAULT_CS_OUTPUT = "DEFAULT_CS_OUTPUT";
	public final static String DEFAULT_CS_OUTPUT_ONCE = "DEFAULT_CS_OUTPUT_ONCE";
	public final static String DEFAULT_CS_TEST_OUTPUT_ONCE = "DEFAULT_CS_TEST_OUTPUT_ONCE";
	public final static String DEFAULT_CS_TEST_OUTPUT = "DEFAULT_CS_TEST_OUTPUT";
	
	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {

		OutputConfiguration defaultOutput = createOutpout(IFileSystemAccess.DEFAULT_OUTPUT, "generated JavaScript sources", "./es6/gen/");
		OutputConfiguration testOutput = createOutpout(DEFAULT_JAVASCRIPT_TEST_OUTPUT, "generated JavaScript test sources", "./spec/gen/");

		OutputConfiguration onceOutput = createOutpoutOnce(DEFAULT_JAVASCRIPT_OUTPUT_ONCE, "initial JavaScript sources", "./es6/src/");
		OutputConfiguration onceTestOutput = createOutpoutOnce(DEFAULT_JAVASCRIPT_TEST_OUTPUT_ONCE, "initial JavaScript test sources", "./spec/src/");
		
		
		OutputConfiguration defaultJavaOutput = createOutpout(DEFAULT_JAVA_OUTPUT, "generated Java sources", "./src/gen/java/");
		OutputConfiguration defaultResourceOutput = createOutpout(DEFAULT_RESOURCE_OUTPUT, "generated resources", "./src/gen/resources/");
		OutputConfiguration javaTestOutput = createOutpout(DEFAULT_JAVA_TEST_OUTPUT, "generated Java test sources", "./src/test/gen/");

		OutputConfiguration onceJavaOutput = createOutpoutOnce(DEFAULT_JAVA_OUTPUT_ONCE, "initial Java sources", "./src/main/java/");
		OutputConfiguration onceJavaTestOutput = createOutpoutOnce(DEFAULT_JAVA_TEST_OUTPUT_ONCE, "initial Java test sources", "./src/test/java/");

		OutputConfiguration defaultCsOutput = createOutpout(DEFAULT_CS_OUTPUT, "generated C# sources", "./Api/Generated");
		OutputConfiguration csTestOutput = createOutpout(DEFAULT_CS_TEST_OUTPUT, "generated C# test sources", "./Api.Tests/Generated");
		
		OutputConfiguration onceCsOutput = createOutpoutOnce(DEFAULT_CS_OUTPUT_ONCE, "initial C# sources", "./Api/Source");
		OutputConfiguration onceCsTestOutput = createOutpoutOnce(DEFAULT_CS_TEST_OUTPUT_ONCE, "initial C# test sources", "./Api.Tests/Source");
		
		return newHashSet(
				defaultOutput, 
				onceOutput, 
				defaultJavaOutput, 
				onceJavaOutput, 
				defaultResourceOutput,
				onceJavaTestOutput, 
				javaTestOutput,
				onceTestOutput,
				testOutput,
				defaultCsOutput,
				csTestOutput,
				onceCsOutput,
				onceCsTestOutput);
	}
	
	private OutputConfiguration createOutpout(String name, String description, String outputDirectory) {
		OutputConfiguration outputConfiguration = new OutputConfiguration(name);
		outputConfiguration.setDescription(description);
		outputConfiguration.setOutputDirectory(outputDirectory);
		outputConfiguration.setOverrideExistingResources(true);
		outputConfiguration.setCreateOutputDirectory(true);
		outputConfiguration.setCleanUpDerivedResources(true);
		outputConfiguration.setSetDerivedProperty(true);
		return outputConfiguration;
	}

	private OutputConfiguration createOutpoutOnce(String name, String description, String outputDirectory) {
		OutputConfiguration outputConfiguration = new OutputConfiguration(name);
		outputConfiguration.setDescription(description);
		outputConfiguration.setOutputDirectory(outputDirectory);
		outputConfiguration.setOverrideExistingResources(false);
		outputConfiguration.setCreateOutputDirectory(true);
		outputConfiguration.setCleanUpDerivedResources(false);
		outputConfiguration.setSetDerivedProperty(false);
		return outputConfiguration;
	}
	
}

/******* S.D.G. *******/
