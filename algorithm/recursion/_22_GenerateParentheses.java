package algorithm.recursion;

import java.util.*;

public class _22_GenerateParentheses {
//     The key to all backtracking problems is "to choose". You have to choose between many options and then come back to choose again. In this problem, you have to choose between left and right parenthesis. In another backtracking problem:letter-combinations-of-a-phone-number. You have to choose between different letters. These problems share a same pattern.
// In your helper function, you just need to list all your options and try each one of them out.
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, String input, int numOfOpen, int numOfClose, int max) {
        //find solution step that will yield the output by the constraints.
        //totalOfLeft + totalOfRight = 2*max
        //
        if(input.length() == max*2){
            res.add(input);
            return;
        }
        //terminate
        //Validation step: the end result should be numOfOpen = max
        if(numOfOpen < max){
            backtrack(res, input+"(", numOfOpen+1, numOfClose, max);
        }

        //input+")" or input+"(" are the place and remove step.
        if(numOfClose < numOfOpen){
            backtrack(res, input+")", numOfOpen, numOfClose+1, max);
        }
    }

    private void helper(List<String> res, int left, int right, String s){
        
    }
}
