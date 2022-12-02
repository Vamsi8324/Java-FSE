package com.properties.filedemo;

import java.util.Iterator;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertiesFileDemo {

	public static void main(String[] args) {
		//public PropertiesConfiguration properties(String fn)throws ConfigurationException
		Configurations configurations = new Configurations();
		try {
			PropertiesConfiguration config = configurations.properties("configuration.properties");
			Iterator<String> keys  = config.getKeys();
			while(keys.hasNext()) {
				//System.out.println(keys.next());
				String key = keys.next();
				System.out.println(key + ":"+ config.getProperty(key));
			}
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}

	}
}
