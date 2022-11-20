package algorithm.recursion;

import java.util.*;

public class _95_UniqueBinarySearchTree {
    public List<TreeNode> generateTrees(int n) {
        
        return generateTreeHelp(1,n);
    }
    private List<TreeNode> generateTreeHelp(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        //if left > end:
        //When recursively call this function, start > end when the first val is first entered.
        if(start > end){
            res.add(null);
            return res;
        }
        //recursively call each element as the main root. 
        for(int rootValue=start; rootValue<=end;rootValue++){
            //using each root val as the middle point to divide left and right region.
            //rootValue = 1: left = [null], right = [2,3,4,5,6,7]
            //all this sub treenode have gone thru the logic,
            List<TreeNode> leftSubTrees = generateTreeHelp(start, rootValue - 1);
            List<TreeNode> rightSubTrees = generateTreeHelp(rootValue + 1, end);
            //using either left or right subtree list to traverse are good. 

            //this below logic ran after the recursive call
            //post-recursive call. Assuming you have processed all the sub nodes for each lvl,
            // then this is how process in the post recursive call.  
            for(TreeNode leftSubTree: leftSubTrees){
                for(TreeNode rightSubTree : rightSubTrees){
                    TreeNode currentRoot = new TreeNode(rootValue);
                    currentRoot.left = leftSubTree;
                    currentRoot.right = rightSubTree;
                    res.add(currentRoot);
                }

            }
        }
        return res;

    }
}
