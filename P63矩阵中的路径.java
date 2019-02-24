public class P63矩阵中的路径 {


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str == null || matrix == null) {
            return false;
        }
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars[i][j] = matrix[i * cols + j];
            }
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (process(chars, i, j, str, 0)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean process(char[][] matrix, int i, int j, char[] str, int cur) {
        if (cur == str.length) {
            return true;
        }
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        }
        if (matrix[i][j] == str[cur]) {
            char ch = matrix[i][j];
            matrix[i][j] = '*';
            boolean flag = process(matrix, i - 1, j, str, cur + 1) || process(matrix, i, j - 1, str, cur + 1) ||
                    process(matrix, i + 1, j, str, cur + 1) || process(matrix, i, j + 1, str, cur + 1);
            matrix[i][j] = ch;
            return flag;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
        System.out.println(hasPath(chars, 3, 4, "abcb".toCharArray()));
    }

}
