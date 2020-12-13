### LeetCode-617 合并二叉树

#### [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)

```java
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 1. 归并，将结果记录为新树的根结点
        // 2. 递归地归并左子树，并将结果作为新树的左子树
        // 3. 递归地归并右子树，并将结果作为新树的右子树
        // 递归出口：如果t1为空就返回t2, 如果t2为空就返回t1。
        if(t1==null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode t = new TreeNode(t1.val+t2.val);
        t.left=mergeTrees(t1.left,t2.left);
        t.right=mergeTrees(t1.right,t2.right);
        return t;
    }
}
```

