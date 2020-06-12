package de.acegen.templates.java

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

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