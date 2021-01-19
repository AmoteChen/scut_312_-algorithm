// 给定一棵二叉搜索树，请找出其中第k大的节点。
//  
// 示例 1:

// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 4
class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> a = new ArrayList<>();
        read(root,a);
        return a.get(k-1);
    }
    public void read(TreeNode root,List a)
    {
        if(root==null)
            return;
        read(root.right,a);
        a.add(root.val);
        read(root.left,a);
    }
}