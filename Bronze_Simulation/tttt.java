import java.util.*;
import java.io.*;
public class tttt {
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
//     public static void main(String[] args) throws IOException {
//         Kattio io = new Kattio();
//         // Kattio io = new Kattio("tttt");

//         String[] row1 = io.next().split("");
//         String[] row2 = io.next().split("");
//         String[] row3 = io.next().split("");

//         /*io.println(Arrays.toString(row1));
//         io.println(Arrays.toString(row2));
//         io.println(Arrays.toString(row3));
//         */

//         int out1 = 0;

//         //first ouput, num of indiv cows who can claim victory
//         if(row1[0].equals(row1[1]) && row1[1].equals(row1[2])) out1++;
//         if(row2[0].equals(row2[1]) && row2[1].equals(row2[2])) out1++;
//         if(row3[0].equals(row3[1]) && row3[1].equals(row3[2])) out1++;

//         if(row1[0].equals(row2[0]) && row2[0].equals(row3[0])) out1++;
//         if(row1[1].equals(row2[1]) && row2[1].equals(row3[1])) out1++;
//         if(row1[2].equals(row2[2]) && row2[2].equals(row3[2])) out1++;

//         if(row1[0].equals(row2[1]) && row2[1].equals(row3[2])) out1++;
//         if(row1[2].equals(row2[1]) && row2[1].equals(row3[0])) out1++;


//         int out2 = 0;

//         //second output
//         if(row1[0].equals(row1[1]) && ! row1[1].equals(row1[2])) out2++;
//         if(!row1[0].equals(row1[1]) && row1[1].equals(row1[2])) out2++;
//         if(row1[0].equals(row1[2]) && ! row1[1].equals(row1[2])) out2++;

//         if(row2[0].equals(row2[1]) && ! row2[1].equals(row2[2])) out2++;
//         if(! row2[0].equals(row2[1]) && row2[1].equals(row2[2])) out2++;
//         if(row2[0].equals(row2[2]) && ! row2[1].equals(row2[2])) out2++;

//         if(row3[0].equals(row3[1]) && ! row3[1].equals(row3[2])) out2++;
//         if(!row3[0].equals(row3[1]) && row3[1].equals(row3[2])) out2++;
//         if(row3[0].equals(row3[2]) && ! row3[1].equals(row3[2])) out2++;

//         if(row1[0].equals(row2[0]) && !row2[0].equals(row3[0])) out2++;
//         if(!row1[0].equals(row2[0]) && row2[0].equals(row3[0])) out1++;
//         if(row1[0].equals(row3[0]) && !row2[0].equals(row3[0])) out2++;

//         if(row1[1].equals(row2[1]) && ! row2[1].equals(row3[1])) out2++;
//         if(!row1[1].equals(row2[1]) && row2[1].equals(row3[1])) out2++;
//         if(row1[1].equals(row3[1]) && ! row2[1].equals(row3[1])) out2++;

//         if(row1[2].equals(row2[2]) && ! row2[2].equals(row3[2])) out2++;
//         if(! row1[2].equals(row2[2]) && row2[2].equals(row3[2])) out2++;
//         if(row1[2].equals(row3[2]) && ! row2[2].equals(row3[2])) out2++;

//         if(row1[0].equals(row2[1]) && !row2[1].equals(row3[2])) out2++;
//         if(!row1[0].equals(row2[1]) && row2[1].equals(row3[2])) out2++;
//         if(row1[0].equals(row3[2]) && !row2[1].equals(row3[2])) out2++;

//         if(row1[2].equals(row2[1]) && ! row2[1].equals(row3[0])) out2++;
//         if(!row1[2].equals(row2[1]) && row2[1].equals(row3[0])) out2++;
//         if(row1[2].equals(row3[0]) && ! row2[1].equals(row3[0])) out2++;


//         if(out1 == 8) out1 = 1;
//         io.println(out1);
//         io.println(out2);
//         io.close();

//     }
// }
    static HashSet<Character> individual = new HashSet<Character>();
    static HashSet<HashSet<Character>> duo = new HashSet<HashSet<Character>>();


    static void checkForWin(char a, char b, char c) {
        if(a == b && b == c) individual.add(a);
        else if (a == b || b == c || a == c) duo.add(new HashSet<>(Arrays.asList(a, b, c)));
    }
    public static void main(String[] args) throws IOException {
        // Kattio io = new Kattio();
        Kattio io = new Kattio("tttt");

        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            String input = io.next();
            for(int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for(char[] row : board) checkForWin(row[0], row[1], row[2]); // checks rows
        checkForWin(board[0][0], board[1][0], board[2][0]); // Column 1
        checkForWin(board[0][1], board[1][1], board[2][1]); // Column 2
        checkForWin(board[0][2], board[1][2], board[2][2]); // Column 3
        checkForWin(board[0][0], board[1][1], board[2][2]); // diagonal x= -y
        checkForWin(board[0][2], board[1][1], board[2][0]); // diagonal x=y

        io.println(individual.size());
        io.println(duo.size());
        
        io.close();

    }
}