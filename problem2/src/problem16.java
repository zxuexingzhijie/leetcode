import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class problem16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution16.rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}


class Solution16 {
    public void rotate(int[][] matrix) {
        // 1. 转置：交换 matrix[i][j] 和 matrix[j][i]（只交换上三角或下三角，避免重复）
        for(int i = 0;i<matrix.length;i++){
            for(int j = i+1;j< matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //每一行反转(左右对换)
        for (int i =0;i< matrix.length;i++){
            //这边涉及到的用法跟13题之前的pr类似，请注意
            List<Integer> list1 = Arrays.stream(matrix[i]).boxed().toList();
            ArrayList<Integer> list = new ArrayList<>(list1);
            Collections.reverse(list);
            int[] array = list.stream().mapToInt(Integer::intValue).toArray();
            matrix[i] = array;
        }
    }
}