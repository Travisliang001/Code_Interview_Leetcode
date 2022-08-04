import java.io.*;
import java.util.*;
// import stat ;

class FindMinHealth {

  public static void main(String[] args) {
    System.out.println("test");
  }

  public static long findMinHealth(List<Integer> power, int armor){
    long minStartingBlood = 0; 
    int max = power.get(0);
    for(int i=1; i<power.size(); i++){
      max = Math.max(max, power.get(1));
    }

    long sum = 0;
    for(int i=0; i<power.size(); i++){
      sum += power.get(i);
    }
    //1. armor is 1, but the max is 2
    //2. armor is 2, but the max is 1
    minStartingBlood = sum + 1 - Math.min(armor, max);
    return minStartingBlood;

  }

}