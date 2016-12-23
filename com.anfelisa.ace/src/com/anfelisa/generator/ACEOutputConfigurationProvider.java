package com.anfelisa.generator;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

public class ACEOutputConfigurationProvider implements IOutputConfigurationProvider {

	public final static String DEFAULT_JAVASCRIPT_OUTPUT_ONCE = "DEFAULT_JAVASCRIPT_OUTPUT_ONCE";
	public final static String DEFAULT_JAVA_OUTPUT = "DEFAULT_JAVA_OUTPUT";
	public final static String DEFAULT_RESOURCE_OUTPUT = "DEFAULT_RESOURCE_OUTPUT";
	public final static String DEFAULT_JAVA_OUTPUT_ONCE = "DEFAULT_JAVA_OUTPUT_ONCE";

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
		onceOutput.setOutputDirectory("./es6/");
		onceOutput.setOverrideExistingResources(false);
		onceOutput.setCreateOutputDirectory(true);
		onceOutput.setCleanUpDerivedResources(false);
		onceOutput.setSetDerivedProperty(false);
		
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
		
		return newHashSet(defaultOutput, onceOutput, defaultJavaOutput, onceJavaOutput, defaultResourceOutput);
	}

}