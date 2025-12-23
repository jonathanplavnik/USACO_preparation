import java.util.*;
import java.io.*;

public class Mainish {
    static int x;
    static int y;
    static int cash;
    static int[][] field;
    static int R;
    static int C;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        R = in.nextInt();
        C = in.nextInt();

        field = new int[R][C];

        for(int i = 0; i < R; i++){
            String str = in.next();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(i) == '*') field[i][j] = -1;
                if(str.charAt(i) == 'S') field[i][j] = 1;
                if(str.charAt(i) == 'M') field[i][j] = 5;
                if(str.charAt(i) == 'L') field[i][j] = 10;
            }
        }

        //farmer starting position
        x = in.nextInt();
        y = in.nextInt();

        cash = field[x][y];
        field[x][y] = 0;
        

        while(down()) down();
        for(int i = 0; i < R; i++){
            while(left()){
                left();
            } 
            while(right()){
                right();
            } 
            up();
        }

        

    
        
        
        System.out.println(cash);
        in.close();
    }
    static boolean up(){
        if(x > 0 && field[x-1][y] != -1){
            cash += field[x-1][y]; 
            field[x-1][y] = 0; 
            x -= 1; 
            return true;
        }
        return false;
    }
    static boolean down(){ 
        if(x < C-1 && field[x+1][y] != -1){
            cash += field[x+1][y]; 
            field[x+1][y] = 0; 
            x += 1; 
            return true;
        } 
        return false;
    }
    static boolean left(){
        if(y > 0 && field[x][y-1] != -1){
            cash += field[x][y-1]; 
            field[x][y-1] = 0; 
            y -= 1; 
            return true;
        } 
        return false;
    }
    static boolean right(){
        if(y < R-1 && field[x][y+1] != -1){
            cash += field[x][y+1]; 
            field[x][y+1] = 0; 
            y += 1; return true;
        } 
        return false;
    }
}
