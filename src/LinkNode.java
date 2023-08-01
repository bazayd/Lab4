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

    private Currency data;

    private LinkNode next;

    public LinkNode(Currency data) {
        this.data = data;
        this.next = null;
    }



    public Currency getData() {
        return data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setData(Currency data) {
        this.data = data;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }


}