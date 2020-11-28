// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
// 这里最主要需要用到双端队列，但是奇数层次的时候就往队尾添加，偶数层次就往队头添加。这里判断层数的奇偶性也有小技巧！
class Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>>res = new ArrayList<>();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size()%2==0)
                    list.addLast(node.val);
                else
                    list.addFirst(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            res.add(list);
        }
        return res;
        
    }
}