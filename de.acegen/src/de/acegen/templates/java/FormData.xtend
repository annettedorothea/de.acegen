package de.acegen.templates.java

import de.acegen.extensions.CommonExtension

class FormData {
	
	extension CommonExtension
	
	def generate() '''
		«copyright»
		
		package de.acegen;
		
		import java.io.InputStream;
		
		import org.glassfish.jersey.media.multipart.ContentDisposition;
		
		import com.fasterxml.jackson.annotation.JsonIgnoreType;
		
		@JsonIgnoreType
		public class FormData {
		
			private ContentDisposition contentDisposition;
			private InputStream inputStream;
			
			public FormData(ContentDisposition contentDisposition, InputStream inputStream) {
				super();
				this.contentDisposition = contentDisposition;
				this.inputStream = inputStream;
			}
		
			public ContentDisposition getContentDisposition() {
				return contentDisposition;
			}
		
			public InputStream getInputStream() {
				return inputStream;
			}
			
		}
		
		«sdg»
	'''
}