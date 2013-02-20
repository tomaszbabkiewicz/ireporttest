import java.util.Iterator;

public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        
        RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
        
        for (int i = 0; i < k; i++) {
             rQueue.enqueue(StdIn.readString());
        }
        
        Iterator<String> i = rQueue.iterator();
        while (i.hasNext()) {
           StdOut.println(i.next());
        }
    }
}