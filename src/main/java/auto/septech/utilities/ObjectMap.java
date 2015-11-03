package auto.septech.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class ObjectMap {
	static Properties properties;
	static String fseparator = File.separator;


	/**
	 * Get locator string from element properties
	 * @param ElementName
	 * @return
	 * @throws Exception
	 */
	public static String getActualValueFromObjectRepository(String ElementName) {
		//Read value using the logical name as Key
		String locator = properties.getProperty(ElementName);
		if(locator!=null && !locator.isEmpty()){
			return locator;
		}
		else
			return ElementName;
	}

	/**
	 * loading locator element from package
	 * @param objectRepos
	 * @return
	 * @throws IOException
	 */
	public static Properties loading_object_properties_from_package(String objectRepos){
		FileInputStream fs = null;
		properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource(objectRepos);
		try {
			File folder = new File(url.toURI());
			if (folder.isDirectory()) {
				File[] files = folder.listFiles();
				for (File file : files) {
					fs = new FileInputStream(file);
					properties.load(fs);
				}
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * loading locator element from file
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Properties load_object_properties_from_file(String fileName) throws IOException {
		FileInputStream fs = null;
		try {
			//Get current working directory
			String workingDir=System.getProperty("user.dir");
			//Get object map file
			fs = new FileInputStream(workingDir +fseparator+"objects"+ fseparator + fileName);
			TestLogger.info(fs);
			properties = new Properties();
			properties.load(fs);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return properties;
	}
}