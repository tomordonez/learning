public class Tree {
    TreeType treeType;
    double heightFt;
    double trunkDiameterInches;

    void grow() {
        this.heightFt += 10;
        this.trunkDiameterInches += 1;
    }
}
