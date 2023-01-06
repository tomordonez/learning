package com.tom.S5_Abstraction.abstractfilereader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileReader {

    protected AbstractFileReader() {
    }

    protected abstract ArrayList<Integer> parseDigits(List<List<String>> textFileData);

    protected abstract ArrayList<Integer> parseDigits(InputStream fileInputStream, List<List<String>> textFileData);
}
