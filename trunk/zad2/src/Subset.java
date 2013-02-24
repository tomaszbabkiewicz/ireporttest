import java.util.Iterator;

public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        
        RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
        
        while (!StdIn.isEmpty()) {
            rQueue.enqueue(StdIn.readString());
        }
        
        Iterator<String> i = rQueue.iterator();
        
        for (int ind = 0; ind < k; ind++) {
           if (i.hasNext()) {
               StdOut.println(i.next());
           } else {
               break;
           }
        }
    }
}