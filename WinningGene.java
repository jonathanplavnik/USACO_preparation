import java.util.BitSet;
import java.util.Scanner;

public class WinningGene {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int N = input.nextInt();
        final String S = input.next().trim().substring(0, N);

        int[] result = solution(N, S);
        for (int r : result) {
            System.out.println(r);
        }
        input.close();
    }

    private static int[] solution(int N, String S) {
        int [] result = new int[N];
        BitSet bitset = new BitSet(N);
        String[][] subS = new String[N][];
        // precompute all substrings
        for (int l = 0; l < N; ++l) {
            String[] ss = subS[l] = new String[N - l];
            for (int i = 0, in = N - l; i < in; ++i)
                ss[i] = S.substring(i, i + l + 1);
        }
        String minSubstring = Character.toString((char) ((int)'Z' + 1));
        for (int k = 1; k <= N; ++k) {
            for (int l = 1; l <= k; ++l) {

                String[] ss = subS[l-1];
                for (int kk = 0, kn = N - k + 1; kk < kn; ++kk) {
                    String minValue = minSubstring;
                    int minIndex = Integer.MAX_VALUE;
                    for (int ll = 0, ln = k - l + 1; ll < ln; ++ll) {
                        int pos = ll + kk;
                        String value = ss[pos];
                        if (minValue.compareTo(value) > 0) {
                            minValue = value;
                            minIndex = pos;
                        }
                    }
                    bitset.set(minIndex);
                }

                int v = bitset.cardinality();
                result[v-1]++;
                bitset.clear();
            }
        }
        return result;
    }

}