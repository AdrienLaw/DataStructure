package apple.linkedlist;

public class SingleLinkedListDemo {
/*    public static void main(String[] args) {
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
        HeroNode heroNode34 = new HeroNode(34, "解珍", "两头蛇");
        HeroNode heroNode11 = new HeroNode(11, "李应", "扑天雕");
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode50);
        singleLinkedList.addByOrder(heroNode34);
        singleLinkedList.addByOrder(heroNode11);
        singleLinkedList.list();
        System.out.println("=======================================");
        singleLinkedList.update(heroNode5);
        singleLinkedList.list();
        System.out.println("=======================================");
        singleLinkedList.delete(5);
        singleLinkedList.list();

        System.out.println("=======================================");
        int length = singleLinkedList.getLength(heroNode3);
        singleLinkedList.list();
        System.out.println("============="+length);
        System.out.println("=======================================");
        HeroNode heroNode = singleLinkedList.lastIndexNode(heroNode1, 4);
        System.out.println(heroNode);
        System.out.println("=======================================");
        singleLinkedList.reverseLinkedList(heroNode);
        singleLinkedList.list();
    }*/


    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode heroNode4 = new HeroNode(3, "吴用", "智多星");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode4);
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

            /**
             * 第一次 56 - 57 - 71
             * 再后来 （56 - 60） * n - 56 - 57 - 72
             */
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
            //没没到最后 执行这个 再跳到 113
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                //编号存在了
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

    public int getLength(HeroNode heroNode) {
        if (headNode.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode curr = headNode.next;
        while (curr != null) {
            length ++;
            curr = curr.next;
        }
        return length;
    }

    /**
     * 查找倒数第 K 个节点
     */
    public HeroNode lastIndexNode(HeroNode headNode,int index) {
        //如果链表是空心
        if (headNode.next == null) {
            return null;
        }
        //第一遍得到链表的长度
        int size = getLength(headNode);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode curr = headNode.next;
        for (int i = 1;i < size - index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    //反转链表
    public void reverseLinkedList(HeroNode headNode) {
        if (headNode.next == null || headNode.next.next == null) {
            //一个或空
            return;
        }
        HeroNode curr = headNode.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (curr != null) {
            next = curr.next;
            curr.next = reverseHead.next;
            reverseHead.next = curr;
            curr = next;
        }
        headNode.next = reverseHead.next;
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

