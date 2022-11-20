package algorithm.recursion;
import java.util.*;

class _102_BinaryTreeLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            //Traverse all the same level nodes.
            //queue will store all the same level nodes.
            for(int i=0; i<cnt; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        
        return res;
    }
    
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         helper(res, 0, root);
//         return res;
//     }
    
//     public void helper(List<List<Integer>> res,  int lvl, TreeNode root){
//         if(root == null){
//             return;
//         }
//         List<Integer> temp = new ArrayList<>();
//         if(res.size() > lvl){
//             temp = res.get(lvl);            
//         }
//         //preorder traverse:
//         temp.add(root.val);
//         if(res.size() > lvl){
//           res.set(lvl, temp);
//         } else{
//             res.add(temp);
//         }
//         helper(res, lvl+1, root.left);
//         helper(res, lvl+1, root.right);
        
//     }
}