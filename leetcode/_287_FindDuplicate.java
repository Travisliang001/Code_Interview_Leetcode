package leetcode;

public class _287_FindDuplicate {
    //Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    //You must solve the problem without modifying the array nums and uses only constant extra space.

    public static void main(String[] args) {
        System.out.println(solve(new int [] {2,1,2,3,4}));
    }

    private static Integer solve(int[] input) {
        int length = input.length;
        int right = length - 1;
        int left = 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int num : input){
                if(num <= mid){
                    count++;
                }
            }

            if(count <= mid){
                left = mid + 1;
            } else{
                right = mid;
            }

        }
        return left;
    }


}
