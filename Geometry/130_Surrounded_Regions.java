/*
* a dfs search solution 
*/
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
		        return;
	      if (board.length < 2 || board[0].length < 2)
		        return;
        
        // dfs search starts from border
        for (int r=0; r<board.length; r++) {
            if (board[r][0]=='O') dfs(board, r, 0);
            if (board[r][board[0].length-1]=='O') dfs(board, r, board[0].length-1);
        }
        for (int c=0; c<board[0].length; c++) {
            if (board[0][c]=='O') dfs(board, 0, c);
            if (board[board.length-1][c]=='O') dfs(board, board.length-1, c);
        }
        
        // flip the unconnected Os and release the marker back to O
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                if (board[r][c]=='O')
                    board[r][c] = 'X';
                else if (board[r][c]=='#')
                    board[r][c] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col<0 || col > board[0].length - 1)
		    return;
        board[row][col] = '#'; //connected Os are marked with #
        if (row>1 && board[row-1][col]=='O') {
            dfs(board, row-1, col);
        }
        if (row<board.length-2 && board[row+1][col]=='O') {
            dfs(board, row+1, col);
        }
        if (col>1 && board[row][col-1]=='O') {
            dfs(board, row, col-1);
        }
        if (col<board[0].length-2 && board[row][col+1]=='O') {
            dfs(board, row, col+1);
        }
    }
}
