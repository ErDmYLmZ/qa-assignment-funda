package com.funda.tests.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvToSystemEnv {
    public static void loadEnvToSystem() {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue())); // Use System.setProperty for setting system properties
    }
    public static String getEnv(String key) {
        return System.getenv(key); // Get from environment variables
    }

}