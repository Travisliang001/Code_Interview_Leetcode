package leetcode;

public class _167_twoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,7,11,15}, 11));

        
    }

    private static int [] solve(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum > target) {
                right--;
            } else if(sum < target){
                left++;
            } else{
                return new int [] {left + 1, right + 1};
            }
        }

        return new int [] {-1, -1};
    }
}
