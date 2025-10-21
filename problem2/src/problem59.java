public class problem59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean res = solution59.searchMatrix(matrix, target);
        System.out.println(res);
    }
}


class Solution59 {
    private int count = 0;

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (serachtarget(matrix[i],target) == Integer.MIN_VALUE){
                count++;
            }
        }
        return !(count == matrix.length);
    }

    private int serachtarget(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[mid]) {
                return mid;
            }else if (target > matrix[mid]) {
                left = mid + 1;
            }else  {
                right = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
}