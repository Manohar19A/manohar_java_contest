import java.util.Map;
import java.util.HashMap;

public class PascalTriangle {
  

    public static void printPascalTriangle(int numRows) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j < numRows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(getPascalValue(i, j) + " ");
            }
            System.out.println();
        }
    }   
    public static int getPascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } 
        String key = row + "," + col;
        if (cache.containsKey(key)) 
        {
            return cache.get(key);
        }
        else {
            return getPascalValue(row - 1, col - 1) + getPascalValue(row - 1, col);
        }
    }   
    private static Map<String, Integer> cache = new HashMap<>();
     public static void main(String[] args) {
        int numRows = 5;
        printPascalTriangle(numRows);
        // commented code is for iteration to generate pascal
        // for (int i = 0; i < numRows; i++) {
        //     for (int j = 1; j < numRows- i; j++) {
        //         System.out.print(" ");
        //     }
        //     int num = 1;
        //     for (int k = 0; k <= i; k++) {
        //         System.out.print(num + " ");
        //         num = num * (i - k) / (k + 1);
        //     }
        //     System.out.println();
        // }
    }
}