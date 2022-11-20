package algorithm.recursion;

public class _98_ValidateBinarySearchTree {
    public boolean isValidateBST(TreeNode root){
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        //if they break the rules, then return false;
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
