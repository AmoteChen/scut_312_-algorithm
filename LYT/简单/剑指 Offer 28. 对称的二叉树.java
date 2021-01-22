// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

//     1
//    / \
//   2   2
//    \   \
//    3    3
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null?true:isCTree(root.left,root.right);
    }
    public boolean isCTree(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val)return false;
        return isCTree(left.left,right.right)&&isCTree(left.right,right.left);
    }
}