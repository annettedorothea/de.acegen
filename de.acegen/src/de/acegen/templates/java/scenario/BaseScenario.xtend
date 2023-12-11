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

class BaseScenario {

	extension CommonExtension
	
	def generateBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import static org.hamcrest.CoreMatchers.is;
		import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
		
		import java.io.File;
		import java.io.IOException;
		import java.text.DecimalFormat;
		import java.time.LocalDateTime;
		import java.util.Arrays;
		import java.util.Base64;
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		import java.util.UUID;
		
		import org.apache.commons.lang3.StringUtils;
		import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
		import org.apache.hc.client5.http.classic.methods.HttpDelete;
		import org.apache.hc.client5.http.classic.methods.HttpGet;
		import org.apache.hc.client5.http.classic.methods.HttpPost;
		import org.apache.hc.client5.http.classic.methods.HttpPut;
		import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
		import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
		import org.apache.hc.client5.http.impl.classic.HttpClients;
		import org.apache.hc.core5.http.ClassicHttpResponse;
		import org.apache.hc.core5.http.HttpEntity;
		import org.apache.hc.core5.http.io.HttpClientResponseHandler;
		import org.apache.hc.core5.http.io.entity.EntityUtils;
		import org.apache.hc.core5.http.io.entity.StringEntity;
		import org.jdbi.v3.core.Jdbi;
		import org.junit.jupiter.api.AfterAll;
		import org.junit.jupiter.api.AfterEach;
		import org.junit.jupiter.api.BeforeAll;
		import org.junit.jupiter.api.BeforeEach;
		import org.junit.jupiter.api.Test;
		import org.junit.platform.runner.JUnitPlatform;
		import org.junit.runner.RunWith;
		import org.slf4j.LoggerFactory;
		
		import com.fasterxml.jackson.core.JsonProcessingException;
		import com.fasterxml.jackson.databind.DeserializationFeature;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
		
		import ch.qos.logback.classic.Level;
		import ch.qos.logback.classic.Logger;
		
		@RunWith(JUnitPlatform.class)
		public abstract class BaseScenario extends AbstractBaseScenario {
		
			static Logger LOG;
		
			private static Jdbi jdbi;
		
			private static int port;
		
			private static String host = "localhost";
		
			private static String protocol;
		
			private static String rootPath;
		
			private String testId;
		
			protected static Map<String, DescriptiveStatistics> metrics;
		
			@BeforeAll
			public static void beforeClass() throws Exception {
				LOG = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
				LOG.setLevel(Level.INFO);
		
				ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				YamlConfiguration config = mapper.readValue(new File("dev.yml"), YamlConfiguration.class);
				port = Integer.parseInt(config.getServer().getApplicationConnectors()[0].getPort());
				protocol = config.getServer().getApplicationConnectors()[0].getType();
				rootPath = config.getServer().getRootPath();
				jdbi = Jdbi.create(config.getDatabase().getUrl());
				if (metrics == null) {
					metrics = new HashMap<>();
				}
			}
		
			@AfterAll
			public static void afterClass() {
				Object[] actions = metrics.keySet().toArray();
				Arrays.sort(actions);
				LOG.info(padRight("action", 25) + padLeft("times", 9) + padLeft("mean", 9) + padLeft("std dev", 9)
						+ padLeft("median", 9) + padLeft("pctl(10)", 9) + padLeft("pctl(90)", 9) + padLeft("min", 9)
						+ padLeft("max", 9));
				for (Object action : actions) {
					DescriptiveStatistics values = metrics.get(action);
					LOG.info(padRight(action.toString(), 25) + padLeft(values.getN() + "", 9)
							+ padLeft(format(values.getMean()), 9) + padLeft(format(values.getStandardDeviation()), 9)
							+ padLeft(format(values.getPercentile(50)), 9)
							+ padLeft(format(values.getPercentile(10)), 9)
							+ padLeft(format(values.getPercentile(90)), 9) + padLeft(values.getMin(), 9)
							+ padLeft(values.getMax(), 9));
				}
			}
		
			private static String padLeft(double d, int n) {
				return String.format("%" + n + "s", new DecimalFormat("#").format(d));
			}
		
			public static String padLeft(String s, int n) {
				return String.format("%" + n + "s", s);
			}
		
			public static String padRight(String s, int n) {
				return String.format("%-" + n + "s", s);
			}
		
			private static String format(double d) {
				return new DecimalFormat("0.00").format(d);
			}
		
