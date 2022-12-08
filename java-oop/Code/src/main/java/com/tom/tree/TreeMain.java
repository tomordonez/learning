package com.tom.tree;

import java.awt.*;

public class TreeMain {
    public static void main(String[] args) {
        Tree myTree = new Tree(TreeType.OAK, 120, 10);
        myTree.displayTallTree();

        Tree myOtherTree = new Tree(TreeType.ROSEWOOD, 100, 20);
        myOtherTree.displayTallTree();

        System.out.println(Tree.TREE_COLOR);

        var whiteColor = Color.WHITE;
        var darkerWhite = whiteColor.darker();
    }
}
