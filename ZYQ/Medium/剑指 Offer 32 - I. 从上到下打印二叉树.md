### 剑指 Offer 32 - I. 从上到下打印二叉树

#### [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

```java
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList();
        if(root !=null ) queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node  = queue.poll();
            res.add(node.val);
            if(node.left !=null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int [] result = new int [res.size()]; 
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}
```

