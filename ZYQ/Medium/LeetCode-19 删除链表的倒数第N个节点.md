LeetCode-19 删除链表的倒数第N个节点

#### [19. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = new ListNode(0,head);
        int count=0;
        while(count<n && fast!=null){
            fast=fast.next;
            count++;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        if(slow.next!=null){
            if(slow.next == head) head=head.next;
            else slow.next = slow.next.next;
        }
        return head;
        
    }
}
```

链表的中等题确实容易AC。直接双指针法，快慢指针就行了。

千万注意考虑边界条件。比如 [1] n=1 的时候。当要删除的节点是头节点时，应当把头节点设置为head.next。