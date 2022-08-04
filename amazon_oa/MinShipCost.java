import java.io.*;
import java.util.*;
// import stat ;

class MinShipCost {

  public static void main(String[] args) {
    System.out.println(minShipCost(new int [] {2,3,6,10,11}, 9));
  }

  //k is the maximum size that truck can take.
  //parcels[1]=1, id is the cost to ship the parcel. 
  public static long minShipCost(int [] parcels, int k){
    long res = 0;
    int count = k - parcels.length;
    TreeSet<Integer> parcelSet = new TreeSet<>();

    for(int input : parcels){
      parcelSet.add(input);
    }

    //adding 0 and Integer.max to the set so that we are able to search numbers within boundary
    parcelSet.add(0);
    parcelSet.add(Integer.MAX_VALUE);
    
    //using k to keep track of how many item should we remain to add. 
    int startNum = 0;
    for(int curNum : parcelSet){
      int diff = curNum - startNum;
      //COndition: two numbers are not neighbor and the remain items are still not added.
      if(diff > 1 && count > 0){
        long range = Math.min(diff - 1, count); // remove the 0 impact. and checking which one is smaller and assigned it range. 

        //(a1+an)*n/2
        res += (startNum + 1 + startNum + range) * range / 2;
        count -= range;
      }
      startNum = curNum;
    }

    return res; 
  }

}