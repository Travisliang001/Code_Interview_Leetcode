package leetcode;

public class _33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(searchInroatedSortedArray(new int[]{4,5,6,7,0,1,2}, 0));
    }

    private static int searchInroatedSortedArray(int[] input, int target) {
        int left = 0, right = input.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int cur = input[mid];
            int leftVal = input[left];
            int rightVal = input[right];
            //only increasing from left
            if(cur == target){
                return mid;
            } else if(cur >= leftVal) {
                if(leftVal <= target && target<cur){
                    right = mid -1;
                }else{
                    left = mid + 1;
                }
            } else {
                if(cur < target && target <= rightVal){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
