package janurary;

import utils.ListNode;

class MyLinkedList {
    private int length = 0;
    private ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length) return -1;
        ListNode node = head;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        head = new ListNode(val, head);
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length) return;
        if(index == length) {
            addAtTail(val);
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        ListNode node = head;
        for (int i = 1; i < index; i++)
            node = node.next;
        node.next = new ListNode(val, node.next);
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length) return;
        length--;
        if(index == 0) {
            head = head.next;
            return;
        }
        ListNode node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        if(index == length) node.next = null;
        else node.next = node.next.next;
    }
}

public class Solution707 {

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.addAtHead(1);
        System.out.println(mll.get(0));
        mll.addAtTail(3);
        System.out.println(mll.get(1));
        mll.addAtIndex(1,2);
        System.out.println(mll.get(1));
        mll.deleteAtIndex(1);
        System.out.println(mll.get(1));
    }
}
