package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    // changed Properties win my branch sprint5_tests
    // Someone else's changes

    static {
        properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("testEnv.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
