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
        //32 10
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

    //1. left = 10, right = 32, mid = 21, 
    //                   curSum = 24, curSum > mid => curSum = 10, count = 2; curSum = 18; return true; // we can minimize the mid value by increasing the right bound value to mid.
    //2. left = 10, right = 21, mid = 15,
    //                   curSum = 24, curSum > mid => curSum = 10, count = 2; curSum = 18 > 15; curSum = 8; count = 3; 3>2; return false; // we can inscrease the mid value since there are some values are greater than 15
    //1. How to group them: single loop to iterate them 
    private static boolean isValid(int mid, int[] input, int cuts) {
        int count = 1, curSum = 0;
        for(int num : input){
            curSum += num;
            if(curSum > mid){ //if greater than the target then reset and starting the new added element to build up a new case. 
                curSum = num;
                count++;
                if(count>cuts) return false;
            } 
        }

        return true;
    }
}
