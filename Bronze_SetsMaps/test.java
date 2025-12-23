package Bronze_SetsMaps;
import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        
        int n = in.nextInt();
        System.out.println(mod12(n));
    }
    static int mod12(int i){
        if(i < 0){
            return (i + 12 * 10000) % 12;
        } else {
            return i % 12;
        }
    }
}
