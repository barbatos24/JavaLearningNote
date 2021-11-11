package com.russellzhou.javalearningnote.demo.SingleLinkedList;

public class BasicOperation {

    Node head = null; // 头节点

    /**
     * 向链表中插入数据
     * @param d
     */
    public void addNode(int d){
        Node newNode = new Node(d);
        if(head == null){
            head = newNode;
        }
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }


    /**
     * 删除第index个节点
     * @param index
     * @return
     */
    public boolean deleteNode(int index){
        if(index <1 || index>this.length()){
            return false;
        }
        int i=1;
        Node preNode = head;
        Node curNode = preNode.next;
        while(curNode != null){
            if(i == index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    public int length(){
        int length = 0;
        Node tmp = head;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 在不知道头指针的情况下删除指定节点
     * @param n
     * @return
     */
    public boolean deleteNodeNoHead(Node n){
        if(n == null || n.next == null){
            return false;
        }
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("删除成功");
        return true;
    }

    /**
     * 打印链表
     */
    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args){
        BasicOperation list = new BasicOperation();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
    }

}
