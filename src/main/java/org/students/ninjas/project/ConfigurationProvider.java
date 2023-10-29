package org.students.ninjas.project;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationProvider {

    public static Properties getProperties() {
        Properties prop = new Properties();
        try {
            prop.load(ConfigurationProvider.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}
