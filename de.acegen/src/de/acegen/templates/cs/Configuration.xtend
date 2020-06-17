package de.acegen.templates.cs

import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class Configuration {

	@Inject
	extension CommonExtension

	def generateCustomAppConfiguration() '''
		«copyright»
		
		namespace Acegen 
		{
		
			public class CustomAppConfiguration : AppConfiguration 
			{
				public CustomAppConfiguration(Config config) : base(config)
			    { }
			}
		}
		
		«sdg»
		
	'''

	
	def generateAppConfiguration() '''
		«copyright»
		
		namespace Acegen 
		{
		
			public class AppConfiguration 
			{
				private Config _config;
				
				public AppConfiguration(Config config) 
				{
					_config = config;
				}
					
				public Config Config
			    {
			      get => _config;
			      set => _config = value;
			    }
				
			}
		}
		
		«sdg»
		
	'''

	def generateConfig() '''
		«copyright»
		
		namespace Acegen 
		{

			public class Config 
			{
				public const string REPLAY = "REPLAY";
				public const string LIVE = "LIVE";
				public const string DEV = "DEV";
				public const string TEST = "TEST";
			
				public const string ALWAYS = "ALWAYS";
				public const string ON_ERROR = "ON_ERROR";
				public const string NEVER = "NEVER";
				
				private string _mode = DEV;
				
				private string _writeTimeline = ON_ERROR;
				
				public Config(string mode, string writeTimeline) 
				{
					_mode = mode;
					_writeTimeline = writeTimeline;
				}
				
				public string Mode
			    {
			      get => _mode;
			      set => _mode = value;
			    }
				
				public string WriteTimeline
			    {
			      get => _writeTimeline;
			      set => _writeTimeline = value;
			    }
				
			
				public bool writeTimeline() {
					return NEVER != _writeTimeline;
				}
				
				public bool writeError() {
					return ON_ERROR == _writeTimeline || ALWAYS == _writeTimeline;
				}
		
			}
		}
		
		«sdg»
		
	'''	
}