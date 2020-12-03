/**
 * @author Minger Lin on 12/01/2020
 * @param <T>
 * Purpose: implementation of Deque interface: powered by a Linked List
 * using circular sentinel
 */
public class LinkedListDeque<T> {
    public Node sentinel;
    public int size;

    /* Creates an empty linked list deque */
    public LinkedListDeque(){
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (size == 0) {
            addLast(item);
            return;
        }
        size += 1;
        Node temp = sentinel.next;
        sentinel.next = new Node(item);
        temp.prev = sentinel.next;
        sentinel.next.next = temp;
        sentinel.next.prev = sentinel;  // not sure if necessary
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if (size == 0) {
            sentinel.next = new Node(item);
            sentinel.next.next = sentinel;
            sentinel.next.prev = sentinel;
            sentinel.prev = sentinel.next;
        } else {
            Node tempLast = sentinel.prev;
            tempLast.next = new Node(item);
            tempLast.next.next = sentinel;
            tempLast.next.prev = tempLast;
            sentinel.prev = tempLast.next;
        }
        size +=1;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() { return size == 0; }

    /* Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line */
    public void printDeque() {
        int counter = size;
        Node sentinalCopy = sentinel;
        while (counter != 0) {
            System.out.print(sentinalCopy.next.item + " ");
            sentinalCopy = sentinalCopy.next;
            counter -= 1;
        }
        System.out.println("\n");
    }

    /* Removes and returns the item at the front of the deque. If no such item
    exists, returns null */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node toReturn = sentinel.next;
            sentinel.next = null;
            sentinel.prev = null;
            size -= 1;
            return toReturn.item;
        } else {
            Node toReturn = sentinel.next;
            toReturn.next = sentinel;
            sentinel.next = toReturn.next;
            size -= 1;
            return toReturn.item;
        }
    }

    /* Removes and returns the item at the back of the deque. If no such item
    exists, returns null */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            Node toReturn = sentinel.prev;
            toReturn.prev.next = sentinel;
            sentinel.prev = toReturn.prev;
            size -= 1;
            return toReturn.item;
        }
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next
    item, and so forth. If no such item exists, returns null. Must not alter
    the deque!*/
    public T get(int index){
        if (index < 0 || index > size() - 1) {
            return null;
        } else if (index == (size-1)) {
            return sentinel.prev.item;
        } else {
            Node sentinelCopy = sentinel.next;
            for (int i = 0; i < index; i++) {
                sentinelCopy = sentinelCopy.next;
            }
            return sentinelCopy.item;
        }
    }

    /* Same as get, but uses recursion*/
    public T getRecursive(int index) {
        if (size == 0) {
            return null;
        }
        return getRecursiveH(index, sentinel.next, 0);
    }

    /* private helper method for getRecursive */
    private T getRecursiveH(int index, Node temp, int counter){
        if (counter == index) {
            return temp.item;
        }
        return getRecursiveH(index, temp.next, counter+1);
    }

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        /* Creates a null Node */
        private Node() {
            prev = null;
            item = null;
            next = null;
        }
        /* Creates a Node with given value */
        private Node(T val) {
            item = val;
        }
    }

}