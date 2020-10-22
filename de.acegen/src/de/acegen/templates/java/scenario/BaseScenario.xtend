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


package de.acegen.templates.java.scenario

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class BaseScenario {

	@Inject
	extension CommonExtension
	
	def generateBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import static org.hamcrest.CoreMatchers.is;
		import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
		
		import java.io.File;
		import java.util.Base64;
		import java.util.UUID;
		
		import javax.ws.rs.client.Client;
		import javax.ws.rs.client.Entity;
		import javax.ws.rs.client.Invocation.Builder;
		import javax.ws.rs.core.Response;
		
		import org.glassfish.jersey.client.JerseyClientBuilder;
		import org.jdbi.v3.core.Jdbi;
		import java.time.LocalDateTime;
		import org.junit.jupiter.api.AfterAll;
		import org.junit.jupiter.api.AfterEach;
		import org.junit.jupiter.api.BeforeAll;
		import org.junit.jupiter.api.BeforeEach;
		import org.junit.jupiter.api.Test;
		import org.junit.jupiter.api.extension.ExtendWith;
		import org.junit.platform.runner.JUnitPlatform;
		import org.junit.runner.RunWith;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import com.fasterxml.jackson.databind.DeserializationFeature;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
		
		@RunWith(JUnitPlatform.class)
		@ExtendWith(TestLogger.class)
		public abstract class BaseScenario extends AbstractBaseScenario {
		
			static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);
		
			private static Jdbi jdbi;
		
			private static int port;
		
			private static String host = "localhost";
		
			private static String protocol;
		
			private static String rootPath;
		
			private String testId;
		
			public Client client;
		
			@BeforeAll
			public static void beforeClass() throws Exception {
				ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				YamlConfiguration config = mapper.readValue(new File("test.yml"), YamlConfiguration.class);
				port = Integer.parseInt(config.getServer().getApplicationConnectors()[0].getPort());
				protocol = config.getServer().getApplicationConnectors()[0].getType();
				rootPath = config.getServer().getRootPath();
				if (rootPath.charAt(rootPath.length() - 1) == '/') {
					rootPath = rootPath.substring(0, rootPath.length() - 1);
				}
				jdbi = Jdbi.create(config.getDatabase().getUrl());
			}
		
			@AfterAll
			public static void afterClass() {
			}
		
			@BeforeEach
			public void before() {
				daoProvider = new DaoProvider();
				handle = new PersistenceHandle(jdbi.open());
				testId = randomString();
				client = new JerseyClientBuilder().build();
				LOG.info("testId {}", testId);
				LOG.info("*********************************************************************************");
				LOG.info("********   {} test id {}", this.scenarioName(), testId);
				LOG.info("*********************************************************************************");
			}
		
			@AfterEach
			public void after() {
				handle.getHandle().close();
			}
			
			@Test
			public void test() throws Exception {
				this.runTest();
			}
		
			private String buildUrl(String path, String uuid) {
				if (path.charAt(0) != '/') {
					path = "/" + path;
				}
				if (path.contains("?")) {
					path += "&uuid=" + uuid;
				} else {
					path += "?uuid=" + uuid;
				}
				return String.format("%s://%s:%d%s%s", protocol, host, port, rootPath, path);
			}
		
			protected <T> HttpResponse<T> httpGet(String path, String authorization, String uuid, Class<T> entityType) {
				Builder builder = client.target(buildUrl(path, uuid)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.get();
			}
		
			protected <T> HttpResponse<T> httpPost(String path, Object payload, String authorization, String uuid, Class<T> entityType) {
				Builder builder = client.target(buildUrl(path, uuid)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.post(Entity.json(payload));
			}
		
			protected <T> HttpResponse<T> httpPut(String path, Object payload, String authorization, String uuid, Class<T> entityType) {
				Builder builder = client.target(buildUrl(path, uuid)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.put(payload != null ? Entity.json(payload) : Entity.json(""));
			}
		
			protected <T> HttpResponse<T> httpDelete(String path, String authorization, String uuid, Class<T> entityType) {
				Builder builder = client.target(buildUrl(path, uuid)).request();
				if (authorization != null) {
					builder.header("Authorization", authorization);
				}
				return builder.delete();
			}
		
			protected String randomString() {
				return randomUUID().replace("-", "").substring(0, 8);
			}
		
			@Override
			protected String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			@Override
			protected String authorization(String username, String password) {
				String string = username.replace("${testId}", testId) + ":" + password;
				String hash = Base64.getEncoder().encodeToString(string.getBytes());
				return "basic " + hash;
			}
		
			@Override
			protected void assertThat(int actual, int expected) {
				org.hamcrest.MatcherAssert.assertThat(actual, is(expected));
			}
		
			@Override
			protected void assertFail(String message) {
				org.junit.jupiter.api.Assertions.fail(message);
			}
		
			@Override
			protected void assertThat(Object actual, Object expected) {
				if (actual == null) {
					assertIsNull(expected);
				}
				org.hamcrest.MatcherAssert.assertThat(actual, is(samePropertyValuesAs(expected)));
			}
		
			@Override
			protected void assertIsNull(Object actual) {
				org.junit.jupiter.api.Assertions.assertNull(actual);
			}
		
			@Override
			protected void assertIsNotNull(Object actual) {
				org.junit.jupiter.api.Assertions.assertNotNull(actual);
			}
		
			@Override
			protected void assertTrue(boolean b) {
				org.junit.jupiter.api.Assertions.assertTrue(b);
			}
		
			@Override
			protected void assertFalse(boolean b) {
				org.junit.jupiter.api.Assertions.assertFalse(b);
			}

			@Override
			protected boolean prerequisite(String scenarioName) {
				return true;
			}
		
			@Override
			protected String getTestId() {
				return testId;
			}
		
			protected String replaceTestId(String string) {
				return string.replace("${testId}", testId);
			}
		
			@Override
			protected Response callNonDeterministicDataProviderPutValue(
					String uuid, String key, Object data) {
				Client client = new JerseyClientBuilder().build();
				Builder builder = client
						.target(String.format("%s://%s:%d%s/test/non-deterministic/value?uuid=" + uuid + "&key=" + key, protocol,
								host, port, rootPath))
						.request();
				return builder.put(Entity.json(data));
			}
		
			@Override
			protected Response callNonDeterministicDataProviderPutSystemTime(
					String uuid, LocalDateTime dateTime) {
				Client client = new JerseyClientBuilder().build();
				Builder builder = client
						.target(String.format(
								"%s://%s:%d%s/test/non-deterministic/system-time?uuid=" + uuid + "&system-time=" + dateTime,
								protocol, host, port, rootPath))
						.request();
				return builder.put(Entity.json(dateTime));
			}
		
		}
		
		«sdg»
		
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		import javax.ws.rs.core.Response;
		import java.time.LocalDateTime;
		import java.util.HashMap;
		import java.util.Map;
		
		public abstract class AbstractBaseScenario {
		
			protected final ObjectMapper mapper = new ObjectMapper();
		
			protected DaoProvider daoProvider;
		
			protected PersistenceHandle handle;
			
			protected ObjectMapper objectMapper;
			
			protected Map<String, Object> extractedValues = new HashMap<String, Object>();
			
			public AbstractBaseScenario() {
				objectMapper = new ObjectMapper();
			}
		
			protected abstract void runTest() throws Exception;

			protected abstract <T> HttpResponse<T> httpGet(String path, String authorization, String uuid, Class<T> entityType);
			
			protected abstract <T> HttpResponse<T> httpPost(String path, Object payload, String authorization, String uuid, Class<T> entityType);
			
			protected abstract <T> HttpResponse<T> httpPut(String path, Object payload, String authorization, String uuid, Class<T> entityType);
			
			protected abstract <T> HttpResponse<T> httpDelete(String path, String authorization, String uuid, Class<T> entityType);
			
			protected abstract String randomString();
			
			protected abstract String randomUUID();

			protected abstract String authorization(String username, String password);
		
			protected abstract void assertThat(int actual, int expected);

			protected abstract void assertThat(Object actual, Object expected);
		
			protected abstract void assertIsNull(Object actual);

			protected abstract void assertIsNotNull(Object actual);
		
			protected abstract void assertFail(String message);
			
			protected abstract void assertTrue(boolean b);

			protected abstract void assertFalse(boolean b);
		
			protected abstract String scenarioName();
			
			protected abstract String getTestId();

			protected abstract boolean prerequisite(String scenarioName);
			
			protected abstract Response callNonDeterministicDataProviderPutValue(
						String uuid, String key, Object data);
						
			protected abstract Response callNonDeterministicDataProviderPutSystemTime(
						String uuid, LocalDateTime dateTime);
						
			protected abstract void addToMetrics(String action, Long duration);

		}
		
		
		«sdg»
		
	'''

	def generateTestLogger() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.Optional;
		
		import org.junit.jupiter.api.extension.ExtensionContext;
		import org.junit.jupiter.api.extension.TestWatcher;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public class TestLogger implements TestWatcher {
		
			static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
		
			@Override
			public void testDisabled(ExtensionContext context, Optional<String> reason) {
				LOG.info("DISABLED {}", reason.orElse(""));
				LOG.info("*********************************************************************************");
			}
		
			@Override
			public void testSuccessful(ExtensionContext context) {
				LOG.info("SUCCESS");
				LOG.info("*********************************************************************************");
			}
		
			@Override
			public void testAborted(ExtensionContext context, Throwable cause) {
				LOG.error("ABORTED", cause);
				LOG.error("*********************************************************************************");
			}
		
			@Override
			public void testFailed(ExtensionContext context, Throwable cause) {
				LOG.error("FAILED", cause);
				LOG.error("*********************************************************************************");
			}
		
		
		}
		
		
		«sdg»
		
	'''
	
	def generateHttpResponse() '''
		«copyright»
		
		package de.acegen;
		
		public class HttpResponse<T> {
		
			private T entity;
			
			private String statusMessage;
			
			private int statusCode;
		
			public HttpResponse(T entity, String statusMessage, int statusCode) {
				super();
				this.entity = entity;
				this.statusMessage = statusMessage;
				this.statusCode = statusCode;
			}
		
			public T getEntity() {
				return entity;
			}
		
			public String getStatusMessage() {
				return statusMessage;
			}
		
			public int getStatusCode() {
				return statusCode;
			}
			
		}
		
		
		
		«sdg»
		
	'''
	
}