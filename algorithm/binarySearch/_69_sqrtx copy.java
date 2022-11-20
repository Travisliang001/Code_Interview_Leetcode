package leetcode;

public class _69_sqrtx {
    public static void main(String[] args) {
        System.out.println(mySqrt(7));
    }
    public static int mySqrt(int x) {
        if(x == 1 || x == 0) return x;
        long xLng = x;
        int left = 0, right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long res = mid * mid;
            if(res == xLng){
                return mid;
            } else if(res > xLng) {
                right = mid - 1;
                System.out.println("Res is " + res);
                System.out.println("right is " + right);
                System.out.println("left is " + left);
                System.out.println("-----------------");
            } else{
                left = mid + 1;
                System.out.println("Res is " + res);
                System.out.println("right is " + right);
                System.out.println("left is " + left);
                System.out.println("-----------------");
            }
        }
        
        //Break when right and left switch
        //left > right
        //left = right + 1
        //since we don't get the exact result, we will return right.
        return right;
    }
}
