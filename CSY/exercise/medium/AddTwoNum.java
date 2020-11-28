/***
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */



public class AddTwoNum {


    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /***
         * 几个比较恶心人的点：
         * 1.递归肯定没跑的
         * 2.进位操作
         * 3.两个链表不齐，尤其是进位的时候可能会变很多东西
         */


        //如果两个链表后面都还有的时候
        if(l1.next!=null&&l2.next!=null){
            ListNode result = new ListNode(0);
            int temp = l1.val+l2.val;
            //进位？
            if(temp<10){
                result.val = result.val +l1.val+l2.val;
                result.next = addTwoNumbers(l1.next,l2.next);
            }else {
            result.val = (l1.val+l2.val)%10;
            result.next = addTwoNumbers(l1.next,l2.next);
            result.next= addTwoNumbers(result.next,new ListNode(1));
            }
            return result;
        }
        if(l1.next!=null&&l2.next==null){
            ListNode result = new ListNode(0);
            int temp = l1.val+l2.val;
            if(temp<10){
                result.val = result.val +l1.val+l2.val;
                result.next = l1.next;
            }else {
                result.val = (l1.val+l2.val)%10;
                result.next = l1.next;
                result.next= addTwoNumbers(result.next,new ListNode(1));
            }
            return result;
        }
        if(l1.next==null&&l2.next!=null){
            ListNode result = new ListNode(0);
            int temp = l1.val+l2.val;
            if(temp<10){
                result.val = result.val +l1.val+l2.val;
                result.next = l2.next;
            }else {
                result.val = (l1.val+l2.val)%10;
                result.next = l2.next;
                result.next= addTwoNumbers(result.next,new ListNode(1));
            }
            return result;
        }
        if(l1.next==null&&l2.next==null){
            ListNode result = new ListNode(0);

            int temp = l1.val+l2.val;
            if(temp<10){
                result.val = result.val +l1.val+l2.val;
            }else {
                result.val = (l1.val+l2.val)%10;
                result.next = new ListNode(1);
            }


            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode test2 = new ListNode(9);
        ListNode testA = new ListNode(9,test2);
        ListNode testC = new ListNode(9,testA);
        ListNode testD = new ListNode(9,testC);
        ListNode testDD = new ListNode(9,testD);
        ListNode testCDD = new ListNode(9,testDD);
        ListNode testCDDD = new ListNode(9,testCDD);



        ListNode test3 = new ListNode(5);
        ListNode testB = new ListNode(5,test3);

        AddTwoNum tester = new AddTwoNum();
        ListNode result = tester.addTwoNumbers(testCDDD,testD);


        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.next.next.next);









    }
}
