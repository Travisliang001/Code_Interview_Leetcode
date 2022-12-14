package algorithm.binarySearch;

import java.io.*;
import java.util.*;

public class _410_SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println(solve(new int [] {7,2,5,10,8}, 2));
    }

    private static int solve(int[] input, int cuts) {
        int sum =0, max = Integer.MIN_VALUE;
        for(int num : input) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max, right = sum;

        while(left<right){
            int mid = left + (right - left) / 2;
            //isValid: return the range that satisfy the minimum largest sum
            //Mid is the standard that to find out the smallest largest sum
            //Conditions: (count is meet) && (comibination within each cut is greater than mid)
            //True: if not all conditions meet, we can safely consider the element before mid.
            //false: we will increase the reference variable and start from there.
            if(isValid(mid, input, cuts)){
               right = mid; // need to get minimum
            } else{
                left = mid + 1;
            }
        }

        return left;
    }
    //1. How to group them: single loop to iterate them 
    private static boolean isValid(int mid, int[] input, int cuts) {
        int count = 1, curSum = 0;
        for(int num : input){
            curSum += num;
            if(curSum > mid){
                curSum = num;
                count++;
                if(count>cuts) return false;
            } 
        }

        return true;
    }
}
