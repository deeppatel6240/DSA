package org.example.linkedlist.one;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class One {
    // iterative approach
    public Node reverseLinkedList(Node head) {

        if (head == null)
            return null;

        Node pointer = head;
        Node prev = null;
        Node next;

        while (pointer != null) {
            next = pointer.next; // before braking chain store next of pointer node in some node (next) so we have next element after braking chain
            pointer.next = prev; // make next of pointer as prev
            prev = pointer; // make prev as pointer
            pointer = next; // move pointer ahead
        }
        head = prev; // make head as prev which is now our first element of the linked list

        return head;
    }

    // recursive approach
    public Node reverseLinkedListRecursive(Node head) {

        if (head == null || head.next == null)
            return head;

        Node restChain = reverseLinkedListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return restChain;
    }

    // traverse every element in linked list
    public void traverseLinkedList(Node head) {

        Node pointer = head;

        // printing node-data
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
    }

    public static void main(String[] args) {
        One linkedList = new One();

        Node head;
        Node second;
        Node third;
        Node fourth;
        Node fifth;

        // Assign value values
        head = new Node(1);
        second = new Node(22);
        third = new Node(3);
        fourth = new Node(19);
        fifth = new Node(54);

        // Connect nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        linkedList.traverseLinkedList(head);

        System.out.println();
        System.out.println("reversed linked list is: ");
        head = linkedList.reverseLinkedListRecursive(head);
        linkedList.traverseLinkedList(head);
    }
}
