package com.tom.S1_Classes_And_Objects.tree;

import java.awt.*;

public class Tree {
    private final TreeType treeType;
    private double heightFt;
    private final double trunkDiameterInches;

    protected static Color TREE_COLOR = new Color(120, 145, 110);

    public Tree(TreeType treeType, double heightFt, double trunkDiameterInches) {
        this.treeType = treeType;
        this.heightFt = heightFt;
        this.trunkDiameterInches = trunkDiameterInches;
    }

    public double getHeightFt() {
        return heightFt;
    }

    public double getTrunkDiameterInches() {
        return trunkDiameterInches;
    }
    public TreeType getTreeType() {
        return treeType;
    }

    public void displayTallTree() {
        if (this.heightFt > 100) {
            System.out.printf("This %s tree is tall\n", this.treeType);
        }
    }

    public double growTree() {
        return this.heightFt += 2;
    }

}
