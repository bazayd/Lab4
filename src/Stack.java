/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 3
 *
 * Purpose: The Stack class is derived from the Linked List class, it can push elements to the top of a stack.
 * It can pop elements from the top of the stack, and return elements from the top of the class. The stack is
 * a great way to show examples of actual piles of money, in this case the dollar currency.
 *
 */
public class Stack extends SinglyLinkedList{


    public Stack() {
        super();
    }

    public void push(Currency obj) {
        /*
         * increase object count
         * create new node
         * newNode.next = null
         * new node.data = obj data
         */

        /*
         * start is bottom/tail of stack
         * end is top/head of stack
         */
        this.setCount(this.getCount() + 1);
        LinkNode newNode = new LinkNode(obj);

        LinkNode top = getStart();
        newNode.setNext(top);
        setStart(newNode);




    }

    public Currency pop() {
        /*
         *Pre: no parameter given
         *
         *Post: removes object from top of the stack
         *
         * Return: currency object
         *
         *PSEUDOCODE:
         * pop func(no param)
         * 	count set to count received minus 1
         * 	topNode set to start of the stack]
         * 	removed currency object is topNode
         * 	start set to topNode's next node pointer
         * 	top Node returned
         */
        this.setCount(this.getCount() - 1);
        LinkNode topNode = getStart();
        Currency removed = topNode.getData();
        setStart(topNode.getNext());
        return topNode.getData();

    }

    // take the start data and return it
    public Currency peek() {
        /*
         *Pre: no parameter taken
         *
         *Post: top of stack peeked at
         *
         * Return: currency at top of stack
         *
         * PSEUDOCODE:
         * peek func(no param)
         * 	top node equal to start of the stack
         * 	returns currency of top node
         */
        LinkNode top = getStart();
        return top.getData();

    }

    //have a node element
    //keep on taking the next element and print it
    public void printStack() {
        /*
         *Pre: no param given
         *
         * Post: string of stack built
         *
         * Return: stack string
         *
         * PSEUDOCODE:
         * printStack func(no param)
         * 	current node is set to top of the stack
         * 	while (current node is not null)
         * 		current node gets printed out
         * 		current set to current node's next pointer
         */
        LinkNode cur = getStart();
        while(cur != null) {
            System.out.println(cur.getData()+ " ");
            cur = cur.getNext();
        }
    }
}