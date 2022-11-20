package algorithm.recursion;
import java.util.*;

public class _78_subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }
        // helper(nums, new ArrayList<>(), 0);
        
                helperRecursive(nums, new ArrayList<>(), 0);

        return res;
    }
    
    public void helper(int [] nums, List<Integer> temp, int curIdx){
        
        for(int i=0; i<nums.length; i++){
            int curVal = nums[i];
            List<List<Integer>> addRes = new ArrayList<>();
            for(int j=0; j<res.size(); j++){
                List<Integer> curElemList = new ArrayList<>(res.get(j));
                curElemList.add(curVal);
                addRes.add(new ArrayList<>(curElemList));
                
            }
            res.addAll(addRes);
        }
    }
    
    public void helperRecursive(int [] nums, List<Integer> temp, int curIdx){
        res.add(new ArrayList<>(temp));
        
        for(int i=curIdx; i<nums.length; i++){
            temp.add(nums[i]);
            helperRecursive(nums, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
