import java.util.*;

public class multiset {
    static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();

    public static void main(String[] args) {

    }

    static void add(int x) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }

    static void remove(int x) {
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) {
            multiset.remove(x);
        }
    }
}
