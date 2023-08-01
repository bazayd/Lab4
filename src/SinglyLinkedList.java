/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 3
 *
 * Purpose: Creates a Linked List object that is able to add, remove, and find/get elements of type currency.
 * The Linked List uses nodes of type LinkNode to set the head and the tail of the node along with the other nodes.
 *
 */
public class SinglyLinkedList {

    protected int count;
    protected LinkNode start;

    protected LinkNode end;

    public SinglyLinkedList() {
        this.count = 0;
        this.start = null;
        this.end = null;
    }

    public SinglyLinkedList(LinkNode start, LinkNode end) {
        this.count = 0;
        this.start = start;
        this.end = end;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LinkNode getStart() {
        return start;
    }

    public void setStart(LinkNode start) {
        this.start = start;
    }

    public LinkNode getEnd() {
        return end;
    }

    public void setEnd(LinkNode end) {
        this.end = end;
    }


    public void addCurrency(Currency currency, int index) {
        /*
         *Pre: currency of type Currency, index of type integer
         *
         * Post: illegal argument exception thrown if index is out of bounds otherwise currency added to given index
         *
         * Return: None, function is void
         *
         * PSEUDOCODE:
         * addCurrency func (currency param, index param)
         *   if (index is less than 0 or greater than list count)
         *       out of bounds exception thrown
         *
         *   node set to currency object
         *
         *   if (index equals zero)
         *       node next pointer set to start of the list
         *       start of list equal to node
         *       if (list count equals 0)
         *           end equal to node given
         *   else if (index equals to list count)
         *       end next pointer equal to node
         *       end/tail of node equal to given node
         *   else
         *       previouseNode is equal to index - 1
         *       set current node next pointer to the previouse node's next pointer
         *       previous Node next pointer set to the current node
         *   count of list increments
         *
         */
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Index is out of bounds.");
        }

        LinkNode node = new LinkNode(currency);

        if (index == 0) {
            node.setNext(start);
            start = node;
            if (count == 0) {
                end = node;
            }
        }else if (index == count) {
            end.setNext(node);
            end = node;
        }else {
            LinkNode previousNode = getNodeIndex(index - 1);
            node.setNext(previousNode.getNext());
            previousNode.setNext(node);
        }

        count++;
    }

    public Currency removeCurrency(Currency currency) {
        /*
         *Pre: currency of type Currency
         *
         * Post: checks for node of type currency, going through entire linked list
         *
         * Return: currency or null if currency not found
         *
         *
         * PSEUDOCODE:
         * removeCurrency func (currency param)
         *   if (count of list equal to zero)
         *      return null
         *   previous node equal to null
         *   current node is equal to the start of the list
         *
         *   while (node is not null)
         *       if (node's currency object is equal to parameter currency)
         *           if (previous node is null)
         *               start is equal to current node's next pointer
         *               if (list count is equal to 1)
         *                   end of list is equal to null
         *           else
         *               previous node's next pointer set to current node's next pointer
         *               if (current node = end of list)
         *                   end is now the previous node
         *           count of list decremented
         *           removed currency returned
         *       previous equal to current node
         *       node is now equal current node's next pointer
         *   otherwise return null
         */
        if (count == 0) {
            return null;
        }

        LinkNode previous = null;
        LinkNode node = start;

        while (node != null) {
            if (node.getData().isEqual(currency)) {
                if (previous == null) {
                    start = node.getNext();
                    if (count == 1) {
                        end = null;
                    }
                } else {
                    previous.setNext(node.getNext());
                    if (node == end) {
                        end = previous;
                    }
                }

                count--;
                return node.getData();
            }

            //
            previous = node;
            node = node.getNext();
        }

        return null;
    }

