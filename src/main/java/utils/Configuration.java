package utils;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	// The Properties class represents a persistent set of properties.
	private Properties properties;
	
	// Constructor
	// Why I am putting loadProperty () method inside constructor
	// because when Configuration class is instantiated, then Constructor will be initialized, loadproperty() inside
	// Constructor will also be initialized
	public Configuration () {
		loadProperty();
	}
	
	public void loadProperty() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Individual method created
	public String getProperties(String key) {
		return properties.getProperty(key);
	}

}











