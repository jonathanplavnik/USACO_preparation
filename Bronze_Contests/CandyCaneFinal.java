package Bronze_Contests;

import java.util.*;
import java.io.*;
// public class CandyCaneFinal {
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
// 		PrintWriter pw = new PrintWriter(System.out);

// 		StringTokenizer st = new StringTokenizer(r.readLine());

//         int N = Integer.parseInt(st.nextToken()); // num cows
//         int M = Integer.parseInt(st.nextToken()); // num candy canes

//         int[] cows = new int[N];
//         for(int i = 0; i < cows.length; i++){
//             cows[i] = Integer.parseInt(st.nextToken());
//         }
//         // int[] canes = new int[M];
//         // st = new StringTokenizer(r.readLine());
//         // for(int i = 0; i < canes.length; i++){
//         //     canes[i] = Integer.parseInt(st.nextToken());
//         // }

//         st = new StringTokenizer(r.readLine());
//         for(int i = 0; i < M; i++){
//             int cane = Integer.parseInt(st.nextToken());
//             int eaten = 0;

//             for(int j = 0; j < cows.length; j++){
//                 int eat = Math.min(cows[j], cane);
//                 if(eat <= eaten){
//                     continue;
//                 } else {
//                     cows[j] += eat - eaten;
//                     eaten = Math.max(eat, eaten);
//                 }
//             }
//         }

//         for(int i : cows){
//             pw.println(i);
//         }
        
//         pw.close();
//         r.close();
//     }
// }


public class CandyCaneFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] cows = new int[N];
        int[] canes = new int[M];

        for (int i = 0; i < N; i++) {
            cows[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            canes[i] = scanner.nextInt();
        }

        int b = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (cows[j] > b) {
                    int x = Math.min(cows[j] - b, canes[i]);

                    cows[j] += x;
                    canes[i] -= x;
                    b += x;

                    if (canes[i] <= 0) {
                        break;
                    }
                }
            }
            b = 0;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(cows[i]);
        }
        scanner.close();
    }

}
