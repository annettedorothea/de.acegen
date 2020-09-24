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


package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class NonDeterministicDataProvider {

	@Inject
	extension CommonExtension
	
	def generateNonDeterministicDataProvider() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.concurrent.ConcurrentHashMap;
		import java.util.concurrent.ConcurrentMap;
		
		import java.time.LocalDateTime;
		
		public class NonDeterministicDataProvider {
			
			private static ConcurrentMap<String, LocalDateTime> systemTimeMap = new ConcurrentHashMap<>();
	
			private static ConcurrentMap<String, ConcurrentMap<String, Object>> valueMap = new ConcurrentHashMap<>();
		
			public static void putSystemTime(String uuid, LocalDateTime systemTime) {
				if (uuid != null && systemTime != null) {
					systemTimeMap.put(uuid, systemTime);
				}
			}
			
			public static void put(String uuid, String key, Object value) {
				if (uuid != null && value != null) {
					ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);
					if (mapForUuid == null) {
						mapForUuid = new ConcurrentHashMap<String, Object>();
						valueMap.put(uuid, mapForUuid);
					}
					mapForUuid.put(key, value);
				}
			}
			
			public static LocalDateTime consumeSystemTime(String uuid) {
				if (uuid != null) {
					LocalDateTime value = systemTimeMap.get(uuid);
					if (value != null) {
						systemTimeMap.remove(uuid);
					}
					return value;
				} else {
					return null;
				}
			}
		
			public static Object consumeValue(String uuid, String key) {
				if (uuid != null && key != null) {
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
				} else {
					return null;
				}
			}
			
		}
	
		«sdg»
		
	'''

	
}