package leetcode;

public class _153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMinInRotatedSortedArr(new int [] {4,5,6,7,0,1,2}));
        System.out.println(findMaxInRotatedSortedArr(new int [] {0,1,2,4,5,6,7}));

    }
    //input => 4,5,6,7,0,1,2
    //Goal:
    // # the main idea for our checks is to converge the left and right bounds on the start
    // # of the pivot, and never disqualify the index for a possible minimum value.
    private static int findMinInRotatedSortedArr(int[] input) {
        int left = 0, right = input.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            int midVal = input[mid];
            int rightVal = input[right];
            //unqiue
            //if using midVal and leftVal to compare:
            //when leftVal > midVal: 5 6 7 8 0 1 2 3 4 : right = mid;
            //when leftVal < midVal: not rotated array from the left. left = mid + 1; 
            //Need to verify why we should compare midval vs rightval not midval vs leftVal.
            if(midVal < rightVal){
                right = mid;
                System.out.println("Right is : " + right);
            } else{
                left = mid + 1;
                System.out.println("Left is : " + left);
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