// LeetCode题目链接: https://leetcode.cn/problems/number-of-islands/
public class problem47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        char[][] grid = {
            {1,1,1,1,0},
            {1,1,0,1,0},
            {1,1,0,0,0},
            {0,0,0,0,0}
        };
        int i = solution47.numIslands(grid);
        System.out.println(i);
    }
}

class Solution47 {

    private int count = 0;

    public int numIslands(char[][] grid) {
        int length = grid.length;
        int numslength = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < numslength; j++) {
                if (grid[i][j] == 1){
                    count++;
                    dfs(grid,i,j,length,numslength);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int length, int numslength) {

        if (i<0 || i>=length || j<0 || j>=numslength || grid[i][j] != 1){
            return;
        }

        grid[i][j] = 2;

        dfs(grid,i+1,j,length,numslength);
        dfs(grid,i-1,j,length,numslength);
        dfs(grid,i,j+1,length,numslength);
        dfs(grid,i,j-1,length,numslength);
    }
}
