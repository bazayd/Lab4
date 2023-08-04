import java.util.function.BinaryOperator;
import java.util.*;

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

    public void search(Currency dollar) {
        if (isEmpty(root)) {
            System.out.println("Empty tree");
        }else {
            System.out.println("Found amount: search(root, dollar)");
        }
    }

    public Currency search(BSTNode root, Currency dollar) {

        if (root.getData().isGreater(dollar)) {
            return search(root.getLeftChild(), dollar);
        }else if (dollar.isGreater(root.getData())) {
            return search(root.getRightChild(), dollar);
        }else {
            return root.getData();
        }
    }

    public void insert(Currency dollar) {
        if (isEmpty(root)) {
            root = new BSTNode(dollar);
        } else {
            insert(root, dollar);
        }
    }

    private void insert(BSTNode root, Currency dollar) {
        if (!dollar.isGreater(root.getData())) {
            if (root.getLeftChild() == null) {
                BSTNode newNode = new BSTNode(dollar);
                root.setLeftChild(newNode);
            }else {
                insert(root.getLeftChild(), dollar);
            }
        }else if (dollar.isGreater(root.getData())) {
           if (root.getRightChild() == null) {
               BSTNode newNode = new BSTNode(dollar);
               root.setRightChild(newNode);
           } else {
               insert(root.getRightChild(), dollar);
           }
        }

    }

    public void delete(Currency dollar) {
        root = delete(dollar, root);
    }

    private BSTNode delete(Currency dollar, BSTNode root) {
        if (isEmpty(root)) {
            return null;
        }
        // If dollar value is less than root value go to left child
        if (!dollar.isGreater(root.getData())) {
            root.setLeftChild(delete(dollar, root.getLeftChild()));
            // if dollar value is greater than root value check right child
        } else if (dollar.isGreater(root.getData())) {
            root.setRightChild(delete(dollar, root.getRightChild()));
        }else {
            // Cases for leaf nodes or one child cases
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }
            root.setData(getMax(root.getLeftChild()));
            root.setLeftChild(delete(root.getData(), root.getLeftChild()));
        }
        return root;
    }


    public Currency getMin() {
        if (isEmpty(root)) {
            return null;
        }
        return getMin(root);
    }

    private Currency getMin(BSTNode node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    public Currency getMax() {
        if (isEmpty(root)) {
            return null;
        }
        return getMax(root);
    }

    private Currency getMax(BSTNode node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    public void InOrderTraversal(BSTNode root) {
        if (isEmpty(root)) {
            return;
        }

        InOrderTraversal(root.getLeftChild());
        System.out.println(root.getData() + "\n");
        InOrderTraversal(root.getRightChild());
    }

    public void PreorderTraversal(BSTNode root) {
        if (isEmpty(root)) {
            return;
        }

        System.out.println(root.getData());
        PreorderTraversal(root.getLeftChild());
        PreorderTraversal(root.getRightChild());
    }

    public void PostorderTraversal(BSTNode root) {
        if (isEmpty(root)) {
            return;
        }

        PreorderTraversal(root.getLeftChild());
        PreorderTraversal(root.getRightChild());
        System.out.println(root.getData());
    }

    public void BreadthFirstTraversal(BSTNode root) {
    	
//    	BSTNode curNode = root;
//    	Queue bfQueue = new Queue();
//    	bfQueue.enQueue(curNode.getData());
//    	
//    	while(!bfQueue.isListEmpty()) {
//    		curNode.setData(bfQueue.deQueue());
//    		System.out.println(curNode.getData());
//    		
//    		if (curNode.getLeftChild() != null) {
//    			bfQueue.enQueue(curNode.getLeftChild().getData());
//    		}
//    		
//    		if (curNode.getRightChild() != null) {
//    			bfQueue.enQueue(curNode.getRightChild().getData());
//    		}
//    		
//    	}
//    	
    	
    	BSTNode curNode = root;
    	Queue bfQueue = new Queue();
    	bfQueue.enQueue(curNode.getData());
    	
    	while(curNode != null) {
//    		System.out.println(curNode.getLeftChild());
//    		System.out.println(curNode.getRightChild());
    	
    		
    		if (curNode.getLeftChild() != null) {
    			bfQueue.enQueue(curNode.getLeftChild().getData());
    		}
    		if (curNode.getRightChild() != null) {
    			bfQueue.enQueue(curNode.getRightChild().getData());
    		}
    		if (!bfQueue.isListEmpty()) {
        		curNode.setData(bfQueue.deQueue());
        		//System.out.println(curNode.getData());
        		bfQueue.printQueue();
        	}else {
        		curNode = null;
        		System.out.println("End");
        	}
    	}
    	
    }



    public void printBST(BSTNode root, String BSTString) {

        if (isEmpty(root)) {
            return;
        }

        System.out.println(BSTString + "\n" + root.getData());
        printBST(root.leftChild, BSTString + "\n");
        printBST(root.rightChild, BSTString + "\n");

    }

    public boolean isEmpty(BSTNode root) {
        if (root == null) {
            return true;
        }
        return false;
    }
}


