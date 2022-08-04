import java.io.*;
import java.util.*;
// import stat ;

class ShipmentImbalance {

  public static void main(String[] args) {
    System.out.println(shipmentImbalance(new int [] {1, 2, 3}));
  }

  //subArray using the double for loop to generate. 
  //Time Complexity: O(n^2)
  //space complexity: O(1)
  //below structure can get the max and min for the subarray of the input array.
  public static int shipmentImbalance(int [] input){
    int res = 0;
    int length = input.length;
    for(int parentIdx=0; parentIdx<length; parentIdx++){
        int max = input[parentIdx]; 
        int min = input[parentIdx];
      for(int childIdx=parentIdx+1; childIdx<length; childIdx++){
        int current = input[childIdx];
        max = Math.max(max, current);
        min = Math.min(min, current);
        res += max - min;

      }

    }

    return res;
  }
}