			@BeforeEach
			public void before() {
				daoProvider = new DaoProvider();
				handle = new PersistenceHandle(jdbi.open());
				testId = randomString();
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
		
			protected <T> HttpResponse<T> httpGet(String path, String authorization, String uuid, Class<T> entityType) {
				final HttpGet httpGet = new HttpGet(buildUrl(path, uuid));
				addHeaders(httpGet, authorization);
				return execute(httpGet, entityType);
			}
		
			protected <T> HttpResponse<T> httpPost(String path, Object payload, String authorization, String uuid,
					Class<T> entityType) {
				final HttpPost httpPost = new HttpPost(buildUrl(path, uuid));
				addHeaders(httpPost, authorization);
				addEntity(httpPost, payload);
				return execute(httpPost, entityType);
			}
		
			protected <T> HttpResponse<T> httpPut(String path, Object payload, String authorization, String uuid,
					Class<T> entityType) {
				final HttpPut httpPut = new HttpPut(buildUrl(path, uuid));
				addHeaders(httpPut, authorization);
				addEntity(httpPut, payload);
				return execute(httpPut, entityType);
			}
		
			protected <T> HttpResponse<T> httpDelete(String path, String authorization, String uuid, Class<T> entityType) {
				final HttpDelete httpDelete = new HttpDelete(buildUrl(path, uuid));
				addHeaders(httpDelete, authorization);
				return execute(httpDelete, entityType);
			}
		
			private String buildUrl(String path, String uuid) {
				if (StringUtils.isNotBlank(uuid)) {
					if (path.contains("?")) {
						path += "&uuid=" + uuid;
					} else {
						path += "?uuid=" + uuid;
					}
				}
				return String.format("%s://%s:%d%s%s", protocol, host, port, rootPath, path);
			}
		
			private void addHeaders(HttpUriRequest request, String authorization) {
				request.setHeader("Accept", "application/json");
				request.setHeader("Content-type", "application/json");
				if (authorization != null) {
					request.addHeader("Authorization", authorization);
				}
			}
		
			private void addEntity(HttpUriRequest request, Object payload) {
				try {
					String json = "";
					if (payload instanceof String) {
						json = payload.toString();
					} else {
						json = objectMapper.writeValueAsString(payload);
					}
					StringEntity httpEntity = new StringEntity(json);
					request.setEntity(httpEntity);
				} catch (JsonProcessingException e) {
					LOG.error("failed to write entity", e);
				}
			}
		
			private <T> HttpResponse<T> execute(HttpUriRequest request, Class<T> entityType) {
				try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
					long timeBeforeRequest = System.currentTimeMillis();
					final HttpClientResponseHandler<HttpResponse<T>> responseHandler = new HttpClientResponseHandler<HttpResponse<T>>() {
						@Override
						public HttpResponse<T> handleResponse(final ClassicHttpResponse response) throws IOException {
							long timeAfterRequest = System.currentTimeMillis();
							return createHttpResponse(response, entityType, timeAfterRequest - timeBeforeRequest);
						}
					};
					return httpclient.execute(request, responseHandler);
				} catch (IOException e) {
					return new HttpResponse<T>(null, e.getMessage(), -1, 0L);
				}
			}
		
			private <T> HttpResponse<T> createHttpResponse(ClassicHttpResponse response, Class<T> entityType, long duration) {
				int statusCode = response.getCode();
				String statusMessage = null;
				T entity = null;
				final int status = response.getCode();
				final HttpEntity httpEntity = response.getEntity();
				try {
					if (httpEntity != null) {
						if (status >= 400) {
							statusMessage = httpEntity != null ? EntityUtils.toString(httpEntity) : null;
						} else {
							String json = httpEntity != null ? EntityUtils.toString(httpEntity) : null;
							entity = objectMapper.readValue(json, entityType);
						}
					}
					response.close();
				} catch (final Exception x) {
					statusMessage = x.getMessage();
				}
				return new HttpResponse<T>(entity, statusMessage, statusCode, duration);
			}
		
			@Override
			protected String randomString() {
				return randomUUID().replace("-", "").substring(0, 8);
			}
		
			@Override
			protected String randomUUID() {
				return UUID.randomUUID().toString();
			}
		
			@Override
			protected String authorization(String username, String password) {
				return "<your authorization string>";
			}
		
			@Override
			protected void assertThat(int actual, int expected) {
				org.hamcrest.MatcherAssert.assertThat("testId: " + this.getTestId(), actual, is(expected));
			}
		
			@Override
			protected void assertFail(String message) {
				org.junit.jupiter.api.Assertions.fail(message);
			}
		
			@Override
			protected void assertThat(Object actual, Object expected) {
				if (actual == null) {
					assertIsNull(expected);
				} else {
					org.hamcrest.MatcherAssert.assertThat("testId: " + this.getTestId(), actual,
							is(samePropertyValuesAs(expected)));
				}
			}
		
			@Override
			protected void assertIsNull(Object actual) {
				org.junit.jupiter.api.Assertions.assertNull(actual, "testId: " + this.getTestId());
			}
		
			@Override
			protected void assertIsNotNull(Object actual) {
				org.junit.jupiter.api.Assertions.assertNotNull(actual, "testId: " + this.getTestId());
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
				switch (scenarioName) {
				default:
					return true;
				}
			}
		
			@Override
			protected String getTestId() {
				return testId;
			}
		
			@Override
			protected HttpResponse<Object> callSquishyDataProviderPutValue(String uuid, String key, String value) {
				return this.httpPut("/test/squishy/value?uuid=" + uuid + "&key=" + key + "&value=" + value, null, null, null,
						Object.class);
			}
		
			@Override
			protected HttpResponse<Object> callSquishyDataProviderPutSystemTime(String uuid, LocalDateTime dateTime) {
				return this.httpPut("/test/squishy/system-time?uuid=" + uuid + "&system-time=" + dateTime, null, null,
						null, Object.class);
			}
		
			@Override
			protected void addToMetrics(String action, Long duration) {
				DescriptiveStatistics values = metrics.get(action);
				if (values == null) {
					values = new DescriptiveStatistics();
					metrics.put(action, values);
				}
				values.addValue(duration);
				values = metrics.get("all");
				if (values == null) {
					values = new DescriptiveStatistics();
					metrics.put("all", values);
				}
				values.addValue(duration);
			}
		
		}
		
		
		
		«sdg»
		
		
	'''

	def generateAbstractBaseScenario() '''
		«copyright»
		
		package de.acegen;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
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
			
			protected abstract HttpResponse<Object> callSquishyDataProviderPutValue(
						String uuid, String key, String data);
						
			protected abstract HttpResponse<Object> callSquishyDataProviderPutSystemTime(
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
			
			private long duration;
		
			public HttpResponse(T entity, String statusMessage, int statusCode, long duration) {
				super();
				this.entity = entity;
				this.statusMessage = statusMessage;
				this.statusCode = statusCode;
				this.duration = duration;
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
			
			public long getDuration() {
				return duration;
			}
			
		}
		
		
		
		«sdg»
		
	'''
	
}