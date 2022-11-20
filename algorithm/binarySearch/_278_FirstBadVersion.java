package leetcode;

import java.io.*;
import java.util.*;

//Time complexity: O(logn);
//space complexity: O(1)
public class _278_FirstBadVersion {
    
    //This template will ends up with left and right are fliped. 
    // [1, 2, 3, 4, 5]  4 is the first bad
    //        r  L  L+1
    // r is the last good version; L is the first bad veresion. L+1 is the second bad version.    
    /*
        Understand the steps that we need to follow:
        1. clarify what is the bound for left and right. left = >(0 or 1) right => (length or length -1)
        left = 0: when array index
        left = 1: when given a input as n, when starting from 1 to n

        right = length: when given an input as n, and starting from 1 to n; doing template 2, ex: while(left < right)
        right = length - 1: when doing the template 1 and 3
        2.
    */
    public static int firstBadVersion(int input){
        
        int left = 1, right = input;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(!isTrueOrFalse(mid)){
                left = mid + 1;
            } 
            else{
                right = mid - 1;
            }
        }
        return left; 

    }
    //API that return true if this bad version.
    public static boolean isTrueOrFalse(int input){
        return true;
    }

}
