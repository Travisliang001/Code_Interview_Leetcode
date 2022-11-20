package algorithm.recursion;

public class _100_SameTree {

    //     public boolean isSameTree(TreeNode p, TreeNode q) {
    //         if(p == null && q == null) return true;
    //         if(p == null || q == null) return false;
    //         if(p.val != q.val) return false;
            
    //         return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
    //     }
        public boolean isSameTree(TreeNode p, TreeNode q) {
           if(p == null && q == null) return true;
            if(!isEqual(p, q))return false;
            
            ArrayDeque<TreeNode> deP= new ArrayDeque<TreeNode>();
            ArrayDeque<TreeNode> deQ = new ArrayDeque<TreeNode>();
            deP.addLast(p);
            deQ.addLast(q);
            
            while(!deP.isEmpty()){
                p = deP.removeFirst();
                q = deQ.removeFirst();
                
                if(!isEqual(p,q)) return false;
                
                if(p != null){
                    if(!isEqual(p.left, q.left)) return false;
                    if(p.left!=null){
                        deP.addLast(p.left);
                        deQ.addLast(q.left);
                    }
                    
                    if(!isEqual(p.right, q.right)) return false;
                    if(q.right!=null){
                        deP.addLast(p.right);
                        deQ.addLast(q.right);
                    }
                }
            }
            return true;
           
        }
        
        public boolean isEqual(TreeNode p, TreeNode q){
             if(p == null && q == null) return true;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;
             return true;
        }
        
    }
