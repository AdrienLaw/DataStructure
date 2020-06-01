package leetcode.linkedlist;

public class FirstPublicNode {

    public static void main(String[] args) {

    }


        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = getLength(headA);
            int lengthB = getLength(headB);
            ListNode a =headA;
            ListNode b =headB;
            if (lengthA > lengthB) {
                for (int i = 0;i < lengthA - lengthB;i++) {
                    a = a.next;
                }
            } else {
                for (int i = 0;i < lengthB - lengthA;i++) {
                    a = a.next;
                    b = b.next;
                }
            }
            return a;
        }
        public int getLength(ListNode head) {
            int length = 0;
            for (ListNode temp = head;temp != null ; temp = temp.next,length ++);
            return length;
        }

}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }