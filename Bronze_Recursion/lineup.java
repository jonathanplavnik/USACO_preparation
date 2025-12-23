package Bronze_Recursion;
import java.util.*;
import java.io.*;

public class lineup {
    static final int RESTRICT_LEN = 6;
    // List of cows, in alphabetical order
    static final List<String> COWS = Arrays.asList( // list of all cows
            "Beatrice", "Belinda", "Bella", "Bessie",
            "Betsy", "Blue", "Buttercup", "Sue"
    );

    static List<List<String>> orderings = new ArrayList<>();

    static void build(List<String> ordering) { //standard permutation function
        // Finished building permutation
        if (ordering.size() == 8) {
            orderings.add(new ArrayList<>(ordering));
            return;
        }

        for (String cow : COWS) {
            if (!ordering.contains(cow)) {
                ordering.add(cow);
                build(ordering);
                ordering.remove(ordering.size() - 1);
            }
        }
    }

    // Returns index of a cow in an ordering
    static int loc(List<String> order, String cow) {
        return order.indexOf(cow);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("lineup.out"));

        int n = Integer.parseInt(reader.readLine());

        List<Pair<String, String>> restrictions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String cow1 = "";
            String cow2 = "";
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < RESTRICT_LEN; j++) {
                String word = tokenizer.nextToken();
                cow1 = cow1.isEmpty() ? word : cow1;
                cow2 = word;
            }
            restrictions.add(new Pair<>(cow1, cow2));
        }

        // Build all possible orderings of cows
        build(new ArrayList<>());
        for (List<String> order : orderings) {
            boolean ok = true;
            for (Pair<String, String> rule : restrictions) {
                if (Math.abs(loc(order, rule.first) - loc(order, rule.second)) > 1) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                for (String cow : order) {
                    writer.println(cow);
                }
                break;
            }
        }

        reader.close();
        writer.close();
    }

    static class Pair<X, Y> {
        X first;
        Y second;

        Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }
    }
}