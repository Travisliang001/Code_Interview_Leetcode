package algorithm.recursion;
import java.util.*;

public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int curIdx){
        
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(curIdx == nums.length){
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            int curVal = nums[i];
            if(temp.contains(curVal)){
                continue;
            }
            temp.add(curVal);
            helper(res, temp, nums, curIdx+1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> iterativeSln(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        result.add(Arrays.asList(nums[0]));

        for(int i=1; i<nums.length; i++){
            List<List<Integer>> newRes = new ArrayList<>();
            for(List<Integer> cur : result){
                for(int j=0; j<=i; j++){
                    List<Integer> newCur = new ArrayList<>(cur);
                    newCur.add(j, nums[i]);
                    newRes.add(newCur);
                }
            }
            result = newRes;
        }
        return result;
    }
}
