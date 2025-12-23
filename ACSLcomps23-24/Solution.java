// import java.io.*;
// import java.util.*;



// class Result {
//     private static List<Integer> rows;
//     private static List<Integer> hand;
//     private static List<Integer> draw;
//     private static boolean lastWasDouble = false;
//     private static int doubleRow = -1;
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
        
//         int currentRow = 0;
//         while(!hand.isEmpty()) {
//         boolean tilePlaced = false;
//         for (int i = 0; i < hand.size(); i++) {
//             int tile = hand.get(i);
//             String tileStr = String.format("%02d", tile); 

//             for (int j = currentRow; j < currentRow + 4; j++) {
//                     int rowIdx = j % 4;
//                     int rowValue = rows.get(rowIdx);
                    
//                     if (lastWasDouble && rowIdx != doubleRow) {
//                         continue;
//                     }

//                     if (canPlace(tileStr, rowValue)) {
//                         tileStr = rotateTileIfNecessary(tileStr, rowValue);
//                         rows.set(rowIdx, Integer.parseInt(tileStr.substring(1)));
//                         hand.remove(i);
//                         tilePlaced = true;

//                         if (tileStr.charAt(0) == tileStr.charAt(1)) {
//                             lastWasDouble = true;
//                             doubleRow = rowIdx;
//                         } else {
//                             lastWasDouble = false;
//                         }

//                         currentRow = (rowIdx + 1) % 4;
//                         break;
//                     }
//                 }
//             if (tilePlaced) {
//                 break;
//             }
//         }

//         if (!tilePlaced) {
//             while (!draw.isEmpty() && !tilePlaced) {
//                 int drawnTile = draw.remove(0);
//                 String drawnTileStr = String.format("%02d", drawnTile);
                
//                 for (int j = currentRow; j < currentRow + 4; j++) {
//                     int rowIdx = j % 4;
//                     int rowValue = rows.get(rowIdx);
                    
//                     if (lastWasDouble && rowIdx != doubleRow) {
//                         continue;
//                     }

//                     if (canPlace(drawnTileStr, rowValue)) {
//                         drawnTileStr = rotateTileIfNecessary(drawnTileStr, rowValue);
//                         rows.set(rowIdx, Integer.parseInt(drawnTileStr.substring(1)));
                        
//                         tilePlaced = true;
//                         if (drawnTileStr.charAt(0) == drawnTileStr.charAt(1)) {
//                             lastWasDouble = true;
//                             doubleRow = rowIdx;
//                         } else {
//                             lastWasDouble = false;
//                         }

//                         currentRow = (rowIdx + 1) % 4;
//                         break;
//                     }
//                 }

//                 if (!tilePlaced) {
//                     hand.add(Integer.parseInt(drawnTileStr));
//                 }
//             }
//             if (!tilePlaced && draw.isEmpty()) {
//                 break;
//             }
//         }
//     } 
//         System.out.println(hand);
//         int sum = 0;
//         for(int i = 0; i < hand.size(); i++){
//             sum += hand.get(i) % 10;
//             sum += hand.get(i) / 10;
//         }
//         return sum;

//     }
//     private static boolean canPlace(String tileStr, int rowValue) {
//         return tileStr.charAt(0) == Character.forDigit(rowValue, 10) || tileStr.charAt(1) == Character.forDigit(rowValue, 10);
//     }

//     private static String rotateTileIfNecessary(String tileStr, int rowValue) {
//         if (Character.getNumericValue(tileStr.charAt(0)) == rowValue) {
//             return tileStr;
//         }
//         return (new StringBuilder(tileStr).reverse().toString());
//     }
// }   
// public class Solution {
//     public static void main(String[] args) throws IOException {
//         // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         // int originalRows = Integer.parseInt(bufferedReader.readLine().trim());

//         // String handTiles = bufferedReader.readLine();

//         // String drawPile = bufferedReader.readLine();

//         // int result = Result.findHandSum(originalRows, handTiles, drawPile);

//         // bufferedWriter.write(String.valueOf(result));
//         // bufferedWriter.newLine();

//         // bufferedReader.close();
//         // bufferedWriter.close();
//         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("solution-input.txt")));
        

//         int originalRows = Integer.parseInt(br.readLine().trim());

//         String handTiles = br.readLine();

//         String drawPile = br.readLine();

//         int result = Result.findHandSum(originalRows, handTiles, drawPile);

//         System.out.println(String.valueOf(result));

//         br.close();
//     }
// }
