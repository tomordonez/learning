import java.awt.*;

public class Tree {
    TreeType treeType;
    double heightFt;
    double trunkDiameterInches;

    static Color TREE_COLOR = new Color(120, 145, 110);

    public Tree(TreeType treeType, double heightFt, double trunkDiameterInches) {
        this.treeType = treeType;
        this.heightFt = heightFt;
        this.trunkDiameterInches = trunkDiameterInches;
    }

    void displayTallTree() {
        if (this.heightFt > 100) {
            System.out.printf("This %s tree is tall\n", this.treeType);
        }
    }

    static void cutTree() {
        System.out.println("A tree was cut down");
    }
    void grow() {
        this.heightFt += 10;
        this.trunkDiameterInches += 1;
    }
}
