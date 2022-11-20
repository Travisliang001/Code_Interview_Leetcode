package leetcode;

public class _34_FindFirstAndLastPosOfElementInSortedArr {
    public static void main(String[] args) {
        System.out.println(solve(new int [] {5,7,7,8,8,10}, 8));
    }
    // 1. if A[mid] < target, then the range must begins on the right of mid. left = mid + 1;
    // 2. if A[mid] > target, then it means the range must begin on the left of mid ( right = mid - 1);
    // 3. if A[mid] == target, then it means the range must begin on the left or at the mid(j = mid)
    private static int[] solve(int[] input, int target) {
        int res [] = {-1, -1};
        res[0] = findFirst(input, target);
        res[1] = findSecond(input, target);
        
        return res;
    }
    private static int findSecond(int[] input, int target) {
        int res = -1;
        int left = 0, right = input.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int midVal = input[mid];
            if(midVal <= target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
            if(input[mid] == target) res = mid;
        }
        return res;
    }
    private static int findFirst(int[] input, int target) {
        int res = -1;
        int left = 0, right = input.length - 1;
        while(left <= right ){
            int mid = left + (right - left ) / 2;
            int midVal = input[mid];
            if(midVal >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            if(midVal == target){
                res = mid;
            }
        }
        return res;
    }

    
}
