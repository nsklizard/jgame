package ru.nsk.lizard.game.common;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lizard on 13.10.2015.
 */
public class PropertyUtil {
    private static Logger log = Logger.getLogger(PropertyUtil.class);
    private static final String PROP_FILE_PATH = System.getProperty("catalina.base")+File.separator+"conf"+File.separator+"game.properties";

    private static Properties properties;
    static{
        properties = new Properties();
        try {
            File resourceFile = new File(PROP_FILE_PATH);
            InputStream stream = new FileInputStream(resourceFile);
            properties.load(stream);
        } catch (IOException e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    public static String get(String propertyKey){
        return properties.getProperty(propertyKey);
    }
}
