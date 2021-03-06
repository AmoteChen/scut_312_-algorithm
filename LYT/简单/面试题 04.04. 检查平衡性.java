// 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。


// 示例 1:
// 给定二叉树 [3,9,20,null,null,15,7]
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回 true 。
//建议多看几遍，要理解到位，从上往下，每次都要计算左右子树的高度！
class Solution {
    public boolean isBalanced(TreeNode root) {
        // 根结点为null，说明是棵空树，认为是平衡的
        if (root == null) {
            return true;
        }
        int leftTreeDepth = treeDepth(root.left);   // 左子树高度
        int rightTreeDepth = treeDepth(root.right); // 右子树高度
        if (Math.abs(leftTreeDepth - rightTreeDepth) > 1) {
            return false;   // 高度差大于1说明不平衡
        }
        // 若以当前节点为根的子树是平衡的，继续递归检查它左右子树的平衡性
        return isBalanced(root.left) && isBalanced(root.right); 
        
    }

    public int treeDepth(TreeNode root) {
        // 递归出口，空树的高度为0
        if (root == null) {
            return 0;
        }
        // 当前二叉树的高度 = max(左子树高度,右子树高度) + 1
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}