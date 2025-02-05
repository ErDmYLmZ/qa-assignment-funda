package com.funda.tests.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<String[]> readCsvData(String filePath) {
        List<String[]> credentials = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            credentials = reader.readAll();
            credentials.remove(0);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return credentials;
    }
}


