// 给定一个 N 叉树，返回其节点值的前序遍历。
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result;
    public List<Integer> preorder(Node root) {
        result = new ArrayList<>();
        pre(root);
        return result;
    }
    public int pre(Node root)
    {
        if(root==null)
            return 0;
        result.add(root.val);
        for(Node node:root.children)
        {
            pre(node);
        }
        return 0;
    }
}