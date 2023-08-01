/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 3
 *
 * Purpose: The Queue is derived from the linked list, can enQueue elements to the end of a Queue,
 * deQueue from the start of the Queue, and peek the front and back of the Queue. It uses the start and end
 * attributes to get data and set new elements.
 *
 */
public class Queue extends SinglyLinkedList{



    public Queue() {
        super();
    }


    public void enQueue(Currency currency) {
        /*
         *Pre: currency of type Currency
         *
         * Post: a currency added to the end of the queue and increasing the count.
         *
         * Return: None as function is void
         *
         *
         * PSEUDOCODE:
         * enQueue func (currency param)
         *   LinkNode node set to new LinkNode (node = given currency)
         *
         *   if (queueu is empty)
         * 	  start of the queue points to the node
         *   else
         * 	  a new next node pointer is set to the node
         *   end is equal to node
         *   count of queue increases
         */

        LinkNode node = new LinkNode(currency);

        if (isListEmpty()) {
            start = node;
        }else {

            end.setNext(node);
        }
        end = node;
        count++;
    }

    public Currency deQueue() {

        /*
         *Pre: No parameter taken
         *
         * Post: returns exception if user tries to Dequeue from empty Queue
         *
         * Return: Removed currency from the end of the Queue
         *
         * PSEUDOCODE:
         *
         * deQueue func (no parameter)
         *  if (Queue is empty)
         * 	 Throw exception that tells user the queue is empty
         *
         *  Currency = start of the list currency
         *
         *  start = node next to starting node
         *
         *  if(Queue is empty)
         * 	 end = null
         *  Count of Queue decremented
         *  Currency removed returned
         */

        if (isListEmpty()) {
            throw new IllegalArgumentException("Cannot deQueue from an empty Queue.");
        }

        Currency currency = start.getData();


        start = start.getNext();


        if(isListEmpty()) {
            end = null;
        }
        count--;
        return currency;
    }

    public Currency peekFront() {
        /*
         *Pre: No parameter taken
         *
         *Post: Checks for queue elements at the start and null if empty
         *
         * Return: currency at the front of the list
         *
         *
         * PSEUDOCODE:
         * peekFront func (no parameter)
         *  Currency = currency at the start of Queue
         *
         *  if (currency is not null)
         * 	 return the currency
         *  otherwise null is returned if there is no currency or node
         */

        Currency currency = start.getData();

        if (currency != null) {
            return currency;
        }
        return null;

    }

    public Currency peekRear() {
        /*
         *Pre: No parameter taken
         *
         *Post: Checks for queue elements at the end and null if empty
         *
         * Return: Currency at the end of the queue
         *
         * PSEUDOCODE:
         * peekRear func (no parameter taken)
         *  Currency = currency at the end of the queue
         *
         *  if (currency is not null)
         * 	 return the currency
         *  otherwise null is returned
         */


        Currency currency = end.getData();

        if (currency != null) {
            return currency;
        }

        return null;
    }

    public void printQueue() {
        /*
         * Pre: No parameter taken
         *
         * Post: String built if Queue has elements
         *
         * Return: String of entire Queue
         *
         * PSEUDOCODE:
         * printQueue func (no parameter)
         *  Stringbuilder object created with the name queueString
         *
         *  Node of LinkNode object set to the start of Queue
         *
         *  While (node does not equal null)
         * 	 currency object of given node in queue appended to queueString as a String
         * 	 node equals next node pointer
         *
         *  Print out queueString
         *
         */
        StringBuilder queueString = new StringBuilder();
        LinkNode node = start;

        while (node != null) {
            queueString.append(node.getData().toString()).append("\n");
            node = node.getNext();
        }
        System.out.println(queueString);
    }
}