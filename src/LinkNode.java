/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 3
 *
 * Purpose: LinkNode creates nodes of type currency with a LinkNode next pointer. It allows Linked Lists to access
 * the currency elements and the next currency it points to.
 *
 */
public class LinkNode {

    private BSTSearchTree.BSTNode data;

    private LinkNode next;

    public LinkNode(BSTSearchTree.BSTNode currency) {
        this.data = currency;
        this.next = null;
    }



    public BSTSearchTree.BSTNode getData() {
        return data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setData(BSTSearchTree.BSTNode data) {
        this.data = data;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }


}