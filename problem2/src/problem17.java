public class problem17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = solution17.searchMatrix(matrix, target);
        System.out.println(result);
    }
}

class Solution17 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}