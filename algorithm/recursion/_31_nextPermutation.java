package algorithm.recursion;

public class _31_nextPermutation {
    //[1,2,3,4] ->[1,2,4,3]
// Step1, from right to left, find the first number which not increase in a ascending order. In this case which is 3.
// Step2, here we can have two situations:

// We cannot find the number, all the numbers increasing in a ascending order. This means this permutation is the last permutation, we need to rotate back to the first permutation. So we reverse the whole array, for example, 6,5,4,3,2,1 we turn it to 1,2,3,4,5,6.

// We can find the number, then the next step, we will start from right most to leftward, try to find the first number which is larger than 3, in this case it is 4.
// Then we swap 3 and 4, the list turn to 2,4,6,5,3,1.
// Last, we reverse numbers on the right of 4, we finally get 2,4,1,3,5,6.
    public void nextPermutation(int [] nums){
        //find the first peek index starting from the end.
        int pivotIdx = getPivotIndex(nums) - 1;
        //once get the index before the pivot, swap these two values.
        if(pivotIdx != -1){
            //starting from the end and search the first value that is greater than the pivot val.
            int peekIdx = getPeekIndex(nums, nums[pivotIdx]);
            swap(pivotIdx, peekIdx, nums);
        }
        reverseArr(nums, pivotIdx+1, nums.length-1);
    }

    private void reverseArr(int[] nums, int start, int end) {
        while(start < end){
            swap( start++, end--,nums);
        }
    }

    private void swap(int pivotIdx, int peekIdx, int[] nums) {
        int temp = nums[pivotIdx];
        nums[pivotIdx] = nums[peekIdx];
        nums[peekIdx] = temp;
    }

    private int getPeekIndex(int[] nums, int pivotVal) {
        for(int i=nums.length - 1; i>=0; i--){
            if(nums[i] > pivotVal){
                return i;
            }
        }
        return 0;
    }

    private int getPivotIndex(int[] nums) {
        for(int i=nums.length - 1; i>0; i--){
            if(nums[i-1] < nums[i]){
                return i;
            }
        }
        return 0;
    }

    
}
