package Matrix;

/**
 * Created by yizhao on 7/1/15.
 */
public class RotateImage {
    // from [1, 2, 3, 4] to [10, 11, 12, 1]
    // from [12, 13, 14, 5] to [9, 16, 13, 2]
    // from [11, 16, 15, 6] to [8, 15, 14, 3]
    // from [10, 9, 8, 7] to [7, 6, 5, 4]
    public static void rotateClockwise90(int[][] matrix) {
        int n = matrix.length;
        for (int L = 0, R = n - 1; L <= R; L++, R--) {
            for (int T = L, B = R; T < R; T++, B--) {
                int tmp = matrix[L][T];
                matrix[L][T] = matrix[B][L];
                matrix[B][L] = matrix[R][B];
                matrix[R][B] = matrix[T][R];
                matrix[T][R] = tmp;
            }
        }
    }

    // from [1, 2, 3, 4] to [4, 5, 6, 7]
    // from [12, 13, 14, 5] to [3, 14, 15, 8]
    // from [11, 16, 15, 6] to [2, 13, 16, 9]
    // from [10, 9, 8, 7] to [1, 12, 11, 10]
    public static void rotateCounterClockwise90(int[][] matrix) {
        int n = matrix.length;
        for (int L = 0, R = n - 1; L <= R; L++, R--) {
            for (int T = L, B = R; T < R; T++, B--) {
                int tmp = matrix[L][T];
                matrix[L][T] = matrix[T][R];
                matrix[T][R] = matrix[R][B];
                matrix[R][B] = matrix[B][L];
                matrix[B][L] = tmp;
            }
        }
    }
}
