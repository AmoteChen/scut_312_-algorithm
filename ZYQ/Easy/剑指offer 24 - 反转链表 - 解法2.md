### 剑指offer 24 - 反转链表 - 解法2

#### [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

巧妙的新解法：双指针。每次完成局部反转，不使用栈，时间复杂度O(n)，空间复杂度O(1).

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode curr = null;
        ListNode temp= null;
        while(pre != null){
            temp = pre.next;
            pre.next = curr;
            curr=pre;
            pre = temp;
        }
        return curr;
    }
}
```