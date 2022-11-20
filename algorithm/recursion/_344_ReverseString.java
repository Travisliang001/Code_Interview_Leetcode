package algorithm.recursion;

public class _344_ReverseString {
    public static void main(String[] args) {
        System.out.println(solve("inputString"));
        char [] input = new char [] {'a','b','c'};
        solveVoid(input);
        System.out.println(input);
    }
    //another way to reverse a string without for loop. 
    private static void solveVoid(char[] cs) {
        int i = 0;
        int j = cs.length - 1;
        solveHelper(cs, i, j);
    }

    private static void solveHelper(char[] cs, int i, int j) {
        if(i >= j) return;
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
        //postfix increment. incredment the value then pass into a function.
        solveHelper(cs, ++i, --j);
    }
    //break down into a problem that solving reverse two elements in array.
    private static String solve(String input) {
        int length = input.length();
        if(length <= 1) return input;
        String leftStr = input.substring(0, length/2);
        String rightStr = input.substring(length/2, length);

        return solve(rightStr) + solve(leftStr);
    }
}
