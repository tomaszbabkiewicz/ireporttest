import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size = 0;
    private List<Item> deque;
    
    // construct an empty deque
    public Deque() {
        deque = new ArrayList<Item>();
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
        deque.add(0, item);
        size++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();
        deque.add(item);
        size++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item i = deque.get(0);
        deque.set(0, null);
        deque.remove(0);
        size--;
        return i;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item i = deque.get(size - 1);
        deque.set(size - 1, null);
        deque.remove(size - 1);
        size--;
        return i;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int currentIndex = 0;
            
            @Override
            public boolean hasNext() {
                return (currentIndex < size) && (deque.get(currentIndex) != null);
            }

            @Override
            public Item next() {
                if (currentIndex == size) throw new NoSuchElementException();
                return deque.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
}
