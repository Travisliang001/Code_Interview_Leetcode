
package algorithm.recursion;

import java.util.*;

public class _94_BinaryTreeInorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> recursionSln(TreeNode root) {
        if (root == null) {
            return res;
        }

        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        //stack is to maintain the order that it adds to the res list.
        //Inorder is to print the left most node and then root node. print right node lastly.
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            // retrieve the most left node from tree.
            cur = stack.pop();
            res.add(cur.val);
            //check the left most node whether it has right sub tree.
            cur = cur.right;
        }
        return res;
    }
}
