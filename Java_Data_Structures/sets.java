import java.util.*;
public class sets {
    public static void main(String[] args) {
        //a set is a collection of objects that contains no duplicates. Two types: Unordered (HashSet), ordered (TreeSet)
        //insertions, deletions, searches in O(1)

        HashSet<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(2);
        hashSet.add(1); //does not do anything since 1 is already in the set (no dups)

        System.out.println(hashSet.contains(1)); //returns a boolean, true
        System.out.println(hashSet.contains(5));
        hashSet.remove(1); //removes the element 1
        System.out.println(hashSet);
        hashSet.remove(0); //nothing happens, element does not exist

        for(int element : hashSet) {
            System.out.println(element);
        }
        //OR
        hashSet.forEach(System.out::println);
        //iterator object designed for looping through a set
        Iterator<Integer> namesIterator = hashSet.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }
        //will print the numbers in an arbitrary order

        //Method to add numbers to a set from a diff collection

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(1);
        Set<Integer> numberSet = new HashSet<>();
        numberSet.addAll(numberList);
        System.out.println(numberSet);

        //ordered sets (TreeSets)
        //Insertions, Deletions, Searches in O(log n) time
        //Same operations as a Hash Set, but also allows for: first(), last(), lower(), higher()

        TreeSet<Integer> set = new TreeSet<Integer>();

        set.add(1);
        set.add(14);
        set.add(9);
        set.add(2);
        System.out.println(set.higher(7)); //higher returns least element stricly greater than
        System.out.println(set.higher(9));
        System.out.println(set.higher(9));
        System.out.println(set.lower(5)); //lower returns the greatest element stricly less
        System.out.println(set.first());
        System.out.println(set.last());
        set.remove(set.higher(6));
        System.out.println(set.higher(23)); //ERROR, no such element exists








    }
}