    public Currency removeCurrency(int index) {
        /*
         *Pre: index of type integer
         *
         *Post: exception thrown if index is not valid and otherwise finds currency with given index
         *
         * Return: currency at given index
         *
         * PSEUDOCODE:
         *   removeCurrency func (index param)
         *       if (index is less than 0 or index greater than or equal to count)
         *           index out of bounds exception thrown
         *       if (index is equal to 0)
         *           currency is set to start of the list
         *           start is now equal to start's next pointer
         *           count of list decrements
         *           if (count is equal to zero)
         *               end is equal to null
         *           currency returned
         *       previous node is at index - 1
         *       current node is at previous index's next pointer
         *
         *       previous node's next pointer set to current node's next pointer
         *       list count decremented
         *       if (node at the end of the list)
         *           end is now previous node
         *       currency removed returned
         */
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is not valid");
        }

        if (index == 0) {
            Currency currency = start.getData();
            start = start.getNext();
            count--;
            if (count == 0) {
                end = null;
            }
            return currency;
        }

        LinkNode previous = getNodeIndex(index - 1);
        LinkNode node = previous.getNext();

        previous.setNext(node.getNext());
        count--;
        if (node == end) {
            end = previous;
        }
        return node.getData();

    }

    public int findCurrency(Currency currency) {
        /*
         *Pre: currency of type Currency
         *
         * Post: finds currency with currency object param
         *
         * Return: index or -1 if currency not found
         *
         * PSEUDOCODE:
         *   findCurrency func (currency param)
         *       node to be found set to start of list
         *       listIndex set to zero
         *       while (node to be found isn't null)
         *           if (node's currency equal to param currency)
         *              index at where currency at is returned
         *           else
         *               node to be found's next pointer is set
         *               index of list incremented
         *       -1 returned if no currency is found
         *
         */
        LinkNode findNode = start;
        int listIndex = 0;
        while(findNode != null) {
            if (findNode.getData().isEqual(currency)) {
                return listIndex;
            }else {
                findNode = findNode.getNext();
                listIndex++;
            }
        }
        return -1;
    }

    public Currency getCurrency(int index) {
        /*
         * Pre: index of type integer
         *
         * Post: get currency with parameter index
         *
         * Return: return currency
         *
         * PSEUDOCODE:
         * getCurrency(index param)
         *   currentNode is equal to start of the list
         *   for (integer i equal to zero, i iterates while i is less than given index, i increments)
         *         currentnode is equal to currentnode's next pointer
         *   return currency found at index
         */

        LinkNode curNode = start;

        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }
        return curNode.getData();
    }

    public String printList() {
        /*
         *Pre: no parameter taken
         *
         * Post: constructs string of linked list
         *
         * Return: list string
         *
         * PSEUDOCODE:
         * printList func(no param)
         *  current node is set to start of the list
         *  string resList equal to empty string
         *
         * for (integer i equal to 0, i less than list's count, i increments)
         *    currency from current node appended to resLIst
         *    current node's next pointer set
         * return complete linked list in string form
         */
        LinkNode curNode = start;
        String resList = "";

        for (int i = 0; i < count; i++) {

            resList += (curNode.getData() + "	");
            curNode = curNode.getNext();

        }

        return resList;
    }

    public boolean isListEmpty() {
        /*
         *Pre: no param given
         *
         * Post: checks for null list
         *
         * Return: true or false
         *
         * PSEUDOCODE:
         * isListEmpty ( no param)
         *   return true or false if start of list is null
         */
        return start == null;
    }

    public int countCurrency() {
        /*
         *Pre: no param given
         *
         *Post: count of currency found
         *
         * Return: integer count of list
         *
         * Pseudocode:
         * countCurrency func (no param)
         *   return list's count
         *
         */
        return count;
    }

    private LinkNode getNodeIndex(int index) {
        /*
         *Pre: index of type integer
         *
         * Post: sets node to start of list and index at zero, gets node at index. Easy when index is given to
         * avoid unnecessary code
         *
         * PSEUDOCODE:
         * getNodeIndex func(index param)
         *   node set to start of list
         *   current Index is zero
         *
         *   while(current index is less than given index)
         *       node is equal to node's next pointer
         *       currentIndex incremented
         *
         *       if (node is equal to null)
         *           exception thrown, out of bounds
         *   node returned
         */

        LinkNode node = start;

        int currIndex = 0;

        while (currIndex < index) {
            node = node.getNext();
            currIndex++;

            if (node == null) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
        }
        return node;
    }

}