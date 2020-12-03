### Leetcode-147 对链表进行插入排序

#### [147. 对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/)

思路和注意点：普通的插入排序。用一个哑结点更好。

1. 特判在这道题中不能少。判断头节点是否为空，如果为空，直接返回，不排序。
2. 创建哑节点dummy，便于之后在head前面插入节点
3. 维护一个lastSorted为链表的已排序部分的最后一个节点。初始lastSorted = head。
4. 维护curr，指向当前待插入的元素
5. 关键：比较curr和lastSorted的值 若curr的值更大，则curr应当位于last之后，把两个都进一位即可。若last更大，则需要在head到last之间的位置（包括head但不包括last）找到curr的位置。
6. 我们用一个prev来找到curr应该插入的位置的前一个节点。初始prev=dummy（这就是dummy的作用和好处，便于对比，即使curr的值小于head的值，也可以在头结点前面插入）
7. 插入过程建议尽量先脑补，或者画图理解。 Mind Palace.

```java
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if(curr.val>=lastSorted.val){
                curr=curr.next;
                lastSorted=lastSorted.next;
            }
            else{
                ListNode prev=dummyHead;
                while(prev.next.val<curr.val){
                    prev=prev.next;
                }
                lastSorted.next = curr.next;
                curr.next=prev.next;
                prev.next=curr;
                curr=lastSorted.next;
            }
        }
        return dummyHead.next;
    }
}
```

