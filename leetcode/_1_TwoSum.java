package leetcode;
import java.io.*;
import java.util.*;
// import stat ;
//COmplexity: O(N) Time & O(N) Space
class _1_TwoSum {

  public static void main(String[] args) {
    System.out.println(twoSum(new int []{2,7,11,15}, 9));
  }
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    for(int i=0; i<nums.length; i++){
        int cur = nums[i];
        int diff = target - cur;
        if(numMap.containsKey(cur)){
            return new int [] {i, numMap.get(cur)};
        } else{
            numMap.put(diff, i);
        }
    }
    
    return null;
}
}