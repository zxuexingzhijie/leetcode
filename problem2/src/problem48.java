import java.util.LinkedList;

public class problem48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int i = solution48.orangesRotting(grid);
        System.out.println(i);
    }
}


class Solution48 {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        LinkedList<int[]> rew = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1){
                    fresh++;
                }else if (grid[i][j] == 2){
                    rew.add(new int[]{i, j});
                }
            }
        }

        int round = 0;

        while (fresh >0 && !rew.isEmpty()){
            round++;
            int size = rew.size();
            for (int i = 0; i < size; i++) {
                int[] nums = rew.poll();
                int row = nums[0];
                int col = nums[1];
                if (row - 1>=0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    fresh--;
                    rew.add(new int[]{row-1, col});
                }

                if (row + 1 < M && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    fresh--;
                    rew.add(new int[]{row+1, col});
                }

                if (col - 1>=0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    fresh--;
                    rew.add(new int[]{row, col-1});
                }

                if (col + 1 < N && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    fresh--;
                    rew.add(new int[]{row, col+1});
                }

            }
        }

        if (fresh > 0){
            return -1;
        }else  {
            return round;
        }
    }
}