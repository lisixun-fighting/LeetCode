package utils;


public class LinkedNode {
    private ListNode head;  // 首节点
    private int size;
    // 构造函数
    public LinkedNode(){
        head = new ListNode();
        size = 0;
    }
    private class ListNode {
        private int val;
        private ListNode next;
        // 一般节点的初始化
        public ListNode(int val){
            this.val = val;
            next = null;
        }
        // 头结点初始化
        public ListNode(){
            this.val = -1;
            this.next = null;
        }
    }

    // 增添首节点的方法
    public int addHead(int val){
        ListNode newHead = new ListNode(val);
        if (size == 0){
            head = newHead; // 如果链表还没有节点，新加入的节点就是首节点
        } else {
            newHead.next = head; // 若链表已经有首节点，先让新的节点指向原首节点
            head = newHead; // 再让新的节点成为首节点
        }
        size++;
        return val;
    }

    public int delHead(){
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public ListNode fineNode(int val){
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            if(val == current.val){
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }
}
