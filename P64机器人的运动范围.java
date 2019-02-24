public class P64机器人的运动范围 {
    static int count = 0;

    public static int movingCount(int threshold, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        process(threshold, matrix, 0, 0);
        return count;
    }

    private static void process(int threshold, int[][] matrix, int i, int j) {
        if (i == matrix.length || j == matrix[0].length || matrix[i][j] == 1) {
            return;
        }
        int sum = 0;
        int curi = i;
        int curj = j;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        if (sum <= threshold) {
            count++;
            matrix[curi][curj] = 1;
            process(threshold, matrix, curi + 1, curj);
            process(threshold, matrix, curi, curj + 1);
        } else {
            return;
        }

    }

    public static void main(String[] args) {
        System.out.println(movingCount(10, 1, 100));
    }
}
