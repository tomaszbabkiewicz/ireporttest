import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private LinkedList<Item> randomizedQueue;
    
    // construct an empty randomized queue
    public RandomizedQueue() {
        randomizedQueue = new LinkedList<Item>();
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
        randomizedQueue.add(item);
        size++;
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        int ind = 0;
        if (size > 0)
            ind = StdRandom.uniform(size);
        Item i = randomizedQueue.get(ind);
        randomizedQueue.remove(ind);
        size--;
        return i;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        int ind = 0;
        if (size > 0)
            ind = StdRandom.uniform(size);
        return randomizedQueue.get(ind);
    }
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        
        private int[] indexes;
        private int index = 0;
        
        public RandomizedQueueIterator() {
            indexes = new int[size];
            for (int i = 0; i < size; i++)
                indexes[i] = i;
            StdRandom.shuffle(indexes);
        }

        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return randomizedQueue.get(indexes[index++]);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
