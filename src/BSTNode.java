import javax.imageio.plugins.tiff.BaselineTIFFTagSet;

public class BSTNode {

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
