package interview.linkedlist;

/**
 * 对 108 个英雄完成
 * 增删改查操作
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        //
        singleLinkedList.list();


    }
}

//定义一个 SingleLinkedList 管理英雄
class SingleLinkedList {
    //初始化一个头结点
    private HeroNode head = new HeroNode(0,"","");
    /**
     * 无脑 添加节点到单向链表
     * 当不考虑顺序
     * 找到最后一个节点，将此节点的next指向新节点
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //遍历
        while (true) {
            //
            if (temp.next == null) {
                break;
            }
            //如果没找到 temp 向下移动
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //显示链表
    public void list() {
        //判断链表是否空
        if (head.next == null) {
            System.out.println("=======链表为空=========");
            return;
        }
        //头结点不可动，需要一个辅助变量
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next后移,不然死循环
            temp = temp.next;
        }
    }

}

//定义 HeroNode 节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一个
    public HeroNode next;

    //构造器
    public HeroNode(int hNo,String hName,String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                 no + "："+
                ", name='" + name + '\'' +
                ", nickName='" + nickName  ;
    }
}

