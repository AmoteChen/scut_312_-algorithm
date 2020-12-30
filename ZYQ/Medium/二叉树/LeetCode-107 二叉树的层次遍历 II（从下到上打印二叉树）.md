### LeetCode-107 二叉树的层次遍历 II

#### [107. 二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> tempRes = new ArrayList();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode  node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right !=null )queue.add(node.right);
                tempRes.add(node.val);
            }
            result.add(0,tempRes);
        }
        return result;
    }
}
```

我不仅从上到下打印，我还能从下到上打印，您想要的需求我都有