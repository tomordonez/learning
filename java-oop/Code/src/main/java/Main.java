public class Main {
    public static void main(String[] args) {

        Tree myTree = new Tree(TreeType.OAK, 120, 20);
        myTree.displayTallTree();

        System.out.printf("Tree type: %s\n", myTree.getTreeType());
        System.out.printf("Tree height: %s ft\n", myTree.getHeightFt());
        System.out.printf("Tree diameter: %s in\n", myTree.getTrunkDiameterInches());

        System.out.printf("The tree grew to %s ft", myTree.growTree());
    }
}
