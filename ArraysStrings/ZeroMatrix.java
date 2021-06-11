public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0},
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        zeroMatrix(matrix);
        printMatrix(matrix);
    }

    public static void zeroMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true; 
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i]) nullifyCol(matrix, i);
        }
    }

    public static int[][] nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
        return matrix;
    }

    public static int[][] nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        return matrix;
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
