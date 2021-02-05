### 剑指 Offer 35. 复杂链表的复制

#### [剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

两种思路：

1. 哈希表，比较简单。将原链表的节点统一复制到一个map里面就行了。两次遍历

   ```java
   /*
   // Definition for a Node.
   class Node {
       int val;
       Node next;
       Node random;
   
       public Node(int val) {
           this.val = val;
           this.next = null;
           this.random = null;
       }
   }
   */
   class Solution {
       public Node copyRandomList(Node head) {
           if(head == null) return null;
           Map<Node,Node> map = new HashMap();
           Node curr  = head;
           // 将新链表的节点与旧链表的节点一一对应
           while(curr!=null){
               map.put(curr,new Node(curr.val));
               curr=curr.next;
           }
           curr = head;
           // 从哈希表中拿到新节点，并从哈希表中拿到next和random
           while(curr!=null){
               map.get(curr).next = map.get(curr.next);
               map.get(curr).random = map.get(curr.random);
               curr=curr.next;
           }
           return map.get(head);
   
       }
   }
   ```

   

2. 拼接与拆分：先将新链表节点拼接到原链表上，然后将random的值赋给新链表节点：

   注意：if(curr.random!=null)判断不可少。第三步：拆分原来的链表和新的链表。

   三次遍历，空间复杂度O(1)

```java
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // 第一步，拼接链表，1->2->3   变成  1->1->2->2->3->3
        while(curr !=null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = curr.next.next;
        }
        // 第二步，将random指针的位置确定下来。
        curr = head;
        while(curr!=null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr=curr.next.next;
        }
        // 第三步，拆分原链表和新链表。判断条件用curr.next != null  最后一步手动完成，避免NPE
        Node pre = head;
        curr = head.next;
        Node res = head.next;
        while(curr.next!=null){
            pre.next = pre.next.next;
            curr.next = curr.next.next;
            pre=pre.next;
            curr=curr.next;
        }
        pre.next = null;
        return res;
    }
}
```

