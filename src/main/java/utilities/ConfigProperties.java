package utilities;

import components.WebDriverUtil;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigProperties {
    static final String propFileName = "src/test/resources/config.properties";
    static Properties properties;


    public  Properties initialize_properties() {
        FileInputStream fis;
        try {
            properties =new Properties();
            fis = new FileInputStream(propFileName);
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            System.out.println("properties exception-----");
        }
        return  properties;
    }

    public String getProperty(String property){
        return properties.getProperty(property);
    }

}
