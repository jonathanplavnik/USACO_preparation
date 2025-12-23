package Bronze_Complete_Search;
import java.util.*;
import java.io.*;
public class contaminatedMilk {
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
        // Kattio io = new Kattio();
		 Kattio io = new Kattio("badmilk");

		int friends = io.nextInt(); // num of friends
		int milks = io.nextInt(); // num of types of milk
		int lines = io.nextInt(); // num of lines
		int sick = io.nextInt(); // log of sick people

		int p;
		int m;
		int t;

		int[] people = new int[lines];
		int[] milk = new int[lines];
		int[] time = new int[lines];

		for(int i = 0; i < lines; i++){
			people[i] = io.nextInt();
			milk[i] = io.nextInt();
			time[i] = io.nextInt();
		}

		int[] sickPeople = new int[sick];
		int[] sickTime = new int[sick];
		for(int i = 0; i < sick; i++){
			sickPeople[i] = io.nextInt();
			sickTime[i] = io.nextInt();
		}



		int ans = 0;
		ArrayList<Integer> badMilk = new ArrayList<>();
		TreeMap<Integer, Integer> finalMilk = new TreeMap<>();

		for(int i = 0; i < sick; i++){
			badMilk = possibilities(people, milk, time, lines, sickPeople[i], sickTime[i]);
			for(int j = 0; j < badMilk.size(); j++){
				if(finalMilk.containsKey(badMilk.get(j))){
					finalMilk.put(badMilk.get(j), finalMilk.get(badMilk.get(j)) + 1);
				} else {
					finalMilk.put(badMilk.get(j), 0);
				}
			}
		}
		
		
		ArrayList<Integer> milkList = new ArrayList<>();
		for(int i : finalMilk.keySet()){
			if(finalMilk.get(i) == sick - 1){
				milkList.add(i);
			}
		}
		



		for(int i = 0; i < sick; i++){
			HashSet<Integer> illPeople = new HashSet<Integer>();
			for(int j = 0; j < milkList.size(); j++){
				for(int k = 0; k < lines; k++){
					if(milk[k] == milkList.get(j)) illPeople.add(people[k]);
				}
			}
			ans = Math.max(ans, illPeople.size());
			illPeople.clear();
		}

		io.println(ans);
        io.close();

    }

	public static ArrayList<Integer> possibilities(int[] people, int[] milk, int[] time, int lines, int sickPeople, int sickTime){
		ArrayList<Integer> list = new ArrayList<>();
		for(int l = 0; l < lines; l++){
			if(people[l] == sickPeople && time[l] < sickTime && !list.contains(milk[l])) list.add(milk[l]);
		}
		return list;
	}
}