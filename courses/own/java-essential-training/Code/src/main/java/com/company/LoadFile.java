package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoadFile {
    public static boolean checkFileExists(String filename) {
        InputStream inputStream = LoadFile.class.getClassLoader().getResourceAsStream(filename);
        assert inputStream != null;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream)) {
            if (streamReader.read() > 0) {
                System.out.println("File exists");
            }
        } catch (Exception e) {
            System.out.printf("File %s does not exist\n", filename);
            throw new RuntimeException(e);
        }
        return true;
    }

    public static ArrayList<String[]> readCsv(String filename) {
        ArrayList<String[]> csvData = new ArrayList<>();
        InputStream inputStream = LoadFile.class.getClassLoader().getResourceAsStream(filename);
        assert inputStream != null;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(streamReader)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineData = line.split(",");
                csvData.add(lineData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return csvData;
    }

}
