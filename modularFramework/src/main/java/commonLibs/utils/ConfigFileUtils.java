package commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileUtils {
	
	public static Properties readProperties1(String filename) throws Exception{
		
		filename= filename.trim();
		InputStream fileReader = new FileInputStream(filename);
		
		Properties property = new Properties();
		
		property.load(fileReader);
		
		return property;
		
	}

	public static Properties readProperties(String configFileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
