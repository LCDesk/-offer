public class P1二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        return process(target, array, 0, array[0].length - 1);
    }

    private boolean process(int target, int[][] array, int i, int j) {
        if (i >= array.length || j < 0) {
            return false;
        }
        if (array[i][j] > target) {
            return process(target, array, i, j - 1);
        } else if (array[i][j] < target) {
            return process(target, array, i + 1, j);
        } else {
            return true;
        }
    }
}
