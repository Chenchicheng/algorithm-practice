package linkedlist;

/**
 * @author chicheng
 * @date 2020/8/9 9:24
 * @description 寻找单链表的中间节点
 */
public class LinkedListMid {

    public static class Node {
        int value;
        Node next;

        public Node(int v) {
            this.value = v;
        }
    }

    // 奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 奇数长度返回中点的前一个，偶数长度返回上中点的前一个
    public static Node midPreOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 奇数长度返回中点的前一个，偶数长度返回下中点的前一个
    public static Node midPreOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);
        test.next.next.next.next.next.next.next.next.next = new Node(9);
        Node res = midOrUpMidNode(test);
        System.out.println(res.value);
        res = midOrDownMidNode(test);
        System.out.println(res.value);
        res = midPreOrUpMidPreNode(test);
        System.out.println(res.value);
        res = midPreOrDownMidPreNode(test);
        System.out.println(res.value);
    }
}
