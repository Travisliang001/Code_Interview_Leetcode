import java.io.*;
import java.util.*;
// import stat ;

class MaxGreyness {

  public static void main(String[] args) {
    System.out.println("test");
  }

  public static int maxGreyness(String [] input){
    int res = 0;
    int [] rowArr = new int [input.length];
    int [] colArr = new int [input[0].length()];

    for(int rowIdx=0; rowIdx<rowArr.length; rowIdx++){
      for(int colIdx=0; colIdx<colArr.length; colIdx++){
        //The difference between the number of black(0) in the ith row and jth column and the number of white(1) in the ith row and jth column.
        if(input[rowIdx].charAt(colIdx) == '1'){
          rowArr[rowIdx] += 1;
          colArr[colIdx] += 1; 
        } else{
          rowArr[rowIdx] -= 1;
          colArr[colIdx] -= 1;
        }

      }

    }
    int min_col = Integer.MIN_VALUE;
    int min_row = Integer.MIN_VALUE;

    for(int num : colArr){
      min_col = Math.min(min_col, num);
    }

    for(int num : rowArr){
      min_row = Math.min(min_row, num);
    }

    res = min_col + min_row;
    return res;
  }

}