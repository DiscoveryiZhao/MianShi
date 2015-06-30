package Trees.BinaryTree.TopDown;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true ;
        } else{
            return isMirror(root. left, root. right);
        }
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true ;
        } else{
            if (p == null || q == null) return false ;
            if (p.val != q.val ) return false;
            return isMirror(p. left, q. right) && isMirror(p.right, q.left);
        }
    }
}