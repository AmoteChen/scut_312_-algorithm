import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/***
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 */



public class JZ_06 {

    //成员内部类
    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }


    public int[] reversePrint(ListNode head) {
        List <Integer> result = new ArrayList<Integer>();
        ListNode temp = head;
        if (head == null){
            int [] result1={};
            return result1;
        }
        while(true){
            if(!String.valueOf(temp.val).equals("")){
            result.add(temp.val);}

            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        Collections.reverse(result);
        int[] output = result.stream().mapToInt(Integer::valueOf).toArray();
        return output;
    }

    public static void main(String[] args) {
        JZ_06 tester = new JZ_06();


        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);

        a.next = b;
        b.next = c;

        int [] result = tester.reversePrint(a);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }




    }
}
