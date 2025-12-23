import java.io.*;
import java.util.*;



// class Result {
//     private static List<Integer> rows;
//     private static List<Integer> hand;
//     private static List<Integer> draw;
//     private static int lastPlacedRow = -1; // Track the last placed row index
//     private static boolean lastWasDouble = false;
//     /*
//      * Complete the 'findHandSum' function below.
//      *
//      * The function is expected to return an INTEGER.
//      * The function accepts following parameters:
//      *  1. INTEGER originalRows
//      *  2. STRING handTiles
//      *  3. STRING drawPile
//      */

//     public static int findHandSum(int originalRows, String handTiles, String drawPile) {
//         rows = new ArrayList<>();
//         hand = new ArrayList<>();
//         draw = new ArrayList<>();
        
//         String originalRowsStr = String.format("%04d", originalRows);
//         for (int i = 0; i < 4; i++) {
//             rows.add(Character.getNumericValue(originalRowsStr.charAt(i)));
//         }
//         for (String tile : handTiles.split(" ")) {
//             hand.add(Integer.parseInt(tile));
//         }
//         for (String tile : drawPile.split(" ")) {
//             draw.add(Integer.parseInt(tile));
//         }
        
//         while (!hand.isEmpty()) {
//             boolean tilePlaced = false;
//             for (int i = 0; i < hand.size(); i++) {
//                 String tileStr = String.format("%02d", hand.get(i));
//                 // Debug print
//                 System.out.println("Current hand: " + hand);
//                 System.out.println("Current rows: " + rows);
//                 System.out.println("Trying to place tile: " + tileStr);

//                 for (int j = 0; j < 4; j++) {
//                     int rowIndex = lastWasDouble ? lastPlacedRow : j;
//                     int rowValue = rows.get(rowIndex);

//                     if (canPlace(tileStr, rowValue)) {
//                         // Debug print
//                         System.out.println("Placing tile " + tileStr + " at row " + (rowIndex + 1));

//                         tileStr = rotateTileIfNecessary(tileStr, rowValue);
//                         rows.set(rowIndex, Integer.parseInt(tileStr.substring(1)));
//                         hand.remove(i);
//                         tilePlaced = true;
//                         lastWasDouble = (tileStr.charAt(0) == tileStr.charAt(1));
//                         lastPlacedRow = rowIndex;

//                         // Debug print
//                         System.out.println("Tile after rotation if necessary: " + tileStr);
//                         System.out.println("Tile placed, breaking out to next iteration.");
//                         break;
//                     }

//                     if (lastWasDouble) {
//                         // Only attempt to place in the same row if the last tile was a double
//                         break;
//                     }
//                 }
//                 if (tilePlaced) {
//                     break;
//                 }
//             }

//             if (!tilePlaced) {
//                 if (!draw.isEmpty()) {
//                     int drawnTile = draw.remove(0);
//                     hand.add(Integer.parseInt(String.format("%02d", drawnTile)));
//                     // Debug print
//                     System.out.println("Drawing tile: " + String.format("%02d", drawnTile));
//                 } else {
//                     // Debug print
//                     System.out.println("Cannot place or draw, game over");
//                     break;
//                 }
//             }
//         }

//         // Sum calculation code ...
//         int sum = 0;
//         for (int tile : hand) {
//             sum += tile % 10;
//             sum += tile / 10;
//         }

//         // Debug print
//         System.out.println("Final hand: " + hand);
//         System.out.println("Final sum: " + sum);

//         return sum;
//     }

//     private static boolean canPlace(String tileStr, int rowValue) {
//         return tileStr.endsWith(String.valueOf(rowValue));
//     }

//     private static String rotateTileIfNecessary(String tileStr, int rowValue) {
//         if (tileStr.charAt(1) == '0' && tileStr.charAt(0) == Character.forDigit(rowValue, 10)) {
//             return tileStr.charAt(1) + "" + tileStr.charAt(0);
//         }
//         return tileStr;
//     }
// }
class Result1 {
    private static List<Integer> rows;
    private static List<Integer> hand;
    private static List<Integer> draw;
    private static boolean lastWasDouble = false;
    private static int doubleRow = -1;

