### 剑指offer 32 - II 从上到下打印二叉树

#### [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

依旧是层次遍历。区别是这次要通过queue的size来做一次for循环，每一层打印到一行。

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> que = new   LinkedList();
        List<List<Integer>> res = new ArrayList();
        if(root !=null) que.add(root);
        while(!que.isEmpty()){
            List<Integer> temp = new ArrayList();
            for(int i=que.size();i>0;i--){
                TreeNode node = que.poll();
                temp.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null)que.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
```

