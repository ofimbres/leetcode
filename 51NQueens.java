/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 */

class Solution {

    /**
     * Approach 1. Backtracking
     * Time: O(N!), Space: O(N^2)
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = createBoard(n);
        List<List<String>> output = new ArrayList<>();
        backtrack(board, 0, n, output, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return output;
    }

    private void backtrack(char[][] board, int r, int n, List<List<String>> output, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags) {
        if (r == n) {
            output.add(cloneBoard(board, n)); // goal
            return;
        }

        for (int c = 0; c < n; ++c) {
            int diagonal = r - c;
            int antiDiagonal = r + c;
            // if the queen is not placeable
            if (cols.contains(c) || diags.contains(diagonal) || antiDiags.contains(antiDiagonal)) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(c);
            diags.add(diagonal);
            antiDiags.add(antiDiagonal);
            board[r][c] = 'Q';

            // Move on to the next row with the updated board state
            backtrack(board, r + 1, n, output, cols, diags, antiDiags);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(c);
            diags.remove(diagonal);
            antiDiags.remove(antiDiagonal);
            board[r][c] = '.';
        }
    }



    private char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        for (int r = 0; r < n; ++r)
            Arrays.fill(board[r], '.');
        return board;
    }

    private List<String> cloneBoard(char[][] board, int n) {
        List<String> result = new ArrayList<>();
        for (int r = 0; r < n; ++r) {
            result.add(new String(board[r]));
        }
        return result;
    }
}