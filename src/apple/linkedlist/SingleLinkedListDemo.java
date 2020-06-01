package apple.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(4, "公孙胜", "入云龙");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addDirect(heroNode1);
        singleLinkedList.addDirect(heroNode2);
        singleLinkedList.addDirect(heroNode3);
        singleLinkedList.list();
        System.out.println("=======================================");
        HeroNode heroNode4 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode5 = new HeroNode(5, "关胜", "大刀");
        HeroNode heroNode50 = new HeroNode(5, "关胜", "小刀");
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode50);
        singleLinkedList.list();
        System.out.println("=======================================");
        singleLinkedList.update(heroNode5);
        singleLinkedList.list();
        System.out.println("=======================================");
        singleLinkedList.delete(5);
        singleLinkedList.list();
    }
}

class SingleLinkedList {

    //初始化一个头节点
    private HeroNode headNode = new HeroNode(0,"","");

    //添加节点
    public void addDirect (HeroNode heronode) {
        HeroNode temp = headNode;
        //遍历
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果到最后没有找到 将temp 后移
            temp = temp.next;
        }
        /**
         * 退出链表循环时
         * temp就指向了链表的最后
         * 将此节点指向新的节点
         */
        temp.next = heronode;
    }


    /**
     * 根据序号添加节点
     */
    public void addByOrder(HeroNode heroNode) {
        /**
         * 头部不能动，仍需要一个辅助节点
         */
        HeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
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
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    /**
     * 修改节点
     */
    public void update(HeroNode newHeroNode) {
        if (headNode.next == null) {
            System.out.println("========链表为空===========");
            return;
        }
        /**
         * 找到需要修改的节点
         */
        HeroNode temp = headNode.next;
        boolean flag = false;
        //判断是否找到了节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("========= Balabala not exits=========");
        }


    }


    /**
     * 删除节点
     */
    public void delete(int no) {
        HeroNode temp = headNode.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到前一个结点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("==========not exits===============");
        }
    }

    /**
     * 遍历节点
     */
    public void list() {
        //判断是否为空
        if (headNode.next == null) {
            System.out.printf("==========链表为空==============");
        }
        /**
         * 需要一个辅助节点来遍历
         */
        HeroNode temp = headNode.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }



}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }


}
