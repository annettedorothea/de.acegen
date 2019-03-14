package de.acegen.templates.java

import de.acegen.aceGen.AttributeDefinition
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.Scenario
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class ScenarioTemplate {

	@Inject
	extension ModelExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension AceExtension

	@Inject
	extension CommonExtension

	def generateScenario(Scenario it, HttpServer java) '''
		«copyright»
		
		package «java.getName».scenarios;
		
		import java.util.ArrayList;
		import java.util.List;
		
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.format.DateTimeFormat;
		
		import org.junit.Test;
		
		import com.anfelisa.ace.BaseScenario;
		import com.anfelisa.ace.ITimelineItem;
		import com.anfelisa.todo.TestUtils;
		import com.anfelisa.todo.ActionCalls;
		
		import static org.hamcrest.MatcherAssert.assertThat;
		import static org.hamcrest.Matchers.is;
		
		public class «name»Scenario extends BaseScenario {
		
			private void given() throws Exception {
				List<ITimelineItem> timeline = new ArrayList<>();
				
				«FOR scenarioEvent : events»
					timeline.add(TestUtils.create«(scenarioEvent.outcome.eContainer as HttpServerAceWrite).eventName(scenarioEvent.outcome)»TimelineItem(
						new «(scenarioEvent.outcome.eContainer as HttpServerAceWrite).model.dataNameWithPackage»("«scenarioEvent.dataDefinition.uuid»")
						«FOR attributeDefinition : scenarioEvent.dataDefinition.data.attributeDefinitions»
							.with«attributeDefinition.attribute.name.toFirstUpper»(«value(attributeDefinition)»)
						«ENDFOR»
					));
					
				«ENDFOR»
				prepare(timeline, DROPWIZARD.getLocalPort());
			}
			
			@Test
			public void execute() throws Exception {
				given();
				
				«generateActionCalls(it.action, it, java)»
		
			}
			
			
		}
		
		
		«sdg»
		
	'''

	def generateActionCalls(HttpServerAce aceOperation, Scenario it, HttpServer java) '''
		«IF aceOperation.getType == "POST"»
			Response response = ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPostCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ELSEIF aceOperation.getType == "PUT"»
			Response response = ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForPutCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ELSEIF aceOperation.getType == "DELETE"»
			Response response = ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForDeleteCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ELSE»
			Response response = ActionCalls.call«aceOperation.getName.toFirstUpper»(«FOR param : mergeAttributesForGetCall(aceOperation, dataDefinition) SEPARATOR ', '»«param»«ENDFOR»«IF aceOperation.isAuthorize», authorization(«authorization.username», «authorization.password»)«ENDIF»);
		«ENDIF»
		
		«IF statusCode !== 0»
			assertThat(response.getStatus(), is(«statusCode»));
		«ENDIF»
		
		«IF response !== null»
			«aceOperation.responseDataNameWithPackage(java)» expected = new «aceOperation.responseDataNameWithPackage(java)»();
			«aceOperation.responseDataNameWithPackage(java)» actual = response.readEntity(«aceOperation.responseDataNameWithPackage(java)».class);
			assertThat(actual, is(expected));
		«ENDIF»
		
	'''
	
	private def value(AttributeDefinition it) {
		if (value.stringValue !== null) {
			if (attribute.type == "DateTime") {
				return '''DateTime.parse("«value.stringValue»", DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss"))'''
			}
			if (attribute.type == "Integer") {
				return '''Integer.parseInt("«value.stringValue»")'''
			}
			if (attribute.type == "Float") {
				return '''Float.parseFloat("«value.stringValue»")'''
			}
			if (attribute.type == "Boolean") {
				return '''new Boolean("«value.stringValue»")'''
			}
			if (attribute.type == "Long") {
				return '''Long.parseLong("«value.stringValue»")'''
			}
			return '''"«value.stringValue»"'''
		}
		if (value.attributeDefinitionList !== null) {
			return null
		}
		if (value.listAttributeDefinitionList !== null) {
			return null
		}
		return value.intValue
	}

	def generateBaseScenario() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Jdbi;
		import org.junit.After;
		import org.junit.AfterClass;
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.mockito.MockitoAnnotations;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.anfelisa.ace.AbstractBaseScenario;
		import com.anfelisa.ace.App;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.DaoProvider;
		
		import io.dropwizard.jdbi3.JdbiFactory;
		import io.dropwizard.testing.DropwizardTestSupport;
		
		public class BaseScenario extends AbstractBaseScenario {
		
			static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);
		
			public static final DropwizardTestSupport<CustomAppConfiguration> DROPWIZARD = new DropwizardTestSupport<CustomAppConfiguration>(
					App.class, "test.yml");
			
			private static Jdbi jdbi;
		
			@BeforeClass
			public static void beforeClass() {
				DROPWIZARD.before();
				final JdbiFactory factory = new JdbiFactory();
				jdbi = factory.build(DROPWIZARD.getEnvironment(), DROPWIZARD.getConfiguration().getDataSourceFactory(), "testdb");
			}
		
			@AfterClass
			public static void afterClass() {
				try {
					DROPWIZARD.after();
				} catch (Exception x) {
					LOG.error("exception when cleaning up dropwizard", x);
				}
			}
		
			@Before
			public void before() {
				daoProvider = new DaoProvider();
				handle = jdbi.open();
				MockitoAnnotations.initMocks(this);
			}
			
			@After
			public void after() {
				handle.close();
			}
			
			@Override
			protected String authorization(String username, String password) {
				return "";
			}
		
		}
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import java.util.ArrayList;
		import java.util.List;
		import java.util.UUID;
		
		import javax.ws.rs.client.Client;
		import javax.ws.rs.client.Entity;
		
		import org.glassfish.jersey.client.JerseyClientBuilder;
		import org.jdbi.v3.core.Handle;
		import org.joda.time.DateTime;
		
		public abstract class AbstractBaseScenario {
		
			protected final JodaObjectMapper mapper = new JodaObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected Handle handle;
		
			public static String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			protected void prepare(List<ITimelineItem> timeline, int port) {
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/replay-events", port))
						.request().put(Entity.json(timeline));
			}
		
			protected void prepare(int port) {
				List<ITimelineItem> timeline = new ArrayList<>();
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/replay-events", port))
						.request().put(Entity.json(timeline));
			}
		
			protected void setSystemTime(DateTime systemTime, int port) {
				Client client = new JerseyClientBuilder().build();
				client.target(String.format("http://localhost:%d/api/test/system-time", port))
						.request().put(Entity.json(systemTime.toString()));
			}
			
			protected abstract String authorization(String username, String password);
		
		}
		
		
		«sdg»
		
	'''

	def generateTestUtils(HttpServer it) '''
		«copyright»
		
		package «getName»;
		
		import com.anfelisa.ace.JodaObjectMapper;
		import com.anfelisa.ace.TimelineItem;
		import com.fasterxml.jackson.core.JsonProcessingException;
		
		public class TestUtils {
		
			private static final JodaObjectMapper mapper = new JodaObjectMapper();
		
			«FOR aceOperation : aceOperations»
				«aceOperation.createTimelineItem»

			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''

	private def dispatch createTimelineItem(HttpServerAceWrite it) '''
		«FOR outcome : outcomes»
			public static TimelineItem create«eventName(outcome)»TimelineItem(«getModel.dataInterfaceNameWithPackage» data) throws JsonProcessingException {
				String json = mapper.writeValueAsString(data);
				return new TimelineItem("prepare", null, "«eventNameWithPackage(outcome)»", null, json, data.getUuid());
			}
		«ENDFOR»
	'''

	private def dispatch createTimelineItem(HttpServerAceRead it) ''''''

}
