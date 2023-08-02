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
        if (root == null) {
            root = new BSTNode(dollar);
        } else {
            RecursiveInsert(root, dollar);
        }
    }

    private void RecursiveInsert(BSTNode root, Currency dollar) {
        if (!dollar.isGreater(root.getData())) {
            if (root.getLeftChild() == null) {
                BSTNode newNode = new BSTNode(dollar);
                root.setLeftChild(newNode);
            }else {
                RecursiveInsert(root.getLeftChild(), dollar);
            }
        }else if (dollar.isGreater(root.getData())) {
           if (root.getRightChild() == null) {
               BSTNode newNode = new BSTNode(dollar);
               root.setRightChild(newNode);
           } else {
               RecursiveInsert(root.getRightChild(), dollar);
           }
        }

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


