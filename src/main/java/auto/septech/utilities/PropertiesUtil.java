package auto.septech.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertiesUtil {
	public static Properties load_config_sys() throws IOException{
		String fs = File.separator;
		FileInputStream is = new FileInputStream((System.getProperty("user.dir") + "/setting.properties").replace("/", fs).replace("\\", fs));
		Properties pros = new Properties();
		pros.load(is);
		return pros;
	}
}
