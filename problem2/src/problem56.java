// LeetCode题目链接: https://leetcode.cn/problems/word-search/
public class problem56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        char[][] array = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean exist = solution56.exist(array, word);
        System.out.println(exist);

    }
}


class Solution56 {
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (traceback(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean traceback(char[][] board, String word, int index, int r, int c) {
        int n =  board.length;
        int m = board[0].length;

        if (r >=n || c >= m) {
            return false;
        }

        if (r < 0 || c < 0) {
            return false;
        }

        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        if (index == word.length()-1) {
            return true;
        }

        char temp = board[r][c];
        board[r][c] = '1';

        boolean found = traceback(board, word, index+1, r-1, c)
                        || traceback(board, word, index+1, r, c-1)
                        || traceback(board, word, index+1, r, c+1)
                        || traceback(board, word, index+1, r+1, c);

        //回溯
        board[r][c] = temp;
        return found;
    }
}
