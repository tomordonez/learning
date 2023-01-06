package com.tom.S5_Abstraction.abstractfilereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitFileReader extends AbstractFileReader{

    public DigitFileReader() {
        super();
    }

    @Override
    public ArrayList<Integer> parseDigits(List<List<String>> textFileData) {
        ArrayList<Integer> digitsFromTextFile = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");

        for (List<String> textLine : textFileData) {
            Matcher matcher = pattern.matcher(textLine.get(0));
            while (matcher.find()) {
                digitsFromTextFile.add(Integer.valueOf(matcher.group()));
            }
        }
        return digitsFromTextFile;
    }

    @Override
    public ArrayList<Integer> parseDigits(String filename) {
        List<List<String>> textFileData = new ArrayList<>();
        ArrayList<Integer> digitsFromTextFile;

        try (InputStream inputStream = DigitFileReader.class.getClassLoader().getResourceAsStream(filename)) {
            assert inputStream != null;
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<String> lineString = new ArrayList<>();
                lineString.add(line);
                textFileData.add(lineString);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        digitsFromTextFile = this.parseDigits(textFileData);
        return digitsFromTextFile;
    }
}
