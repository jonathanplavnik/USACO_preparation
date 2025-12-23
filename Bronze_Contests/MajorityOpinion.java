package Bronze_Contests;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class MajorityOpinion {
    public static void main(String[] args) throws IOException {


		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < T; i++){
			st = new StringTokenizer(r.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(r.readLine());
			int[] cows = new int[N];
			for(int j = 0; j < N; j++){
				cows[j] = Integer.parseInt(st.nextToken());
			}
			Set<Integer> x = solve(N, cows);
			if(x.size() == 0){
				pw.println(-1);
			} else {
				pw.println(String.join(" ", x.stream().map(String::valueOf).collect(Collectors.toList())));
				pw.flush();
			}
		}
		pw.close();
    }
	static int[] cows;

	public static Set<Integer> solve(int N, int[] cows){

		Set<Integer> favorites = new TreeSet<>();
            
            // Check for the pattern in the preferences
            for (int i = 0; i < N-2; i++) {
                // If the current and the next-to-next are the same, add to potential favorites
                if (cows[i] == cows[i + 2]) {
                    favorites.add(cows[i]);
                }
                // If current, next, and next-to-next have at least two same hays, add to potential favorites
                if (cows[i] == cows[i + 1]) {
                    favorites.add(cows[i]);
                }
            }
			if(cows[cows.length-2] == cows[cows.length-1]){
				favorites.add(cows[cows.length-2]);
			}

		return favorites;
	}
}