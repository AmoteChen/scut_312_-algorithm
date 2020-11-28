### Leetcode-222 完全二叉树的节点个数



直接暴力先序遍历就能AC

```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
}
```

