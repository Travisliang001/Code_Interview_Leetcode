package leetcode;

public class _154_FindMinimumInRotatedSortedArrayWithDuplicateVals {
    public static void main(String[] args) {
        System.out.println(findMinInRotatedSortedArr(new int [] {2,2,2,0,1}));
        // System.out.println(findMaxInRotatedSortedArr(new int [] {0,1,2,4,5,6,7}));

    }
    //input => 4,5,6,7,0,1,2
    //Goal:
    // # the main idea for our checks is to converge the left and right bounds on the start
    // # of the pivot, and never disqualify the index for a possible minimum value.
    private static int findMinInRotatedSortedArr(int[] input) {
        // int left = 0, right = input.length - 1;
        //2,2,2,0,1
        // wrong solution: didn't cover the case when input[left] = input[right] ===> duplicate values needed to offset one by one and check
        //**********rotated Array always using midVal and RightVal to compare */
        // while(left < right) {
        //     int mid = left + (right - left) / 2;
        //     int midVal = input[mid];
        //     int leftVal = input[left];
        //     int rightVal = input[right];
        //     if(leftVal <= midVal){
        //         if(leftVal <= midVal && midVal <= rightVal){
        //             right = mid;
        //         } else{
        //             left = mid + 1;
        //         }
        //     } else{
        //         if(leftVal > midVal && midVal >= rightVal) {
        //             left = mid + 1;
        //         } else{
        //             right = mid;
        //         }
        //     }
        // }
        // return input[left];

        int left = 0, right = input.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int midVal = input[mid];
            int rightVal = input[right];

            if(midVal > rightVal){
                left = mid + 1;
            } else if(midVal < rightVal){
                right = mid;
            } else{//when the midVal == rightVal, 
                right--;

            }

        }
        return input[left];        
    }

    private static int findMaxInRotatedSortedArr(int[] input) {
        int left = 0, right = input.length - 1;

        //Solve: Using the second template and create a variable to store the max value.
        return input[left];
    }
}
// (1) loop is left < right, which means inside the loop, left always < right
// (2 ) since we use round up for mid, and left < right from (1), right would never be the same as mid
// (3) Therefore, we compare mid with right, since they will never be the same from (2)
// (4) if nums[mid] < nums[right], we will know the minimum should be in the left part, so we are moving right.
// We can always make right = mid while we don't have to worry the loop will not ends. Since from (2), we know right would never be the same as mid, making right = mid will assure the interval is shrinking.
// (5) if nums[mid] > nums[right], minimum should be in the right part, so we are moving left. Since nums[mid] > nums[right],mid can't be the minimum, we can safely move left to mid + 1, which also assure the interval is shrinking