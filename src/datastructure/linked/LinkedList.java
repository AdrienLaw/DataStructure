package datastructure.linked;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;

    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //链表的操作是找到插入的位置的前一个位置，然后互换指针
    //但是如果是放在第一个，之前的第一个没有比其更靠前的，所以插入操作分两种情况
    //nowadays 采用
    // 虚拟头结点

    public void  add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index ; i ++)
            prev = prev.next;
        /**
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        **/
        prev.next = new Node(e,prev.next);
        size ++;

    }
    //添加元素于链表头
    public void addFirst(E e){
        add(0,e);
    }

    //链表尾部添加元素 e
    public void addLast(E e){
        add(size,e);
    }


    //getter 方法
    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.e;
    }


    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表的第 index 个元素
    public void set(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否含有元素 e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;

    }


    //链表中删除第元素
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }


        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    //链表删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //链表删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null){
            builder.append(curr + " -> ");
            curr = curr.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
