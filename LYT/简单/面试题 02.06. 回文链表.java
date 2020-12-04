// 编写一个函数，检查输入的链表是否是回文的。
// 示例 1：
// 输入： 1->2
// 输出： false 
//方法一：使用了额外空间
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ArrayList<Integer> s = new ArrayList<>();
        while(head!=null)
        {
            s.add(head.val);
            head = head.next;
        }
        int len = s.size();
        int max = len -1;
        int min = 0;
        if(len==1)
            return true;
        for(int i=0;i<len/2;i++)
        {
            if(!s.get(min+i).equals(s.get(max-i)))
                return false;
        }
        return true;
}
}
//方法二：不使用额外空间，原地比较
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode midNode = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;

        while(curr2 != null){
            if(curr1.val != curr2.val) return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }

    /* 反转链表 */
    private ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    /* 快慢指针寻找中间节点 */
    private ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}