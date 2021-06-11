public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = { 
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        rotateMatrix(matrix);
        printMatrix(matrix);
        rotateMatrix(matrix);
        printMatrix(matrix);
    }

    public static void rotateMatrix(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();
            row.append("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                row.append(matrix[i][j] + " ");
            }
            row.append("]");
            System.out.println(row.toString());
        }
    }
}
