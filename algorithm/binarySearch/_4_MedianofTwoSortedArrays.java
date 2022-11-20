package leetcode;
import java.io.*;
import java.util.*;

public class _4_MedianofTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(medianOfTwoSortedArrays( new int[] {2,4,5,6}, new int[] {1,4,7,9,10}));
    }

    public static int medianOfTwoSortedArrays(int [] nums1, int [] nums2){
           if(nums1.length > nums2.length) return medianOfTwoSortedArrays(nums2, nums1);
           int res = 0;
           int left = 0, right = nums1.length;
           //left and right the window that select the numbers from the nums1(short one)
            while(left <= right){
                int x = left + (right - left)/2; //index in nums1
                //why (nums1.length + nums2.length + 1) ==> it makes the odd length to be even, which cause: "left size = right size + 1"
                int y = (nums1.length + nums2.length + 1) / 2 - x; //index in nums2
                int nums1Left = (x == 0) ? Integer.MIN_VALUE : nums1[x-1];
                int nums1Right = (x == nums1.length) ? Integer.MAX_VALUE : nums1[x];
                int nums2Left = (y == 0) ? Integer.MIN_VALUE : nums2[y - 1];
                int nums2Right = (y == nums2.length) ? Integer.MAX_VALUE : nums2[y];

                // if it meets the requirements:
                if(nums1Left < nums2Right && nums1Right > nums2Left){
                    if( (nums1.length + nums2.length) / 2 == 0 ) res = (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right))/2;
                    else{
                        res = Math.min(nums1Left, nums2Left);
                    }
                } else if(nums1Right < nums2Left) {
                    left = x + 1;
                } else {
                    right = x - 1;
                }

            }
            return res;
    }
    // 1. left = 0, right = 4, x = 2, y = 3, nums1Left = 4, nums1Right = 5, nums2Left = 7, nums2Right = 9
                            // 2  4 | 5  6
                            // 1  4  7 | 9  10 (12)
                            // left = 2 + 1 = 3;
    // 2. left = 3, right 4, x = 3, y = 2, nums1Left = 5, nums1Right = 6, nums2Left = 4, nums2Right = 7
                            // 2  4   5  |  6
                            //1   4 | 7  9  10 
                        }
