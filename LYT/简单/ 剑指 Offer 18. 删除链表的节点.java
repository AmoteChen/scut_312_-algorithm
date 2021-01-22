// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

// 返回删除后的链表的头节点。
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val)
            return head.next;
        ListNode a = head;
        while(a!=null)
        {
            if(a.next.val==val)
            {
                a.next = a.next.next;
                return head;
            }
            a = a.next;
        }
        return null;
    }
}