package algorithm.recursion;
import java.util.*;

public class _17_letterComboOfPhoneNum {
     //1. FIFO queue to use iteration instead of recursion
    //2. String [] map is the key of integer and value is string
    private final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
    //Recursion:
//     public List<String> letterCombinations(String digits) {
//         List<String> res = new LinkedList<String>();
//         if(digits.length() == 0){
//             return res;
//         }
//         helper("", digits, 0, res);
//         return res;
//     }
    
//     private void helper(String temp, String digits, int curIdx, List<String> res){
//         if(curIdx == digits.length()){
//             res.add(temp);
//             return;
//         }
//         //how to  get int diff from the difference between two characters
//         String letters = KEYS[(digits.charAt(curIdx) - '0')];
//         for(int i=0; i<letters.length(); i++){
//             helper(temp+letters.charAt(i), digits, curIdx+1, res);
//         }
//     }
}
