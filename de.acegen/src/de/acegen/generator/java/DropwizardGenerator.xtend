package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.JavaExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.DropwizardApp
import de.acegen.templates.java.DropwizardAppRegistration
import de.acegen.templates.java.DropwizardConfiguration
import de.acegen.templates.java.DropwizardEventReplayCommand
import de.acegen.templates.java.DropwizardResource
import de.acegen.templates.java.resources.GetServerInfoResource
import de.acegen.templates.java.resources.GetServerTimelineResource
import de.acegen.templates.java.resources.NotReplayableDataProviderResource
import de.acegen.templates.java.resources.PrepareE2EResource
import de.acegen.templates.java.resources.Resource
import de.acegen.templates.java.resources.StartE2ESessionResource
import de.acegen.templates.java.resources.StopE2ESessionResource
import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2

class DropwizardGenerator {

	@Inject
	StartE2ESessionResource startE2ESessionResource;

	@Inject
	StopE2ESessionResource stopE2ESessionResource;

	@Inject
	PrepareE2EResource prepareE2EResource;

	@Inject
	GetServerTimelineResource getServerTimelineResource;

	@Inject
	GetServerInfoResource getServerInfoResource;

	@Inject
	Resource resource;

	@Inject
	DropwizardApp dropwizardApp;

	@Inject
	DropwizardConfiguration dropwizardConfiguration;

	@Inject
	NotReplayableDataProviderResource notReplayableDataProviderResource;

	@Inject
	DropwizardEventReplayCommand dropwizardEventReplayCommand;

	@Inject
	DropwizardResource dropwizardResource;

	@Inject
	DropwizardAppRegistration dropwizardAppRegistration;

	@Inject
	extension JavaExtension

	@Inject
	extension AceExtension

	def void doGenerate(HttpServer httpServer, IFileSystemAccess2 fsa) {
		var authUser = httpServer.getAuthUser
		if (authUser === null) {
			authUser = httpServer.getAuthUserRef
		}
		for (ace : httpServer.aceOperations) {
			fsa.generateFile(httpServer.packageFolder + '/resources/' + ace.resourceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, resource.generate(ace, httpServer, authUser));
		}
		fsa.generateFile("de/acegen/resources/StartE2ESessionResource.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, startE2ESessionResource.generate());
		fsa.generateFile("de/acegen/resources/StopE2ESessionResource.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, stopE2ESessionResource.generate());
		fsa.generateFile("de/acegen/resources/PrepareE2EResource.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, prepareE2EResource.generate());
		fsa.generateFile("de/acegen/resources/GetServerTimelineResource.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, getServerTimelineResource.generate());
		fsa.generateFile("de/acegen/resources/GetServerInfoResource.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, getServerInfoResource.generate());
		fsa.generateFile("de/acegen/resources/NotReplayableDataProviderResource.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, notReplayableDataProviderResource.generate());

		fsa.generateFile("de/acegen/App.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			dropwizardApp.generate());
		fsa.generateFile("de/acegen/CustomAppConfiguration.java",
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, dropwizardConfiguration.generateCustomAppConfiguration());
		fsa.generateFile("de/acegen/AppConfiguration.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			dropwizardConfiguration.generateAppConfiguration());
		fsa.generateFile("de/acegen/Config.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			dropwizardConfiguration.generateConfig());
		fsa.generateFile("de/acegen/EventReplayCommand.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			dropwizardEventReplayCommand.generateEventReplayCommand());
		fsa.generateFile("de/acegen/Resource.java", ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			dropwizardResource.generateDropwizardResource());
		fsa.generateFile(httpServer.packageFolder + '/AppRegistration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, dropwizardAppRegistration.generateAppRegistration(httpServer));
		fsa.generateFile("de/acegen" + '/AppRegistration.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			dropwizardAppRegistration.generateAppRegistration());
	}

}
