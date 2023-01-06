package com.tom.S5_Abstraction.abstractfilereader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileReader {
    private final InputStream fileInputStream;

    protected AbstractFileReader(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    protected abstract ArrayList<Integer> parseDigits(List<List<String>> textFileData);
}
