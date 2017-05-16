package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper{


    public static String getPropertiesByKey(String key) throws IOException
    {
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath + "/src/test/java/com/unity/set-up/init.properties");

        FileInputStream fileInput = null;
        try
        {
          fileInput = new FileInputStream(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try
        {
            prop.load(fileInput);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String keyValue = prop.getProperty(key);

        return keyValue;

    }


    /**
     *
     * @param args
     */
    public static void main(String args[]) throws IOException
    {
        PropertyHelper myHelper = new PropertyHelper();
        getPropertiesByKey("BROWSER.type");

    }
}

