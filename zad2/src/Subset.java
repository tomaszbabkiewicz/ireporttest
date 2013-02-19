public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String[] tab = new String[k];
        
        for (int i = 0; i < k; i++) {
            tab[i] = StdIn.readString();
        }
        
        for (int i = 0; i < k; i++) {
            StdOut.println(tab[i]);
        }
    }
}