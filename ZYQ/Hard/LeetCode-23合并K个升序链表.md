### LeetCode-23合并K个升序链表

#### [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

归并排序实现：参数：待递归的数组，左边界low，右边界high

1. 递归出口
2. 计算mid
3. 递归地归并左边右边
4. 调用mergerTwo归并左右的结果

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length<=0) return null;
        ListNode result = mergeLists(lists,0,lists.length-1);
        return result;
    }
    public ListNode mergeLists(ListNode[] list,int l,int r){
        if(l==r){
            return list[l];
        }
        int mid = l+(r-l)/2;// l+(r-l)>>1 会栈溢出，因为>>的优先级是很低的，比+还低。
        ListNode l1 = mergeLists(list,l,mid);
        ListNode l2 = mergeLists(list,mid+1,r);
        ListNode res = mergeTwoLists(l1,l2);
        return res;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(-1);
        ListNode pointResult = resultHead;
        ListNode pointL1=l1;
        ListNode pointL2=l2;
        while(pointL1!=null&&pointL2!=null){
            if(pointL1.val<=pointL2.val){
                pointResult.next = pointL1;
                pointL1=pointL1.next;
            }
            else{
                pointResult.next=pointL2;
                pointL2=pointL2.next;
            }
            pointResult=pointResult.next;
        }
        pointResult.next = pointL1==null?pointL2:pointL1;
        return resultHead.next;
    }
}
```

