package com.tom.modarray;

import java.util.ArrayList;

public class ModArrayList extends ArrayList<String> {
    public ModArrayList() {
    }
    public String getUsingMod(int index) {
        int indexPositive = Math.abs(index);
        if (indexPositive < this.size()) {
            return this.get(indexPositive);
        } else {
            return this.get(indexPositive % this.size());
        }
    }
}
