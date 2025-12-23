import java.util.Scanner;

public class TransformingPairs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        for (int i = 0; i < T; ++i) {
            final long A = input.nextLong();
            final long B = input.nextLong();
            final long C = input.nextLong();
            final long D = input.nextLong();
            long result = solution(A, B, C, D);
            System.out.println(result);
        }
        input.close();
    }

    // Find minimal number of spells to transform A -> C and B -> D
    private static long solution(long A, long B, long C, long D) {
        long c = C, d = D, result = 0;
        while (true)
        {
            // edge conditions
            if (c == A && d == B) return result;
            if (c < A || d < B) return -1L;
            if (c == d) return -1L;
            if (c > d) {
                // max valid number of steps (greedy)
                long k = Math.max(1, (c - A) / d);
                c -= k * d;
                result += k;
            } else {
                long k = Math.max(1, (d - B) / c);
                d -= k * c;
                result += k;
            }
        }
    }
}