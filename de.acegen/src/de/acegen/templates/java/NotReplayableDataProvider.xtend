package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class NotReplayableDataProvider {

	@Inject
	extension CommonExtension
	
	def generateNotReplayableDataProvider() '''
		«copyright»
		
			package de.acegen;
			
			import java.util.concurrent.ConcurrentHashMap;
			import java.util.concurrent.ConcurrentMap;
			
			import java.time.LocalDateTime;
			
			public class NotReplayableDataProvider {
				
				private static ConcurrentMap<String, LocalDateTime> systemTimeMap = new ConcurrentHashMap<>();
		
				private static ConcurrentMap<String, ConcurrentMap<String, Object>> valueMap = new ConcurrentHashMap<>();
			
				public static LocalDateTime consumeSystemTime(String uuid) {
					LocalDateTime value = systemTimeMap.get(uuid);
					if (value != null) {
						systemTimeMap.remove(uuid);
					}
					return value;
				}
			
				public static void putSystemTime(String uuid, LocalDateTime systemTime) {
					systemTimeMap.put(uuid, systemTime);
				}
				
				public static void put(String uuid, String key, Object value) {
					ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
					if (mapForUuid == null) {
						mapForUuid = new ConcurrentHashMap<String, Object>();
						valueMap.put(uuid, mapForUuid);
					}
					mapForUuid.put(key, value);
				}
				
				public static Object consumeValue(String uuid, String key) {
					ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
					if (mapForUuid == null) {
						return null;
					}
					Object value = mapForUuid.get(key);
					mapForUuid.remove(key);
					if (mapForUuid.size() == 0) {
						valueMap.remove(uuid);
					}
					return value;
				}
				
			}					
			
		«sdg»
		
	'''

	
}