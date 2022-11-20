package leetcode;

import java.util.*;

public class _719_FindKthSmallestpairDistance {
    public static void main(String[] args) {
        System.out.println(solve(new int []{1,6,4,10,9,3}, 5));

        
    }
    //1. Since it is asking the rank of the distance of pair, it will need to sort the array. 
    //2. left is the smallest number for the different [1,1] and right the bigest different like [size - 1] - [0] 
    //3. Return the result [0] when k = 1, 
    private static int solve(int[] input, int rank) {
        Arrays.sort(input);
        //1  3  4  6  9  10

        //1. left = 0, right = 9, mid = 4, 
        //        isSmallPair 
        //         count = 0, left = 0, right = 1  => count =1 (1,3)
        //         left = 0, right = 2, count = 1 + 2 = 3 => (4,1) , (4,3)
        //         left = 0, right = 3, left = 1 => count = 3 -1 =2+3=5 => (6,3) , (6,4) 
        //         left = 1, right = 4, left =  3  => count = 5+ 4-2 = 7
        int left = 0, right = input[input.length - 1] - input[0];
        while(left < right){
            int mid = left + (right - left)/2;
            if(isSmallPair(input, rank, mid)){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return left;
        
    }
    private static boolean isSmallPair(int[] input, int rank, int mid) {
        //count: using to keep track of the rank of the diference of pair
        //left: 1. using to norrow down the left bound if the pair is greater than the reference variable(mid)
        //      2. allow right to do the matching combination. 
        int count = 0, left = 0;
        for(int right = 1; right<input.length; right++){
            while(input[right] - input[left] > mid){
                //the window contains invalid data and need to shrink the size
                left ++;
            }
            //counting how many elements(pair) that less than 
            count += right - left;

        }
        //if there are more combinations that we need, return true and shrink the size from left.
        return count>=rank;
    }

    
}
