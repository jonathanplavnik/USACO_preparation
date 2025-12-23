package Bronze_Recursion;
import java.util.*;
import java.io.*;

public class twentyfour {
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

    static int maxValue = -1;

    static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = applyOperator(token, num1, num2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    static int applyOperator(String operator, int num1, int num2) {
        if (operator.equals("+")) return num1 + num2;
        if (operator.equals("-")) return num1 - num2;
        if (operator.equals("*")) return num1 * num2;
        if (operator.equals("/")) return num1 / num2;
        return 0;
    }

    static boolean isValid(int value) {
        return value > 0 && value <= 24 && value == (int) value;
    }

    static void generateExpressions(List<Integer> permutation, List<String> operators) {
        if (operators.size() == 3) {
            String expression = "";
            for (int i = 0; i < 3; i++) {
                expression += permutation.get(i) + " " + operators.get(i) + " ";
            }
            expression += permutation.get(3);
            
            int result = evaluateExpression(expression);
            if (isValid(result)) {
                maxValue = Math.max(maxValue, result);
            }
            return;
        }

        for (String operator : Arrays.asList("+", "-", "*", "/")) {
            operators.add(operator);
            generateExpressions(permutation, operators);
            operators.remove(operators.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("");

        int N = io.nextInt();
        List<Integer> cards = new ArrayList<>();
        
        for(int j = 0; j < N; j++){
            for (int i = 0; i < 4; i++) {
                cards.add(io.nextInt());
            }
            List<Integer> permutation = new ArrayList<>(cards);
            List<String> operators = new ArrayList<>();
            generateExpressions(permutation, operators);
            System.out.println(maxValue);
        }

        io.close();
    }
}