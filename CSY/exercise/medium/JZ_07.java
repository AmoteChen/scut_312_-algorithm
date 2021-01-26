/***
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 输入：
 *
 * [3,9,20,15,7]
 * [9,3,15,20,7]
 *
 * 输出：
 *    TreeNode output
 *
 *    public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 *  *
 */


// 前序遍历：中左右 -> 用于判断根节点
// 中序遍历: 左中右 -> 用于判断左右子树


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

public class JZ_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }

        TreeNode result = new TreeNode(preorder[0]);



        int root = preorder[0];
        int rindex = 0;
//        TreeNode Left;
//        TreeNode Right;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                rindex = i;
            }
        }

        if(preorder.length == 1 && inorder.length == 1){
            return result;
        }

        int[] leftPreorder = new int[rindex];
        int[] leftInorder = new int[rindex];
        System.arraycopy(preorder, 1, leftPreorder, 0, rindex);
        System.arraycopy(inorder, 0, leftInorder, 0, rindex);

        int[] rightPreorder = new int [inorder.length - rindex - 1];
        int[] rightInorder  = new int [inorder.length - rindex - 1];
        System.arraycopy(preorder, leftPreorder.length+1, rightPreorder, 0, preorder.length -rindex - 1);
        System.arraycopy(inorder, rindex+1, rightInorder, 0, inorder.length -rindex - 1);

        result.left = buildTree(leftPreorder,leftInorder);
        result.right = buildTree(rightPreorder, rightInorder);

        return result;
    }

    public static void main(String[] args) {
        JZ_07 tester = new JZ_07();
        TreeNode result = tester.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }
}

/**
 * 本题是属于非常典型的递归解法
 * 重复的结构
 * 重复的工作
 * Map用来存储前序和中序遍历的序列 -> 快速找到序列指标/快速截取序列 -> 节省时间开销
 */
