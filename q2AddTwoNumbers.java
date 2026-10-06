import java.util.*;

public class q2AddTwoNumbers {

    public static Node add(Node a, Node b) {
        Node head = new Node(0);
        Node temp = head;
        int carry = 0;

        while (a != null || b != null || carry != 0) {
            int sum = carry;

            if (a != null) {
                sum += a.val;
                a = a.next;
            }
            if (b != null) {
                sum += b.val;
                b = b.next;
            }

            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return head.next;
    }

    static Node readList(Scanner sc, String name) {
        System.out.print("Enter size of " + name + ": ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " digits of " + name + ":");

        Node head = new Node(0);
        Node temp = head;
        for (int i = 0; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        return head.next;
    }

    static void printList(Node head) {
        System.out.print("Output: [");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(",");
            head = head.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node a = readList(sc, "a");
        Node b = readList(sc, "b");

        Node ans = add(a, b);
        printList(ans);

        sc.close();
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}