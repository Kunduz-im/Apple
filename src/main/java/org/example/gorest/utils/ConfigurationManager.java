package org.example.gorest.utils;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static AppConfig getBadeConfig(){
        return ConfigCache.getOrCreate(AppConfig.class);
    }
}
