import java.util.function.BinaryOperator;

public class BSTSearchTree {

    class BSTNode {

        // Data attribute & 2 pointer attributes (Left and Right Child)
        private Currency data;

        private BSTNode leftChild;

        private BSTNode rightChild;

        public BSTNode(Currency data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        // Getters and Setters for data, left, and right child.
        public void setData(Currency data) {
            this.data = data;
        }

        public Currency getData() {
            return data;
        }

        public void setLeftChild(BSTNode leftChild) {
            this.leftChild = leftChild;
        }

        public BSTNode getLeftChild() {
            return leftChild;
        }

        public void setRightChild(BSTNode rightChild) {
            this.rightChild = rightChild;
        }

        public BSTNode getRightChild() {
            return rightChild;
        }
    }

    protected BSTNode root;

    // Constructor of BSTSearchTree
    public BSTSearchTree() {
        root = null;
    }

    public BSTSearchTree(Currency value) {
        BSTNode root = new BSTNode(value);
    }

    public void insert(Currency dollar) {
        root = RecursiveInsert(root, dollar);
    }

    public BSTNode RecursiveInsert(BSTNode root, Currency dollar) {
        if (root == null) {
            return new BSTNode(dollar);
        }else if (!dollar.isGreater(root.getData())) {
            BSTNode leftChild = root.getLeftChild();
            leftChild = RecursiveInsert(root.leftChild , dollar);
        }else if (dollar.isGreater(root.getData())) {
            BSTNode rightChild = root.getRightChild();
            rightChild = RecursiveInsert(root.rightChild , dollar);
        }

        return root;
    }

    public void InOrderTraversal(BSTNode root) {

        if (root == null) {
            return;
        }

        InOrderTraversal(root.getLeftChild());
        System.out.println(root.getData() + "\n");
        InOrderTraversal(root.getRightChild());
    }

    public void PreorderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData());
        PreorderTraversal(node.getLeftChild());
        PreorderTraversal(node.getRightChild());
    }

    public void PostorderTraversal() {

    }

    public void BreadthFirstTraversal() {

    }

    public Dollar search() {
        return null;
    }

    public void printBST(BSTNode root, String BSTString) {

        if (root == null) {
            return;
        }

        System.out.println(BSTString + "\n" + root.getData());
        printBST(root.leftChild, BSTString + "\n");
        printBST(root.rightChild, BSTString + "\n");

    }

}


