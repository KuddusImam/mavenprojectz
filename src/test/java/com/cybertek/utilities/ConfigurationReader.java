package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        // this the path t0 the location of the file
        String path = "configuration.properties";

        try {
            // java cannot read file directly, it needs inputstreamto read files
            // inputstream takes the location of the file as a constructor
            FileInputStream fileInputStream = new FileInputStream(path);

            //Properties is used to read specifically properties files, files with key value pairs
            properties = new Properties();

            //file contents are load to properties from the inputstream
            properties.load(fileInputStream);

            // all input stream must be closed
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // returns the value of specific
    public static String getProperty(String property){
        return properties.getProperty(property);
    }
}
