package algorithm.recursion;

import java.util.HashMap;

public class _509_FibonacciNumber {
    private HashMap<Integer,Integer> resMap = new HashMap<>();
    public int fib(int n) {
        if(resMap.containsKey(n)){
            return resMap.get(n);
        }
        
        if(n<2){
            return n;
        }
        int res = fib(n-1) + fib(n-2);
        resMap.put(n, res);
        return res;
    }
}
