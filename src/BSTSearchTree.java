import java.io.BufferedWriter;
import java.io.IOException;
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

		public boolean isEqual(Currency currency) {
			// TODO Auto-generated method stub
			return false;
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


    // Using recursive function, returns boolean value to verify dollar amount
    public boolean search(Currency dollar) {
        return searchRec(root, dollar);
    }

    /*
    //     * search bst for a value
    //     *
    //     * pre: root is the root of the bst, dollar is the target value
    //     *
    //     * post: prints out the node and not found if it is not found
    //     *
    //     */
    private boolean searchRec(BSTNode root, Currency dollar) {
        if (root == null) {
            return false; // Base case: element not found
        }

        if (dollar.isEqual(root.data)) {
            return true; // Element found
        } else if (dollar.isGreater(root.data)) {
            return searchRec(root.getRightChild(), dollar); // Recur on the right subtree
        } else {
            return searchRec(root.getLeftChild(), dollar); // Recur on the left subtree
        }
    }


    /*Insert method that uses recursive insert function
    *
    * Pre: Dollar of Currency type
    *
    * Post: checks for empty tree and uses recursion to inert
    *
    *Return: none, only inserts values into the binary tree
     */
    public void insert(Currency dollar) {
        if (isEmpty(root)) {
            root = new BSTNode(dollar);
        } else {
            insert(root, dollar);
        }
    }

    /*
    *Uses Recursion to check binary tree and find the right place to insert dollar amount
    *
     * Pre: dollar that needs to be inserted with reference to the root
     * 
     * post: dolalr is inserted into the tree
     *
     * Return: None, only inserts into the tree
     */
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


    /*Deletes a desired dollar amount with recursion
    *
     * pre: dollar of Currency/Dollar type
     * 
     * post:dollar node is deleted if not found, root is unchanged
     *
     * Return: true or false depending on if the root is null or not
     */

    public boolean delete(Currency dollar) {
        root = deleteRec(root, dollar);
        return root != null;
    }

    /*
    *Uses Recursion to check binary tree for dollar amount and deletes it
    *
    * Pre: root of type BSTNode and dollar of type Currency/Dollar
    *
    * Post: Replaces dollar amount with another value depending on if the amount is greater or less than, as
    * well as if the tree has one or no child
    *
    * Return: value of root, depending on what it is set to
     */
    private BSTNode deleteRec(BSTNode root, Currency dollar) {
        if (root == null) {
            return null; // Base case: element not found, return null
        }

        if (dollar.isGreater(root.data)) {
            root.rightChild = deleteRec(root.getRightChild(), dollar); // Recur on the right subtree
        } else if (dollar.isGreater(root.data)) {
            root.leftChild = deleteRec(root.getLeftChild(), dollar); // Recur on the left subtree
        } else {
            // Case 1 and 2: Node with one or no child
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }

            // Case 3: Node with two children
            root.data = getMin(root.getRightChild()); // Replace the node with the minimum value in the right subtree
            root.rightChild = deleteRec(root.getRightChild(), root.data); // Delete the node with the minimum value
        }

        return root;
    }

    
    //getters for min and max
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

    /*
     *  inorder traversal: left-node-right
     *  
     *  pre: entry node of a tree or subtree
     *  
     *  post: each node has been processed in order
     */
    public void InOrderTraversal(BSTNode root) {
        if (isEmpty(root)) {
            return;
        }

        InOrderTraversal(root.getLeftChild());
        System.out.println(root.getData() + "\n");
        InOrderTraversal(root.getRightChild());
    }

    public void inOrderTraversalWriter(BufferedWriter writer, BSTNode root) throws IOException {
        if (!isEmpty(root)) {
            inOrderTraversalWriter(writer, root.getLeftChild());
            writer.write(root.getData() + " ");
            inOrderTraversalWriter(writer, root.getRightChild());
        }
    }

    /*
     * traverse binary tree in node-left-right sequence
     * 
     * pre: root is the entry node of a tree or subtree
     * 
     * post: each node has been processed in order
     */
    public void PreorderTraversal(BSTNode root) {
        if (isEmpty(root)) {
            return;
        }

        System.out.println(root.getData());
        PreorderTraversal(root.getLeftChild());
        PreorderTraversal(root.getRightChild());
    }

    public void preOrderTraversalWriter(BufferedWriter writer, BSTNode root) throws IOException{
        if (!isEmpty(root)) {
            writer.write(root.getData() + " ");
            preOrderTraversalWriter(writer, root.getLeftChild());
            preOrderTraversalWriter(writer, root.getRightChild());
        }
    }

    /*
     * traverse a binary tree in left-right-node sequence
     * 
     * pre: root is the entry node of a tree or subtree
     * 
     * post: each node has been processed in order
     */
    public void PostorderTraversal(BSTNode root) {
        if (isEmpty(root)) {
            return;
        }

        PreorderTraversal(root.getLeftChild());
        PreorderTraversal(root.getRightChild());
        System.out.println(root.getData());
    }

    public void postOrderTraversalWriter(BufferedWriter writer, BSTNode root) throws IOException {
        if (!isEmpty(root)) {
            preOrderTraversalWriter(writer, root.getLeftChild());
            preOrderTraversalWriter(writer, root.getRightChild());
            writer.write(root.getData() + " ");
        }
    }
    /*
     * BreadthFirstTraversal Code
     * 
     * pre: root is node to be processed
     * 
     * post: tree has been processed
     */
    public void BreadthFirstTraversal(BSTNode root) {
    	
    	//store the root and create a queue
    	BSTNode curNode = root;
    	Queue bfQueue = new Queue();

    	//loop while curnode is not null
    	while(curNode != null) {
    		
    		//print the data
    		System.out.println(curNode.getData());
    		
    		//check left and right, if they are not null add htem to queue
    		if (curNode.getLeftChild() != null) {

    			bfQueue.enQueue(curNode.getLeftChild());
    		}
    		if (curNode.getRightChild() != null) {
    			
    			bfQueue.enQueue(curNode.getRightChild());
    		}
    		
    		//check if queue is not empty
    		if (!bfQueue.isListEmpty()) {
    			
        		//set curNode as dequeued element
    			curNode = bfQueue.deQueue();
    			

        	}else {
        		curNode = null;
        	}
    	}
    	
    }

    /*
    *Breadth First Traversal Writer uses the same method of Breadth first Traversal to write into the OUtput.txt file
    *
    * Pre: Writer of BufferedWriter type
    *
    * Post: Goes through binary tree with BreadthFirstTraversal and visits each node and writes to the txt file
    *
    *Return: None, void type and only writes to file
     */
    public void breadthFirstTraversalWriter(BufferedWriter writer) throws IOException{
        BSTNode curNode = root;
        Queue bfQueue = new Queue();

        //loop while curnode is not null
        while(curNode != null) {

            //print the data
            writer.write(curNode.getData() + " ");
            //check left and right, if they are not null add htem to queue
            if (curNode.getLeftChild() != null) {

                bfQueue.enQueue(curNode.getLeftChild());
            }
            if (curNode.getRightChild() != null) {

                bfQueue.enQueue(curNode.getRightChild());
            }

            //check if queue is not empty
            if (!bfQueue.isListEmpty()) {

                //set curNode as dequeued element
                curNode = bfQueue.deQueue();


            }else {
                curNode = null;
            }
        }
    }


    /*
    *Prints out the binary search tree in order with recursion
    *
    * Pre: root of type BSTNode, BSTString of type String
    *
    * Post: Goes through entire BST and through recursion to print each node
    *
    * Return: None, will print out to the screen everytime function is called.
     */
    public void printBST(BSTNode root, String BSTString) {

        if (isEmpty(root)) {
            return;
        }

        System.out.println(BSTString + "\n" + root.getData());
        printBST(root.leftChild, BSTString + "\n");
        printBST(root.rightChild, BSTString + "\n");

    }

    /*
    *Checks to see if binary tree is empty or not
    *
    * Pre: root of type BSTNode
    *
    * Post: checks off the root node to see if it is null
    *
    * Return: True or false
    *
     */
    public boolean isEmpty(BSTNode root) {
        if (root == null) {
            return true;
        }
        return false;
    }
}


