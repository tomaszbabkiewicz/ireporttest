import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Node head;
    private Node tail;
    
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    // construct an empty deque
    public Deque() {
        size = 0;
        head = null;
        tail = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node newHead = new Node();
        newHead.item = item;
        newHead.next = head;
        if (head != null)
            head.previous = newHead;
        else
            tail = newHead;
        head = newHead;
        size++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node newTail = new Node();
        newTail.item = item;
        newTail.previous = tail;
        if (tail != null)
            tail.next = newTail;
        else
            head = newTail;
        tail = newTail;
        size++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node oldHead = head;
        head = head.next;
        oldHead.next = null;
        oldHead.previous = null;
        if (head != null)
            head.previous = null;
        size--;
        return oldHead.item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node oldTail = tail;
        tail = tail.previous;
        oldTail.next = null;
        oldTail.previous = null;
        if (tail != null)
            tail.next = null;
        size--;
        return oldTail.item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
