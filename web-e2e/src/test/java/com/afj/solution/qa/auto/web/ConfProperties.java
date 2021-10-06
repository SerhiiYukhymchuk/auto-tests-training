package com.afj.solution.qa.auto.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream file;
    protected static Properties PROPERTIES;

    static {
        try{
            file = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(file);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (file != null){
                try{
                    file.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getProperties(String key){
        return PROPERTIES.getProperty(key);
    }
}
