/**
 * @author Minger Lin on 12/02/2020
 * @param <T>
 * Purpose: implementation of Deque interface: powered by a resizing array
 */
public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    /* Creates an empty array deque */
    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /* private method for resizing up */
    private void resize(int capacity) {
        T[] newitems = (T[]) new Object[capacity];
        int currHead = wrap(nextFirst + 1);
        int currTail = wrap(nextLast - 1);
        if (currHead > currTail) {
            System.arraycopy(items, currHead, newitems, 0, items.length - currHead);
            System.arraycopy(items, 0, newitems, items.length - currHead, size - items.length + currHead);
        } else {
            System.arraycopy(items, currHead, newitems, 0, size);
        }
        nextFirst = newitems.length - 1;
        nextLast = size;
        items = newitems;
    }

    /* return the nextFront or nextLast */
    private int wrap(int p) {
        int r = p % items.length;
        if (r < 0) {
            r += items.length;
        }
        return r;
    }

    /* Returns true if deque needs usage to resize, false otherwise */
    private boolean checkUsage() {
        float usage = (float) size/items.length;
        if (items.length >= 16 && usage < 0.25) {
            return true;
        }
        return false;
    }

    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size++;
        nextFirst = wrap(nextFirst - 1);
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size++;
        nextLast = wrap(nextLast + 1);
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println("\n");
    }

    /* Removes and returns the item at the front of the deque. If no such item
    exists, returns null */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (checkUsage()) {
            resize(items.length / 2);
        }
        int indexFirst = wrap(nextFirst + 1);
        T removed = items[indexFirst];
        items[indexFirst] = null;
        nextFirst = wrap(nextFirst + 1);
        size--;
        return removed;
    }

    /* Removes and returns the item at the back of the deque. If no such item
    exists, returns null */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (checkUsage()) {
            resize(items.length / 2);
        }
        int indexLast = wrap(nextLast - 1);
        T removed = items[indexLast];
        items[indexLast] = null;
        nextLast = wrap(nextLast - 1);
        size--;
        return removed;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next
    item, and so forth. If no such item exists, returns null. Must not alter
    the deque!*/
    public T get(int index){
        if (index < 0 || index > items.length) {
            return null;
        }
        return items[wrap(nextFirst + index + 1)];
    }
}
