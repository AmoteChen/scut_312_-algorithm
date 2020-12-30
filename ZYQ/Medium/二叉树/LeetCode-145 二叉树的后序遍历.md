### LeetCode-145 二叉树的后序遍历

不会真的有兄弟用栈来迭代吧

不会吧不会吧

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList(); 
        postorder(root,list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
}
```

