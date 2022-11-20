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
    //mid = 2, left = 3,
    //mid = 4, midval = 8, left = 5
    //mid = 5, midVal = 10, right = 4
    private static int findSecond(int[] input, int target) {
        int res = -1;
        int left = 0, right = input.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int midVal = input[mid];
            //Below will focus on the search on the right(left = mid + 1)
            if(midVal <= target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
            if(input[mid] == target) res = mid;
        }
        return res;
    }

    //mid = 2, midVal = 7, left = 3
    //mid = 4, midVal = 8, right = 3, left=3
    //mid = 3, midVal = 8, 
    private static int findFirst(int[] input, int target) {
        int res = -1;
        int left = 0, right = input.length - 1;
        while(left <= right ){
            int mid = left + (right - left ) / 2;
            int midVal = input[mid];
            //Below will focus on the search on the left(right = mid - 1)
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
