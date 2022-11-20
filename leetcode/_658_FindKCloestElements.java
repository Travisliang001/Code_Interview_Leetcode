package leetcode;

import java.util.stream.Collectors;
import java.util.*;
public class _658_FindKCloestElements {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2,3,4,5,}, 4, 3));
    }
    // case 1: x - A[mid] < A[mid + k] - x, need to move window go left
    // -------x----A[mid]-----------------A[mid + k]----------
    
    // case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
    // -------A[mid]----x-----------------A[mid + k]----------
    
    // case 3: x - A[mid] > A[mid + k] - x, need to move window go right
    // -------A[mid]------------------x---A[mid + k]----------
    
    // case 4: x - A[mid] > A[mid + k] - x, need to move window go right
    // -------A[mid]---------------------A[mid + k]----x------

    //Since  midpoint of the two values midVal = (A[mid]+(A[mid+k]-A[mid])/2),
    //if x > (A[mid]+(A[mid+k]-A[mid])/2), then x is more closer to A[mid+k]
    // it means the window will select [A[mid+1], A[mid+k]], starting from right
    
    //else x < (A[mid]+(A[mid+k]-A[mid])/2), then x is more closer to A[mid]
    // it means the window will select from [A[mid]] to A[mid+k-1]
    //it mean
    //1,2,3,4,5}, k=4, x=3


    //1. left = 0, right = 1, x = 3 
    private static List<Integer> solve(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        //SInce mid is always less than right
        // mid(max) + k is always less than (arr.length - k) 

        //At the end of the day, the window size is 1 and left = right.
        while(left < right){
            int mid = left + (right - left)/2;
            int valMid = arr[mid];
            int valK = arr[mid+k];
            //Move window to the left
            // x > (valMid + valK)/2
            if((x - valMid > valK - x)){
                left = mid + 1;
            }else{
            //Shrink the window by half since the left size is more closer.
                //x < (valMid + valK)/2
                right = mid;
            }

        }
        
        return Arrays.stream(arr, left, left+k).boxed().collect(Collectors.toList());
    }
}
