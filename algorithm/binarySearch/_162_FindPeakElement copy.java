package leetcode;

public class _162_FindPeakElement {
    //return the peak in the array
    //left is min, right is max
    // [1,2,1,3,5,6,4]
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }

    private static int findPeakElement(int[] input) {
        // return the index in the array
        int res = 0;
        int left = 0, right = input.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int cur = input[mid];
            int leftVal = input[left];
            //wrong: input[right] => you can't guarantee this is always increasing, you need to check the value next to it.
            int rightVal = input[mid+1]; //can't place the value of right in the array. 
            if(cur <= rightVal){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }

    
}
