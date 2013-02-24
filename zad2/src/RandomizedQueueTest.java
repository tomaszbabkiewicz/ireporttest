import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RandomizedQueueTest {

    private RandomizedQueue<Integer> underTest;

    @Before
    public void setup() {

        underTest = new RandomizedQueue<Integer>();
    }

    @Test
    public void shouldCreateEmptyQueue() {

        // when
        final boolean isEmpty = underTest.isEmpty();

        // then
        assertThat(isEmpty, is(true));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfEnqueueNull() {

        // when
        underTest.enqueue(null);
    }

    @Test
    public void shouldNotBeEmptyAfterEnqueue() {

        // when
        underTest.enqueue(Integer.valueOf("10"));

        // then
        final boolean isEmpty = underTest.isEmpty();
        assertThat(isEmpty, is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionOnDequeueIfEmpty() {

        // when
        underTest.dequeue();
    }

    @Test
    public void shouldDequeuedFirstItemEnqueuedIfOnly1ItemAdded() {

        // given
        final Integer first = new Integer("10");
        underTest.enqueue(first);

        // when
        final Integer dequeued = underTest.dequeue();

        // then
        assertThat(dequeued, is(first));
    }

    @Test
    public void shouldIsEmptyAfterDequeue() {

        // given
        underTest.enqueue(new Integer("10"));

        // when
        underTest.dequeue();

        // then
        assertThat(underTest.isEmpty(), is(true));
    }

    @Test
    public void shouldDequeueAllEnqueuedItems() {

        // given
        final int size = 10;
        final Integer[] numbers = createIntegers(size);
        enqueueIntegers(numbers);

        // when
        final Integer[] numbersOut = new Integer[size];
        for (int i = 0; i < size; i++) {
            numbersOut[i] = underTest.dequeue();
        }

        // then
        assertThat(Arrays.asList(numbersOut), containsInAnyOrder(numbers));
    }

    // extremely small chance that this could fail if the random order was
    // sorted
    @Test
    public void shouldDequeueInRandomOrder() {

        // given
        final int size = 40;
        final Integer[] numbers = createIntegers(size);
        enqueueIntegers(numbers);

        // when
        final Integer[] numbersOut = new Integer[size];
        for (int i = size - 1; i >= 0; i--) {
            numbersOut[i] = underTest.dequeue();
        }

        // then
        assertThat(Arrays.asList(numbersOut), not(Arrays.asList(numbers)));
    }

    @Test
    public void shouldBehaveCorrectlyOverMultipleEnqueuesDequeues() {

        // when
        final int size = 20;
        final Integer[] numbers = createIntegers(size);
        enqueueIntegers(numbers, 0, 10);

        final Integer[] numbersOut = new Integer[size];
        for (int i = 0; i < 10; i++) {
            numbersOut[i] = underTest.dequeue();
        }

        enqueueIntegers(numbers, 10, 20);

        for (int i = 10; i < 20; i++) {
            numbersOut[i] = underTest.dequeue();
        }

        // then
        assertThat(Arrays.asList(numbersOut), containsInAnyOrder(numbers));
    }

    @Test
    public void shouldReturnCorrectSize() {

        // given
        final int size = 20;
        final Integer[] numbers = createIntegers(size);
        enqueueIntegers(numbers);

        int expectedSize = size;
        for (int i = 0; i < size; i++) {

            if (Math.round(Math.random() + 1) == 1) {
                underTest.enqueue(Integer.valueOf("10"));
                expectedSize++;
            } else {
                underTest.dequeue();
                expectedSize--;
            }
        }

        // when
        final int actualSize = underTest.size();

        // then
        assertThat(actualSize, is(expectedSize));
    }

    @Test
    public void shouldReturnFirstItemEnqueuedOnSmaplingQueueOf1() {

        // given
        final Integer first = new Integer("10");
        underTest.enqueue(first);

        // when
        final Integer sampled = underTest.sample();

        // then
        assertThat(sampled, is(first));
    }

    @Test
    public void shouldNotRemoveItemOnSample() {

        // given
        final Integer first = new Integer("10");
        underTest.enqueue(first);

        // when
        underTest.sample();

        // then
        assertThat(underTest.isEmpty(), is(false));
    }

    @Test
    public void shouldHaveNoNextInIteratorIfNothingEnqueued() {

        // given
        final Iterator<Integer> iter = underTest.iterator();
        final boolean hasNext = iter.hasNext();

        // when
        assertThat(hasNext, is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionOnIteratorNextIfNothingEnqueued() {

        // when
        underTest.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowExceptionOnIteratorRemove() {

        // when
        underTest.iterator().remove();
    }

    @Test
    public void shouldIterateOverAllItemsInQueue() {

        // given
        final int size = 20;
        final Integer[] numbers = createIntegers(size);
        enqueueIntegers(numbers);

        // when
        final Integer[] numbersOut = new Integer[size];
        int i = 0;
        for (Integer number : underTest) {

            numbersOut[i++] = number;
        }

        // when
        assertThat(Arrays.asList(numbersOut), containsInAnyOrder(numbers));
    }
    
    @Test
    public void iteratorReturnsCorrectItemsAfterSequenceOfEnqueueAndDequeue () {

        RandomizedQueue<String> rq = new RandomizedQueue<String>();     
        LinkedList<String> list = new LinkedList<String>();

        int N = 30000;

        String item;
        for (Integer i = 0; i < N; i++) {
            if (!rq.isEmpty() && Math.random() < 0.5) {
                item = rq.dequeue();
                list.remove(list.indexOf(item));
            }
            else {
                item = i.toString();
                rq.enqueue(item);
                list.push(item);
            }
        }

        Iterator<String> iterator = rq.iterator();
        LinkedList<String> list2 = new LinkedList<String>();
        while(iterator.hasNext()) {
            item = iterator.next();
            list2.push(item);
        }

        Assert.assertTrue(equivalent(list,list2));
    }

    public static <T> boolean equivalent (LinkedList<T> l1, LinkedList<T> l2) {
        if (l1.size() != l2.size()) return false;

        boolean ans = true;
        for (int i = 0; i < l1.size() && ans; i++) {
            boolean localans = false;
            for (int j = 0; j < l2.size(); j++) {
                if (l1.get(i) == l2.get(j)) {
                    localans = true;
                    break;
                }
            }
            ans = ans && localans;          
        }

        return ans;
    }
    

    private void enqueueIntegers(Integer[] numbers, int from, int to) {
        for (int i = from; i < to; i++) {
            underTest.enqueue(numbers[i]);
        }
    }

    private void enqueueIntegers(Integer[] numbers) {
        for (Integer number : numbers) {
            underTest.enqueue(number);
        }
    }

    private Integer[] createIntegers(int size) {

        final Integer[] numbers = new Integer[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.valueOf(i + 1);
        }
        return numbers;
    }
}