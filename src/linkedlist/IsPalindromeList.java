package linkedlist;

import java.util.Stack;

/**
 * @author chicheng
 * @date 2020/8/9 10:42
 * @description 判断链表是否为回文结构
 */
public class IsPalindromeList {

    public static class Node {
        int value;
        Node next;

        public Node(int v) {
            this.value = v;
        }
    }
    // 寻找链表中间节点
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

    // 借助栈，快慢指针定位到链表中点，栈存放后半部分的数据，再从链表头开始遍历，进行比对
    public static boolean isPalindrome1(Node head) {
        Node mid = midOrUpMidNode(head);
        Stack<Integer> stack = new Stack<Integer>();
        while (mid != null) {
            stack.push(mid.value);
            mid = mid.next;
        }
        while (head != null) {
            if (!stack.isEmpty() && stack.pop() != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 中间节点指向null，右半部分元素逆序。两个指针反方向遍历比对
    public static boolean isPalindrome2(Node head) {
        Node n1 = midOrUpMidNode(head);
        Node n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // n1为右半部分的头结点
        n3 = n1;
        n2 = head;
        boolean flag = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                flag = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        // recover
        n1 = n3.next;
        n3.next = null;
        while (n1 != null)  {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return flag;
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        System.out.print(isPalindrome1(test) + "|");
        System.out.println(isPalindrome2(test));
        test = new Node(0);
        test.next = new Node(1);
        System.out.print(isPalindrome1(test) + "|");
        System.out.println(isPalindrome2(test));
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        System.out.print(isPalindrome1(test) + "|");
        System.out.println(isPalindrome2(test));
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(1);
        System.out.print(isPalindrome1(test) + "|");
        System.out.println(isPalindrome2(test));
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(1);
        test.next.next.next.next = new Node(0);
        System.out.print(isPalindrome1(test) + "|");
        System.out.println(isPalindrome2(test));
    }
}
