package linkedlist;

/**
 * @author chicheng
 * @date 2020/8/9 15:32
 * @description 带有random指针的链表克隆
 */
public class CopyListWithRandom {

    public static class Node {
        int value;
        Node next;
        Node random;

        public Node(int v) {
            this.value = v;
        }
    }

    public static Node copyListWithRandom (Node head) {
        Node next = null;
        Node index = head;
        while (index != null) {
            next = index.next;
            index.next = new Node(index.value);
            index.next.next = next;
            index = next;
        }
        index = head;
        while (index != null) {
            Node copyNode = index.next;
            copyNode.random = index.random;
            index = copyNode.next;
        }
        index = head;
        Node copyHead = head.next;
        while (index != null) {
            Node nextNode = index.next.next;
            Node copyNode  = index.next;
            index.next = nextNode;
            copyNode.next = nextNode != null ? nextNode.next : null;
            index = nextNode;
        }
        return copyHead;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print("value:" + node.value);
            if (node.random != null) {
                System.out.print("RandomValue:" + node.random.value + " ");
            } else {
                System.out.print("RandomValue:无" );
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       Node a = new Node(1);
       Node b = new Node(2);
       Node c = new Node(3);
       Node d = new Node(4);
       a.next = b;
       a.random = c;
       b.next = c;
       b.random = null;
       c.next = d;
       c.random = a;
       d.next = null;
       d.random = null;
       printLinkedList(a);
       Node head2 = copyListWithRandom(a);
       printLinkedList(head2);
    }
}
