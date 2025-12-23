import java.io.*;
import java.util.*;
public class problems3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int problems = in.nextInt();
        int q = in.nextInt();
        ArrayList<Integer> problemList = new ArrayList<Integer>();
        for(int i = 0; i < problems; i++){
            problemList.add(in.nextInt());
        }
        for(int i = 0; i < q; i++) {
            int type = in.nextInt();
            int diff = in.nextInt();
            if(type == 1) {
                for(int j = problemList.size()-1; j >= 0; j++) {
                    if(problemList.contains(diff) == false) System.out.println(-1);
                   if(problemList.get(i) > diff) {
                       System.out.print(problemList.get(i) + " ");
                       problemList.remove(i);
                   }
                }
            } else {
                for(int j = problemList.size() - 1; j >= 0; j++) {
                    if(problemList.get(j) <= diff) {
                        System.out.println(problemList.get(j));
                        problemList.remove(j);
                        break;
                    } else {
                        System.out.println(-1);
                    }
                }
            }
        }
        

        in.close();
    }
}