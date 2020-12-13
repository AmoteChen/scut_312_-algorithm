### LeetCode-104 二叉树的最大深度

#### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int res = 1;
        int max_left = maxDepth(root.left);
        int max_right = maxDepth(root.right);
        res+=Math.max(max_left,max_right);
        return res;
    }
}
```

这深度优先搜索的简单题都快把我自信打出来了。

