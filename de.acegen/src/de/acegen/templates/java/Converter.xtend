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
import jakarta.inject.Inject

class Converter {

	@Inject
	extension CommonExtension
	
	def generateDateTimeToStringConverter() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		
		import com.fasterxml.jackson.databind.util.StdConverter;
		
		public class DateTimeToStringConverter extends StdConverter<LocalDateTime, String> {
			@Override
			public String convert(LocalDateTime value) {
				return value.toString();
			}
		}
		
		«sdg»
		
	'''

	def generateStringToDateTimeConverter() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		import java.time.format.DateTimeFormatter;
		
		import com.fasterxml.jackson.databind.util.StdConverter;
		
		public class StringToDateTimeConverter extends StdConverter<String, LocalDateTime> {
			@Override
			public LocalDateTime convert(String value) {
				return LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
			}
		}
		
		«sdg»
		
	'''

	
}