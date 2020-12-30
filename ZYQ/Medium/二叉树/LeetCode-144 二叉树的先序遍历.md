### LeetCode-144 二叉树的先序遍历

直接暴力递归就完事了

面试不会问这么简单的吧

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        preorder(root,list);
        return list;
    }
    public void preorder(TreeNode root,List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
}
```

