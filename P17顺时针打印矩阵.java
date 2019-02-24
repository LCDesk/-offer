import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

public class P17顺时针打印矩阵 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        process(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, list);
        return list;
    }

    private static void process(int[][] matrix, int lx, int ly, int rx, int ry, ArrayList<Integer> list) {
        if (lx <= rx && ly <= ry) {
            int x = lx;
            int y = ly;
            if (lx == rx) {
                while (y <= ry) {
                    list.add(matrix[x][y++]);
                }
            } else if (ly == ry) {
                while (x <= rx) {
                    list.add(matrix[x++][y]);
                }
            } else {
                while (y < ry) {
                    list.add(matrix[x][y++]);
                }
                while (x < rx) {
                    list.add(matrix[x++][y]);
                }
                while (y > ly) {
                    list.add(matrix[x][y--]);
                }
                while (x > lx) {
                    list.add(matrix[x--][y]);
                }
                process(matrix, lx + 1, ly + 1, rx - 1, ry - 1, list);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1}};
        System.out.println(printMatrix(arr));
    }
}
