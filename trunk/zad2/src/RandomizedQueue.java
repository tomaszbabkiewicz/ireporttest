import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private List<Item> randomizedQueue;
    
    // construct an empty randomized queue
    public RandomizedQueue() {
        randomizedQueue = new ArrayList<Item>();
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
        int ind = 0;
        if (size > 0)
            ind = StdRandom.uniform(size);
        if (ind == size)
            randomizedQueue.add(item);
        else 
            randomizedQueue.add(ind, item);
        size++;
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item i = randomizedQueue.get(size - 1);
        randomizedQueue.remove(size - 1);
        size--;
        return i;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        return randomizedQueue.get(size - 1);
    }

    // return an independent iterator over items in random order
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
