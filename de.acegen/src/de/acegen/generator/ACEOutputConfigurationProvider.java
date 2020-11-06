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

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		defaultOutput.setDescription("generated JavaScript sources");
		defaultOutput.setOutputDirectory("./es6/gen/");
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(true);
		defaultOutput.setSetDerivedProperty(true);

		OutputConfiguration onceOutput = new OutputConfiguration(DEFAULT_JAVASCRIPT_OUTPUT_ONCE);
		onceOutput.setDescription("initial JavaScript sources");
		onceOutput.setOutputDirectory("./es6/src/");
		onceOutput.setOverrideExistingResources(false);
		onceOutput.setCreateOutputDirectory(true);
		onceOutput.setCleanUpDerivedResources(false);
		onceOutput.setSetDerivedProperty(false);

		OutputConfiguration testOutput = new OutputConfiguration(DEFAULT_JAVASCRIPT_TEST_OUTPUT);
		testOutput.setDescription("generated JavaScript test sources");
		testOutput.setOutputDirectory("./es6/test/gen/");
		testOutput.setOverrideExistingResources(true);
		testOutput.setCreateOutputDirectory(true);
		testOutput.setCleanUpDerivedResources(true);
		testOutput.setSetDerivedProperty(true);
		
		OutputConfiguration onceTestOutput = new OutputConfiguration(DEFAULT_JAVASCRIPT_TEST_OUTPUT_ONCE);
		onceTestOutput.setDescription("initial JavaScript test sources");
		onceTestOutput.setOutputDirectory("./es6/test/scr/");
		onceTestOutput.setOverrideExistingResources(false);
		onceTestOutput.setCreateOutputDirectory(true);
		onceTestOutput.setCleanUpDerivedResources(false);
		onceTestOutput.setSetDerivedProperty(false);
		
		OutputConfiguration defaultJavaOutput = new OutputConfiguration(DEFAULT_JAVA_OUTPUT);
		defaultJavaOutput.setDescription("generated Java sources");
		defaultJavaOutput.setOutputDirectory("./src/gen/java/");
		defaultJavaOutput.setOverrideExistingResources(true);
		defaultJavaOutput.setCreateOutputDirectory(true);
		defaultJavaOutput.setCleanUpDerivedResources(true);
		defaultJavaOutput.setSetDerivedProperty(true);

		OutputConfiguration defaultResourceOutput = new OutputConfiguration(DEFAULT_RESOURCE_OUTPUT);
		defaultResourceOutput.setDescription("generated resources sources");
		defaultResourceOutput.setOutputDirectory("./src/gen/resources/");
		defaultResourceOutput.setOverrideExistingResources(true);
		defaultResourceOutput.setCreateOutputDirectory(true);
		defaultResourceOutput.setCleanUpDerivedResources(true);
		defaultResourceOutput.setSetDerivedProperty(true);

		OutputConfiguration onceJavaOutput = new OutputConfiguration(DEFAULT_JAVA_OUTPUT_ONCE);
		onceJavaOutput.setDescription("initial Java sources");
		onceJavaOutput.setOutputDirectory("./src/main/java/");
		onceJavaOutput.setOverrideExistingResources(false);
		onceJavaOutput.setCreateOutputDirectory(true);
		onceJavaOutput.setCleanUpDerivedResources(false);
		onceJavaOutput.setSetDerivedProperty(false);

		OutputConfiguration onceJavaTestOutput = new OutputConfiguration(DEFAULT_JAVA_TEST_OUTPUT_ONCE);
		onceJavaTestOutput.setDescription("initial Java test sources");
		onceJavaTestOutput.setOutputDirectory("./src/test/java/");
		onceJavaTestOutput.setOverrideExistingResources(false);
		onceJavaTestOutput.setCreateOutputDirectory(true);
		onceJavaTestOutput.setCleanUpDerivedResources(false);
		onceJavaTestOutput.setSetDerivedProperty(false);

		OutputConfiguration javaTestOutput = new OutputConfiguration(DEFAULT_JAVA_TEST_OUTPUT);
		javaTestOutput.setDescription("Java test sources");
		javaTestOutput.setOutputDirectory("./src/test/gen/");
		javaTestOutput.setOverrideExistingResources(true);
		javaTestOutput.setCreateOutputDirectory(true);
		javaTestOutput.setCleanUpDerivedResources(true);
		javaTestOutput.setSetDerivedProperty(true);

		return newHashSet(
				defaultOutput, 
				onceOutput, 
				defaultJavaOutput, 
				onceJavaOutput, 
				defaultResourceOutput,
				onceJavaTestOutput, 
				javaTestOutput);
	}

}

/******* S.D.G. *******/
