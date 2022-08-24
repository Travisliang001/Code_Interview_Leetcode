
import java.io.*;
import java.util.*;

//Time complexity: O(logn);
//space complexity: O(1)
public class _278_FirstBadVersion {
    
    //This template will ends up with left and right are fliped. 
    // [1, 2, 3, 4, 5]  4 is the first bad
    //        r  L  L+1
    // r is the last good version; L is the first bad veresion. L+1 is the second bad version.    
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
