package algorithm.recursion;

public class _700_SearchInBinarySearchTree {
    public static void main(String[] args) {
        System.out.println();
    }

    public TreeNode searchBST(TreeNode root, int val){
        //base case:
        if(root == null){
            return root;
        }

        if(root.val == val){
            return root;
        }
        
        if(root.val<val){
            return searchBST(root.right, val);
        } else{
            return searchBST(root.left, val);
        }
    }
}
