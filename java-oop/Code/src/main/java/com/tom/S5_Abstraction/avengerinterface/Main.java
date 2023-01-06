package com.tom.S5_Abstraction.avengerinterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> dbOpener = DBOpener.openDB();

        String guardian_name = "Star-Lord";
        Guardian guardian = new Guardian(guardian_name, dbOpener);

        String result = "Name: " + guardian_name +
                ". Origin: "+ guardian.getPlanetOrigin() +
                ". Team: " + guardian.getTeam() +
                ". Year First Appearance: " + guardian.getYearFirstAppearance();

        System.out.println(result);
    }
}
