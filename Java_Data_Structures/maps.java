import java.util.*;
public class maps {
    public static void main(String[] args) {
        
        //set of ordered pairs, each containing a key and a value. All keys are unique but values can be repeated
        //3 primary methods are: to add a key-value pair, to retrieve a value for a given key, remove a key-value pair from the map
        //can be both ordered (Tree) and unordered (Hash)
        //Unordered has O(1), while ordered is O(log n), but accessing or removing the next key higher or lower than some input k is supported

        //Methods in unordered: put(key, value), get(key), containsKey(key), remove(Key). All methods are O(1) with large constant factor


        //two values (key and value), can be an objects

        HashMap<String, String> countries = new HashMap<String, String>();

        //add a key and value

        countries.put("USA", "Washington DC");
        countries.put("India", "New Delhi");
        countries.put("Russia", "Moscow");
        countries.put("China", "Beijing");
        System.out.println(countries);
        countries.remove("USA");
        countries.get("Russia");
        System.out.println(countries.get("Russia"));
        countries.clear();
        countries.size();
        System.out.println(countries.size());
        
        countries.replace("USA", "Detroit");
        System.out.println(countries.containsKey("Englange"));
        System.out.println(countries.containsValue("Beijing"));

        System.out.println(countries);

        for(String i : countries.keySet()) {  //why does this work- countries.keySet()
            System.out.print(i + "\t"+" = ");
            System.out.println(countries.get(i));
        }

        //Ordered Map
        //supports all methods in hashmaps, in addition to firstKey/firstEntry, lastKey/lastEntry, as well as higherKey/higherEntry and lowerKey/lowerEntry

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        map.put(3, 5);
        map.put(11, 4);
        map.put(10, 94);
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.firstEntry());
        System.out.println(map.lastKey());
        System.out.println(map.lastEntry());
        System.out.println(map.firstKey());

        System.out.println(map.higherKey(4));
        System.out.println(map.higherEntry(5));
        System.out.println(map.lowerKey(12));
        System.out.println(map.lowerEntry(54));

        




    }
}
