package june;

public class MyCircularQueue {

    int capacity;
    int currSize = 0;
    Node head;
    Node tail;

    private static class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    public MyCircularQueue(int k) {
        capacity = k;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean enQueue(int value) {
        if (currSize == capacity)
            return false;
        Node node = new Node(value);
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        tail.prev = node;
        currSize++;
        return true;
    }

    public boolean deQueue() {
        if (currSize == 0)
            return false;
        head.next = head.next.next;
        head.next.prev = head;
        currSize--;
        return true;
    }

    public int Front() {
        return head.next.val;
    }

    public int Rear() {
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == capacity;
    }
}
