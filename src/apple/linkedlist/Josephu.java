package apple.linkedlist;

/**
 *
 * 问题描述：设编号为 1,2，...n 的 n 个人围坐一圈，约定编号为 k （1<=k<=n）的人从1开始报数，
 * 数到 m 的那个人出列，它的下一位又从1开始报数，数到 m 的那个人又出列，
 * 以次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 *
 * 提示：用一个不带头节点的循环链表来处理约瑟夫环问题：
 * 先构成一个有 n个节点的单循环链表，然后由 k 节点起从 1 开始计数，计数到 m 时，
 * 对应节点从链表中删除，然后再从被删除节点的下一个节点又从1开始计数，
 * 直到最后一个节点从链表中删除结束
 *
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(123);
        circleSingleLinkedList.addBoy(124);
        circleSingleLinkedList.showboy();
    }


}

class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;
    //添加小孩子节点
    public void addBoy(int nums) {
        //做一个数据校验
        if (nums < 1) {
            System.out.println("========认真一点==========");
            return;
        }
        Boy curBoy = null;
        //使用 for 来创建
        for (int i = 0 ; i <= nums ; i++) {
            Boy boy = new Boy(i);
            //如果第一个小孩
            if (i == 0) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    public void showboy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("========孩子都跑了=========");
            return;
        }
        //因为 first
        Boy curBoy = first;
        while (true) {
            System.out.printf("===孩子的编号===",curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
