package algorithm.recursion;

public class _104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        
        return helper(root,0);
    }
    
    public int helper(TreeNode root, int base){
        if(root == null){
            return base;
        } else{
            base++;
        }
        
        
        return Math.max(helper(root.left, base), helper(root.right, base));
    }
}
