import java.io.*;
import java.util.Arrays;

public class Main {

    public static void saveGameField(int[][] field, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int[] row : field) {
                writer.println(Arrays.toString(row).replace(",", "")
                        .replace("[", "")
                        .replace("]", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] loadGameField(String filename) {
        int[][] field = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int rowIdx = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                if (field == null) {
                    field = new int[values.length][values.length];
                }
                for (int colIdx = 0; colIdx < values.length; colIdx++) {
                    field[rowIdx][colIdx] = Integer.parseInt(values[colIdx]);
                }
                rowIdx++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return field;
    }

    public static void printGameField(int[][] field) {
        char[] symbols = {'•', 'X', 'O', ' '};
        for (int[] row : field) {
            for (int num : row) {
                System.out.print(symbols[num] + " ");
            }
            System.out.println();
        }
    }

    // Пример использования функций
    public static void main(String[] args) {
        int[][] gameField = {
                {1, 0, 2},
                {2, 1, 0},
                {1, 2, 3}
        };

        saveGameField(gameField, "game_field.txt");

        int[][] loadedField = loadGameField("game_field.txt");

        System.out.println("Игровое поле:");
        printGameField(loadedField);
    }
}
