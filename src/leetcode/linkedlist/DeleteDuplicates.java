package leetcode.linkedlist;

public class DeleteDuplicates {
    public static void main(String[] args) {




    }
}


class Solution{
    private ListNode2 ListNode2 = new ListNode2(0);

    public ListNode2 deleteDuplicates(ListNode2 head) {
        //毫无疑问，我们应该先判断一下空这个事儿
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next:head;
    }


}


class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}