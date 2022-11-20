package algorithm.recursion;
/*
The time complexity should be O((MN)log4(3)) just as what @StefanPochmann points out. The recursive equation of this solution is T(n) = 3T(n/4) + O(1)
Then according to master method, any equation in form of T(n) = aT(n/b) + f(n) could fall into 3 case if it is solvable by master method. And T(n) = 3T(n/4) + O(1) matches exactly the 1st case, which is T(n)=Θ(n^logb(a)).

*/
public class _240_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        return helper (matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }
    
    public boolean helper(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd, int target){
        //base case to check whether they are out of bound.=>terminate the logic
        if(rowStart > rowEnd || colStart > colEnd){
            return false;
        }
        
        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;
        int centerVal = matrix[midRow][midCol];
        //1. calculate shadow area 
        /*
            ****|****  (the second quarter is redandunt.)
            ****|****
            ----|----
            ****|
            ****|

                |****
                |****
            ----|----
            ****|****
            ****|**** (the fourth quarter is redandunt.)
        */


        if(centerVal == target){
            return true;
        } else if(centerVal < target){
            return helper(matrix, midRow+1,colStart, rowEnd, colEnd, target ) || helper(matrix, rowStart, midCol+1, rowEnd, colEnd, target);
        } else{
            return helper(matrix, rowStart,colStart, rowEnd, midCol-1, target ) || helper(matrix, rowStart, colStart, midRow - 1, colEnd, target);
        }
    }
}
