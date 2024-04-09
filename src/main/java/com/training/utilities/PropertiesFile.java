package com.training.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
public String getProperties(String Key) throws IOException {
//	define the path of the file
	String userdir = System.getProperty("user.dir");
	String fileseperator = System.getProperty("file.separator");
	String filepath = userdir+fileseperator+"properties"+fileseperator+"application.properties";
	
//	load this path into file object
	FileInputStream fileinput = new FileInputStream(filepath);
	
//	create the object as property file
	Properties prop  = new Properties();
	prop.load(fileinput);
	
//	fetch the data from the property file
	String value = prop.getProperty(Key);

	return value;


}

}
