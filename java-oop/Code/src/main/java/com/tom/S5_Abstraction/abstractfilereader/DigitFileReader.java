package com.tom.S5_Abstraction.abstractfilereader;

import java.io.IOException;
import java.nio.file.Path;

public class DigitFileReader extends AbstractFileReader{

    protected DigitFileReader(Path filePath) throws IOException {
        super(filePath);
    }
}
