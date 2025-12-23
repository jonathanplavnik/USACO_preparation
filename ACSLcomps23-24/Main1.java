import java.util.*;
import java.io.*;


public class Main1 {
    // public static void main(String[] args) throws IOException {
    //     // BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	// 	// PrintWriter pw = new PrintWriter(System.out);

	// 	// StringTokenizer st = new StringTokenizer(r.readLine());

	// 	// pw.close();


    //     Scanner in = new Scanner(System.in);

    //     String str1 = in.next();
    //     String str2 = in.next();
        
    //     char quiet = ' ';
    //     char silly = ' ';
    //     int sillyIndex = 0;

    //     char silly1 = ' ';
    //     char silly2 = ' ';
        
        


    //     if(str1.length() == str2.length()){
    //         for(int i = 0; i < str1.length(); i++){
    //             if(str1.charAt(i) != str2.charAt(i)){
    //                 silly = str1.charAt(i);
    //                 sillyIndex = i;
    //                 break;
    //             }
    //         }
    //         System.out.println(silly + " " + str2.charAt(sillyIndex));
    //         System.out.println('-');
    //     } else {
    //         HashSet<Character> missing = new HashSet<>(); // find what is the silly key being shown in the second string
            
    //         for(int i = 0; i < str1.length(); i++){
    //             missing.add(str1.charAt(i));
    //         }
    //         for(int i = 0; i < str2.length(); i++){
    //             if(!missing.contains(str2.charAt(i))){
    //                 silly2 = str2.charAt(i);
    //             }
    //         }
    //         for(int i = 0; i < str2.length(); i++){
    //             missing.remove(str2.charAt(i));
    //         }
    //         for(char a : missing){
    //             silly1 = a;
    //         }

    //         int index = 0;
    //         for(int i = 0; i < str2.length(); i++){
    //             if(str1.charAt(i) != str2.charAt(i)){
    //                 if(str2.charAt(i) == silly2){
    //                     silly1 = str1.charAt(i);

    //                 } else {
    //                     quiet = str1.charAt(i);
    //                 }
    //                 index = i;
    //                 break;
    //             }
    //         }


    //         boolean last = true; // in case the quiet is the last letter
    //         if(quiet == ' '){
    //             for(int i = index; i < str2.length(); i++){
    //                 if(str2.charAt(i) != str1.charAt(i) && str2.charAt(i) != silly2){
    //                     last = false;
    //                     quiet = str1.charAt(i);
    //                     break;
    //                 }
    //             }
    //             if(last) quiet = str1.charAt(str1.length()-1);
    //         }
    //         System.out.println(silly1 + " " + silly2);
    //         System.out.println(quiet);

    //         in.close();
    //     }
    // }
    public static void main(String[] args) throws IOException {
        // BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter pw = new PrintWriter(System.out);

		// StringTokenizer st = new StringTokenizer(r.readLine());

		// pw.close();


        Scanner in = new Scanner(System.in);

        String str1 = in.next();
        String str2 = in.next();
        
        char quiet = ' ';
        char silly = ' ';
        int sillyIndex = 0;
        char silly1 = ' ';
        char silly2 = ' '; 


        if(str1.length() == str2.length()){
            for(int i = 0; i < str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    silly = str1.charAt(i);
                    sillyIndex = i;
                    break;
                }
            }
            System.out.println(silly + " " + str2.charAt(sillyIndex));
            System.out.println('-');
        } else {
            HashSet<Character> missing = new HashSet<>(); // find what is the silly key being shown in the second string
            
            for(int i = 0; i < str1.length(); i++){
                missing.add(str1.charAt(i));
            }
            for(int i = 0; i < str2.length(); i++){
                if(!missing.contains(str2.charAt(i))){
                    silly2 = str2.charAt(i);
                }
            }
            for(int i = 0; i < str2.length(); i++){
                missing.remove(str2.charAt(i));
            }
            

            for(int i = 0; i < str2.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    if(str2.charAt(i) == silly2){
                        silly1 = str1.charAt(i);
                        missing.remove(silly1);
                        for(char a : missing){
                            quiet = a;
                        }

                    } else {
                        quiet = str1.charAt(i);
                        missing.remove(quiet);
                        for(char a : missing){
                            silly1 = a;
                        }

                    }
                    break;
                }
                
            }

            System.out.println(silly1 + " " + silly2);
            System.out.println(quiet);

            in.close();
        }
    }
}
