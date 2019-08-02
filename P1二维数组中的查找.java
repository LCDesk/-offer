public class P1二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int index = 0;
        int jndex = array[0].length - 1;
        while (index < array.length && jndex >= 0) {
            if (target > array[index][jndex]) {
                index++;
            } else if (target < array[index][jndex]) {
                jndex--;
            } else {
                return true;
            }
        }

        return false;
    }
}
