package algorithm.recursion;

public class _37_sodokuSolver {
    public void solveSudoku(char[][] board){
        solve(board, 0,0);
    }

    public boolean solve(char [][] board, int row, int col){
        //When recursive function call here, it will check if the col is out of bound.
        //reset if it is out of bound.
        if(col == board.length){
            col = 0;
            row++;
        }
        if(row == board.length){
            return true; // problem solved and return to the main function.
        }

        if(board[row][col] != '.')  return solve(board, row, col+1);

        for(char num='1'; num <= '9'; num++){
            if(isValid(board, row, col, num)){
                board[row][col] = num;
                //One step further towards the solution.
                boolean isSolved = solve(board, row, col+1);
                //since it is only one solution
                if(isSolved){
                    return true;
                } else{
                    board[row][col] = '.';
                }
            }
        }

        //after try out those 9 possibles, return false if there is no match.
        return false;
    }
    
    public boolean isValid(char [][] board, int row, int col, int value){
        //entire col and row check
        for(int idx=0; idx<board.length; idx++){
            if(value == board[row][idx] ) return false;
            if(value == board[idx][col]) return false;
        }

        int rowIdx = row/3;
        int colIdx = col/3;
        //check the whole square
        for(int i=rowIdx*3; i<(rowIdx+1)*3; i++){

            for(int j=colIdx*3; j<(colIdx+1)*3; j++){
                if(board[i][j] == value){
                    return false;
                }

            }
        }
        return true;
    }
}
