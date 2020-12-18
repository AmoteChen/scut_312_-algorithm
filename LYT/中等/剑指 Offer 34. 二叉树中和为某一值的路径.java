// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
// 示例:
// 给定如下二叉树，以及目标和 sum = 22，

//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
//使用回溯法，方法很简单，要注意细节，一是要用LinkList，可以删除最后一个添加元素
//记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
// 正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。

class Solution {
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>(); 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        countTree(root,sum);
        return result;
    }
    public int countTree(TreeNode root,int sum)
    {
        if(root==null)
            return 0;
        path.add(root.val);
        sum -= root.val;
        if(sum==0&&root.left==null&&root.right==null)
            result.add(new LinkedList(path));
        countTree(root.left,sum);
        countTree(root.right,sum);
        path.removeLast();
        return 0;
    }
}
