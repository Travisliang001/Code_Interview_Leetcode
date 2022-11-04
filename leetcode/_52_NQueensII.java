class Solution {
    public int totalNQueens(int n) {
        boolean [][] board = new boolean[n][n];
        return queens(board, 0);
    }
    
    public int queens(boolean [][] board, int row){
        /*
        base case:
        if find_solution(candidate):
            output(candidate)
            return
        */
        //base case
        if(row == board.length){
            return 1;
        }
        
        int count = 0;
        //first row to check each column:
        //iterate all possible candidates
        //    for next_candidate in list_of_candidates:

        for(int col=0; col<board.length; col++){
            //for each cell, we need to check if they are safe to place
            //pruning step to remove the unnessary branch.
            //is_valid(next_candidate)
            if(isSafe(board, row, col)){
                //Try this partial candidate solution
                //place(next_candidate)
                board[row][col] = true;
                //given the candidate, explore furthur
                //backtrack(next_candidate)
                count += queens(board, row+1);
                //backtrack.
                board[row][col] = false;
            }
        }
        return count;
    }
    
    public boolean isSafe(boolean [][] board, int row, int col){
        //check whether at the same col has the queen
        for(int rowIndex=0; rowIndex<row; rowIndex++){
            if(board[rowIndex][col]){
                return false;
            }
        }
        
        //check whether diagonal left and until the row is at the same level.
        int offsetLeft = Math.min(row, col);
        for(int offset=1; offset<=offsetLeft; offset++){
            if(board[row-offset][col-offset]){
                return false;
            }
        }
        
        //check whether diagonal right and until the row is at the same level.
        //the row + 1 scenario will be handled by next iteration.
        int offsetRight = Math.min(row, board.length - 1 - col);
        for(int offset=1; offset<=offsetRight; offset++){
            if(board[row-offset][col+offset]){
                return false;
            }
        }
        
        return true;
    }
}
