// LeetCode题目链接: https://leetcode.cn/problems/set-matrix-zeroes/
import java.util.HashSet;

public class problem14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        solution14.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}


class Solution14 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}