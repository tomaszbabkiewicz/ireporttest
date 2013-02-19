import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private List<Item> randomizedQueue;
    
    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        size++;
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        size--;
        return null;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        return null;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        Iterator<Item> it = new Iterator<Item>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < size) && (randomizedQueue.get(currentIndex) != null);
            }

            @Override
            public Item next() {
                if (currentIndex == size)
                    throw new NoSuchElementException();
                return randomizedQueue.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
