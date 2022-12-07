import java.awt.*;

public class Tree {
    private final TreeType treeType;
    private final double heightFt;
    private final double trunkDiameterInches;

    protected Color TREE_COLOR = new Color(120, 145, 110);

    public Tree(TreeType treeType, double heightFt, double trunkDiameterInches) {
        this.treeType = treeType;
        this.heightFt = heightFt;
        this.trunkDiameterInches = trunkDiameterInches;
    }

    public void displayTallTree() {
        if (this.heightFt > 100) {
            System.out.printf("This %s tree is tall\n", this.treeType);
        }
    }

}
