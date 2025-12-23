package Bronze_Complete_Search;
import java.util.*;
import java.io.*;

class Event {
	int cow;
	int time;
	char state;

	Event(int cow, int time, char state){
		this.cow = cow;
		this.time = time;
		this.state = state;
	}
}
public class cowntactTracingFAIL {


    static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
		// Kattio io = new Kattio("tracing");

		int N = io.nextInt(); // num of cows
		int T = io.nextInt(); // num of interactions

		String status = io.next(); // health of all cows
		Event[] events = new Event[T]; // list of all interactions between cows

		for(int i = 0; i < T; i++){
			int t = io.nextInt();
			int a = io.nextInt();
			int b = io.nextInt();
			events[i] = new Event(a, t, status.charAt(b-1));
		}

		Arrays.sort(events, Comparator.comparingInt(e -> e.time)); // sorts events based on time

		int[] handshakeCount = new int[N]; // track handshakes
		boolean[] infected = new boolean[N]; // track infections

		for(int i = 0; i < N; i++){
			infected[i] = status.charAt(i) == '1'; // fill infected array
		}

		for(int patientZero = 0; patientZero < N; patientZero++){
			for(int k = 0; k <= T; k++){
				Arrays.fill(handshakeCount, 0); // set every cow to 0
				handshakeCount[patientZero] = k;

				for(Event event : events){
					int cow = event.cow - 1; // index is one less than number of cow
					int time = event.time;
					char state = event.state;

					if (handshakeCount[cow] >= 0) {
                        if (handshakeCount[cow] == k) {
                            handshakeCount[cow]++;
                        }
						if(handshakeCount[cow] <= T && infected[cow]){
							if(state == '1'){
								if(handshakeCount[cow] + 1 <= time) {
                                    handshakeCount[cow]++;
                                    infected[cow] = true;
								} else {
									if(handshakeCount[cow] + 1 == time) {
										handshakeCount[cow]++;
										infected[cow] = false;
									}
								}
							}
						}
					}
				}
			}
		

			boolean possible = true;
			int minInfections = Integer.MAX_VALUE;
			int maxInfections = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				if (infected[i]) {
					minInfections = Math.min(minInfections, handshakeCount[i]);
					maxInfections = Math.max(maxInfections, handshakeCount[i]);
				} else if (handshakeCount[i] > 0) {
					possible = false;
					break;
				}
			}

			if (possible) {
				if (minInfections == maxInfections) {
					io.println(patientZero + 1 + " " + minInfections + " " + "1");
				} else {
					io.println(patientZero + 1 + " " + minInfections + " " + maxInfections);
				}
			}
		}











		// int cows = io.nextInt(); // num of cows
		// int lines = io.nextInt(); // num of interactions
		// String health = io.next(); // info about health of all the cows, String of length N

		// int[] time = new int[lines];
		// int[] c1 = new int[lines];
		// int[] c2 = new int[lines];

		// for(int i = 0; i < lines; i++){
		// 	time[i] = io.nextInt();
		// 	c1[i] = io.nextInt();
		// 	c2[i] = io.nextInt();
		// }


		// HashSet<Integer> infected = new HashSet<>();
		// for(int i = 0; i < cows; i++){
		// 	if(health.charAt(i) == '1'){
		// 		infected.add(i+1);
		// 	}
		// }
		

		// HashSet<Integer> patientZero = new HashSet<>();
		// HashSet<Integer> check = new HashSet<>();
		// for(int i = 0; i < cows; i++){
		// 	if(health.charAt(i) == '1'){
		// 		check.add(i+1);
		// 		for(int j = 0; j < lines; j++){
		// 			if(c1[i] == i+1 || c2[i] == i+1){
		// 				check.add(c1[i]);
		// 				check.add(c2[i]);
		// 			}
		// 		}
		// 	}
			
		// 	if(check.containsAll(infected)){
		// 		patientZero.add(i+1);
		// 	}
		// 	check.clear();
		// }







		// io.println(patientZero.size()); // x
		
		// int y = Integer.MAX_VALUE;
		// int z = Integer.MIN_VALUE;









        io.close();

    }

}