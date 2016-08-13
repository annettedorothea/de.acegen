package com.anfelisa.generator;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

public class ACEOutputConfigurationProvider implements IOutputConfigurationProvider {

	public final static String DEFAULT_JAVASCRIPT_OUTPUT_ONCE = "DEFAULT_JAVASCRIPT_OUTPUT_ONCE";
	public final static String DEFAULT_PHP_OUTPUT = "DEFAULT_PHP_OUTPUT";
	public final static String DEFAULT_PHP_OUTPUT_ONCE = "DEFAULT_PHP_OUTPUT_ONCE";

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
		
		OutputConfiguration defaultPhpOutput = new OutputConfiguration(DEFAULT_PHP_OUTPUT);
		defaultPhpOutput.setDescription("generated PHP sources");
		defaultPhpOutput.setOutputDirectory("./php/gen/");
		defaultPhpOutput.setOverrideExistingResources(true);
		defaultPhpOutput.setCreateOutputDirectory(true);
		defaultPhpOutput.setCleanUpDerivedResources(true);
		defaultPhpOutput.setSetDerivedProperty(true);
		
		OutputConfiguration oncePhpOutput = new OutputConfiguration(DEFAULT_PHP_OUTPUT_ONCE);
		oncePhpOutput.setDescription("initial PHP sources");
		oncePhpOutput.setOutputDirectory("./php/");
		oncePhpOutput.setOverrideExistingResources(false);
		oncePhpOutput.setCreateOutputDirectory(true);
		oncePhpOutput.setCleanUpDerivedResources(false);
		oncePhpOutput.setSetDerivedProperty(false);
		
		return newHashSet(defaultOutput, onceOutput, defaultPhpOutput, oncePhpOutput);
	}

}