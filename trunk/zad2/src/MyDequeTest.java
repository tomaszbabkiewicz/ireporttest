import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

// Testing class for Deque structure

public class MyDequeTest {
    
    //@Test
    public void testRandomCallSequencesDeque() {
        String   meth;
        String[] methods = {"addFirst", "addLast", "removeFirst", "removeLast"};
        int      runs[] = {1024, 4096, 16384, 262144, 1048576};
        Deque<Integer> q = new Deque<Integer>();
        boolean passed = true;
        try {
            for (int n : runs) {
                Stopwatch timer = new Stopwatch();
                for (int i = 0; i < n; i++ ) {
                    meth = methods[StdRandom.uniform(methods.length)];

                    // Method takes parameters
                    if (meth.equals("addFirst") || meth.equals("addLast")) {
                        q.getClass().getMethod(meth, Object.class).invoke(q, i);

                    // Method takes no parameters
                    } else {
                        // Bypass methods that require item on queue
                        if ((meth.equals("removeFirst") || meth.equals("removeLast"))) {
                            if (q.isEmpty()) continue;
                        }

                        q.getClass().getMethod(meth).invoke(q);
                    }
                }
                StdOut.println(n + " : " + timer.elapsedTime());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            passed = false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            passed = false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            passed = false;
        } catch (InvocationTargetException e) {
            // The above exceptions are likely errors in reflection.
            // This is almost assuredly an error in the object under test.
            e.printStackTrace();
            passed = false;
        }
        assertTrue(passed);
    }
    
    @Test
    public void testRandomCallSequences() {
        String   meth;
        String[] methods = {"enqueue", "sample", "dequeue", "isEmpty", "size"};
        int      runs[] = {1024, 4096, 16384, 262144, 1024000};
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        boolean passed = true;
        try {
            for (int n : runs) {
                Stopwatch timer = new Stopwatch();
                for (int i = 0; i < n; i++ ) {
                    meth = methods[StdRandom.uniform(methods.length)];

                    // Method takes parameters
                    if (meth.equals("enqueue")) {
                        q.getClass().getMethod(meth, Object.class).invoke(q, i);

                    // Method takes no parameters
                    } else {
                        // Bypass methods that require item on queue
                        if ((meth.equals("dequeue") || meth.equals("sample"))) {
                            if (q.isEmpty()) continue;
                        }

                        q.getClass().getMethod(meth).invoke(q);
                    }
                }
                StdOut.println(n + " : " + timer.elapsedTime());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            passed = false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            passed = false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            passed = false;
        } catch (InvocationTargetException e) {
            // The above exceptions are likely errors in reflection.
            // This is almost assuredly an error in the object under test.
            e.printStackTrace();
            passed = false;
        }
        assertTrue(passed);
    }
} // End MyDequeTest