    public static int findHandSum(int originalRows, String handTiles, String drawPile) {
        rows = new ArrayList<>();
        hand = new ArrayList<>();
        draw = new ArrayList<>();
        
        // Initialize rows
        String originalRowsStr = String.format("%04d", originalRows);
        for (int i = 0; i < 4; i++) {
            rows.add(Character.getNumericValue(originalRowsStr.charAt(i)));
            System.out.println("Row " + (i + 1) + ": " + rows.get(i));
        }

        // Initialize hand
        for (String tile : handTiles.split(" ")) {
            hand.add(Integer.parseInt(tile));
        }

        // Initialize draw pile
        for (String tile : drawPile.split(" ")) {
            draw.add(Integer.parseInt(tile));
        }

        System.out.println(rows);
        System.out.println(hand);
        System.out.println(draw);

        while (!hand.isEmpty()) {
        boolean tilePlaced = false;
        for (int i = 0; i < hand.size(); i++) {
            int tile = hand.get(i);
            String tileStr = String.format("%02d", tile);

            System.out.println("Trying to place tile: " + tileStr);

            for (int j = 0; j < 4; j++) {
                if (lastWasDouble && j != doubleRow) {
                    System.out.println("Skipping row " + (j + 1) + " due to double tile rule");
                    continue;
                }

                int rowValue = rows.get(j);
                System.out.println("Checking row " + (j + 1) + " with end value " + rowValue);

                if (canPlace(tileStr, rowValue)) {
                    tileStr = rotateTileIfNecessary(tileStr, rowValue);
                    rows.set(j, Integer.parseInt(tileStr.substring(1)));
                    hand.remove(i);
                    tilePlaced = true;

                    System.out.println("Placed tile " + tileStr + " in row " + (j + 1));

                    if (tileStr.charAt(0) == tileStr.charAt(1)) {
                        lastWasDouble = true;
                        doubleRow = j;
                        System.out.println("Double tile placed, next tile must go in row " + (j + 1));
                    } else {
                        lastWasDouble = false;
                    }

                    break;
                }
            }

            if (tilePlaced) {
                break;
            }
        }

        if (!tilePlaced) {
            if (!draw.isEmpty()) {
                String s = String.format("%02d", hand.get(hand.size()-1));
                int drawnTile = 0;
                while(!canPlace(s, rows.get(0)) || !canPlace(s, rows.get(1)) || !canPlace(s, rows.get(2)) || !canPlace(s, rows.get(3))){
                    if(draw.isEmpty()) break;
                    drawnTile = draw.remove(0);
                    hand.add(drawnTile);
                    s = String.format("%02d", drawnTile);
                    
                }
                System.out.println("Drew tile: " + drawnTile);
                
            } else {
                System.out.println("No more moves can be made. Game over.");
                break;
            }
        }
    }

        // Calculate sum of remaining tiles in hand
        int sum = 0;
        for (int tile : hand) {
            sum += tile % 10;
            sum += tile / 10;
            System.out.println("Summing tile: " + tile);
        }

        System.out.println("Final hand: " + hand);
        System.out.println("Final sum: " + sum);
        return sum;
    }

    private static boolean canPlace(String tileStr, int rowValue) {
        return tileStr.charAt(0) == Character.forDigit(rowValue, 10) || tileStr.charAt(1) == Character.forDigit(rowValue, 10);
    }

    private static String rotateTileIfNecessary(String tileStr, int rowValue) {
        if (Character.getNumericValue(tileStr.charAt(0)) == rowValue) {
            return tileStr;
        }
        return (new StringBuilder(tileStr).reverse().toString());
    }
}
public class Solution1 {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int originalRows = Integer.parseInt(bufferedReader.readLine().trim());

        // String handTiles = bufferedReader.readLine();

        // String drawPile = bufferedReader.readLine();

        // int result = Result.findHandSum(originalRows, handTiles, drawPile);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("solution-input.txt")));
        

        int originalRows = Integer.parseInt(br.readLine().trim());

        String handTiles = br.readLine();

        String drawPile = br.readLine();

        int result = Result1.findHandSum(originalRows, handTiles, drawPile);

        System.out.println(String.valueOf(result));

        br.close();
    }
}
