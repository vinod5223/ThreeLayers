package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilsLibrary {
	public String readDataFromPropFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/rmgyantracreds.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	
}
