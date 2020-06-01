package apple.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        EroiNode eroiNode1 = new EroiNode(1, "宋江", "及时雨");
        EroiNode eroiNode2 = new EroiNode(2, "卢俊义", "玉麒麟");
        EroiNode eroiNode3 = new EroiNode(4, "公孙胜", "入云龙");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(eroiNode1);
        doubleLinkedList.add(eroiNode2);
        doubleLinkedList.add(eroiNode3);
        doubleLinkedList.list();
        System.out.println("=================================");
        EroiNode eroiNode4 = new EroiNode(3, "吴用", "智多星");
        doubleLinkedList.addByOrder(eroiNode4);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //初始化一个头节点
    private EroiNode headNode =new EroiNode(0,"","");

    public EroiNode getHead() {
        return headNode;
    }

    public void list() {
        if (headNode.next == null) {
            System.out.println("============链表为空===============");
            return;
        }

        //因为头节点不可移动，需要一个辅助变量
        EroiNode temp = headNode.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    public void add(EroiNode eroiNode) {
        EroiNode temp = headNode;
        //遍历
        while (true) {
            //到最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = eroiNode;
        eroiNode.pre = temp;
    }

    /**
     * 根据序号添加节点
     */
    public void addByOrder(EroiNode eroiNode) {
       /* EroiNode temp = eroiNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > eroiNode.no) {
                break;
            } else if (temp.next.no == eroiNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            //编号存在
            System.out.println("此Node已经存在了");
            return;
        } else {

        }*/
    }

}

class EroiNode {
    public int no;
    public String name;
    public String nickName;
    public EroiNode next;
    public EroiNode pre;

    public EroiNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "EroiNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
