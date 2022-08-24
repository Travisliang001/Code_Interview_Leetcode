package amazon_oa;
import java.io.*;
import java.util.*;
// import stat ;

class MaxStockPrice {

  public static void main(String[] args) {
    System.out.println(maxSUmOfStock( new int[]{1,3,7,7,6,4,3}, 3));
  }
  //1. return the maximum sum from different unique combinations of windows size of K. 
  public static long maxSUmOfStock(int[] stockPrice, int k) {
    long res = 0;
    Set<Integer> numInWindow = new HashSet<>();
    int left = 0;
    int right = 0;
    //condition: if the right boudary is not exceeding
    //action: keep searching 
    while (right < stockPrice.length) {
      // condition: when you find duplicate within the windows.
      // action: remove from the window and increment the left index.
      while (numInWindow.contains(stockPrice[right])) {
        numInWindow.remove(stockPrice[left]);
        left++;
      }
      // Normal precedures that add the element on index right to the numInWindow
      //condition: when the there is no duplicate.
      //increment the right index.
      numInWindow.add(stockPrice[right]);
      right++;

      // When the window is k, we need to calculate the val and compare with the
      // largest
      // condition: when the window size is match to k
      // action: sum up all the values within the window and compare with the result.
      //         increment the left
      while (right - left == k) {
        int curSum = 0;
        for (int i = left; i < right; i++) {
          curSum += stockPrice[i];
        }
        res = Math.max(res, curSum);
        left++;
      }

    }
    if (res == 0)
      return -1;

    return res;
  }
}