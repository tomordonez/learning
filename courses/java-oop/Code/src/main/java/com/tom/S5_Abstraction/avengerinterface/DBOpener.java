package com.tom.S5_Abstraction.avengerinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBOpener {
    public DBOpener() {
    }

    public static List<List<String>> openDB() {
        String filename = "s5_avengerDB.txt";
        List<List<String>> fileData = new ArrayList<>();

        try (InputStream inputStream = DBOpener.class.getClassLoader().getResourceAsStream(filename)) {
            assert inputStream != null;
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                fileData.add(Arrays.asList(line.split(",")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileData;
    }
}
