package com.tom.S5_Abstraction.avengerinterface;

import java.util.List;

public class DBRecord {
    public DBRecord() {

    }

    public static List<String> getRecord(String filename, List<List<String>> dbOpener) {
        List<String> foundRecord = null;

        for (List<String> record : dbOpener) {
            if (record.get(0).equals(filename)) {
                foundRecord = record;
            }
        }
        return foundRecord;
    }
}
