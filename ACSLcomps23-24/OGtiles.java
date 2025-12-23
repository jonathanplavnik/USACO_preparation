import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    private static List<Integer> rows;
    private static List<Integer> hand;
    private static List<Integer> draw;
    /*
     * Complete the 'findHandSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER originalRows
     *  2. STRING handTiles
     *  3. STRING drawPile
     */

    public static int findHandSum(int originalRows, String handTiles, String drawPile) {
        rows = new ArrayList<>();
        hand = new ArrayList<>();
        draw = new ArrayList<>();
        
        String originalRowsStr = String.format("%04d", originalRows);
        for (int i = 0; i < 4; i++) {
            rows.add(Character.getNumericValue(originalRowsStr.charAt(i)));
        }
        for (String tile : handTiles.split(" ")) {
            hand.add(Integer.parseInt(tile));
        }
        for (String tile : drawPile.split(" ")) {
            draw.add(Integer.parseInt(tile));
        }
        
        while(!hand.isEmpty()) {
        boolean tilePlaced = false;
        for (int i = 0; i < hand.size(); i++) {
            // Convert single-digit tiles to two digits by adding a leading zero
            int tile = hand.get(i);
            String tileStr = String.format("%02d", tile); // Ensure the tile is two digits

            for (int j = 0; j < 4; j++) {
                int rowValue = rows.get(j);
                if (canPlace(tileStr, rowValue)) {

                    tileStr = rotateTileIfNecessary(tileStr, rowValue);
                    rows.set(j, Integer.parseInt(tileStr.substring(1))); 
                    hand.remove(i);
                    tilePlaced = true;
                    break;
                }
            }
            if (tilePlaced) {
                break;
            }
        }

        if (!tilePlaced) {
            if (!draw.isEmpty()) {
                // When drawing, convert the drawn tile to two digits as well
                int drawnTile = draw.remove(0);
                String drawnTileStr = String.format("%02d", drawnTile);
                hand.add(Integer.parseInt(drawnTileStr));
            } else {
                break;
            }
        }
    } 
        System.out.println(hand);
        int sum = 0;
        for(int i = 0; i < hand.size(); i++){
            sum += hand.get(i) % 10;
            sum += hand.get(i) / 10;
        }
        return sum;

    }
    private static boolean canPlace(String tileStr, int rowValue) {
        return tileStr.startsWith(String.valueOf(rowValue)) || 
            tileStr.endsWith(String.valueOf(rowValue));
    }

    private static String rotateTileIfNecessary(String tileStr, int rowValue) {
        if (tileStr.endsWith(String.valueOf(rowValue))) {
            return tileStr.charAt(1) + tileStr.substring(0, 1);
        }
        return tileStr;
        }
} 
public class OGtiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int originalRows = Integer.parseInt(bufferedReader.readLine().trim());

        String handTiles = bufferedReader.readLine();

        String drawPile = bufferedReader.readLine();

        int result = Result.findHandSum(originalRows, handTiles, drawPile);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
