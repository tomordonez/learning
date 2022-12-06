public class Tree {
    TreeType treeType;
    double heightFt;
    double trunkDiameterInches;

    public Tree(TreeType treeType, double heightFt, double trunkDiameterInches) {
        this.treeType = treeType;
        this.heightFt = heightFt;
        this.trunkDiameterInches = trunkDiameterInches;
    }

    void grow() {
        this.heightFt += 10;
        this.trunkDiameterInches += 1;
    }
}
