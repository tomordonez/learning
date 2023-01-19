package com.tom.S5_Abstraction.avengerinterface;

import java.util.List;

public class Guardian implements Avenger{

    private final String guardianName;
    private final List<List<String>> dbOpener;

    public Guardian(String guardianName, List<List<String>> dbOpener) {
        this.guardianName = guardianName;
        this.dbOpener = dbOpener;
    }
    @Override
    public String getPlanetOrigin() {
        return DBRecord.getRecord(this.guardianName, this.dbOpener).get(2);
    }

    @Override
    public String getTeam() {
        return DBRecord.getRecord(this.guardianName, this.dbOpener).get(3);
    }

    @Override
    public Integer getYearFirstAppearance() {
        String yearFirstAppearance = DBRecord.getRecord(this.guardianName, this.dbOpener).get(1);

        return Integer.parseInt(yearFirstAppearance);
    }
}
