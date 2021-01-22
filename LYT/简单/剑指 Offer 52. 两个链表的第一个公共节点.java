// 输入两个链表，找出它们的第一个公共节点。
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
// 输出：Reference of the node with value = 8
// 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a  = headA;
        ListNode b = headB;
        int countA = 0;
        int countB = 0;
        while(a!=null)
        {
            a=a.next;
            countA++;
        }
        while(b!=null){
            b = b.next;
            countB++;
        }
        if(countA>countB)
        {
            int c = countA-countB;
            while(c!=0)
            {
                headA=headA.next;
                c--;
            }
        }
        if(countA<countB){
            int c = countB-countA;
            while(c!=0)
            {
                headB=headB.next;
                c--;
            }
        }
        while(headA!=null)
        {
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}