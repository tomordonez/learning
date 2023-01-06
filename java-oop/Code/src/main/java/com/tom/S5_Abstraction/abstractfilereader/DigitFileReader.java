package com.tom.S5_Abstraction.abstractfilereader;

import java.io.InputStream;
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
    protected ArrayList<Integer> parseDigits(InputStream fileInputStream, List<List<String>> textFileData) {
        return null;
    }
}
