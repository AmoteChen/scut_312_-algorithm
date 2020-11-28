Leetcode-226 翻转二叉树

简简单单的快乐

先序遍历就行了

注意判断空指针异常

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        //先序遍历
        invTree(root);
        return root;

    
    }
    public void invTree(TreeNode root){
        if(root == null) return;
        else if(root.left==null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp; 
        invTree(root.left);
        invTree(root.right);

    }
}
```

