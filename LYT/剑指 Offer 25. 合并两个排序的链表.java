// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

// 示例1：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        ListNode head = new ListNode(0);
        ListNode p3 = head;
        while(l1!=null&&l2!=null)
        {
            if(l1.val>l2.val)
            {
                p3.next = l2;
                l2 = l2.next;
                p3 = p3.next;
            }
            else{
                p3.next = l1;
                l1 = l1.next;
                p3 = p3.next;
            }
        }
        while(l1!=null)
        {
            p3.next = l1;
            l1 = l1.next;
            p3 = p3.next;
        }
        while(l2!=null){
            p3.next = l2;
            l2 = l2.next;
            p3 = p3.next;
        }
        return head.next;

    }
}