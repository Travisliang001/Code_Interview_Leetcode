package algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

public class _70_ClimbingStarts {
    private Map<Integer, Integer> countMap = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            countMap.put(n,n);
            return n;
        } 
         int result = -1;
        if(!countMap.containsKey(n)){
            result = climbStairs(n-1) + climbStairs(n-2);
            countMap.put(n,result);
        } else{
            return countMap.get(n);
        }
        
        return result;
    }
}
