package org.example.linkedlist.circular.singlycircular;

class Node {
    int data;
    Node next;

    Node (int d) {
        data = d;
    }
}

public class CircularLinkedList {
    Node head;

    public void traverseCircularLinkedList(Node head) {
        Node pointer = head;

        // printing node-data
         do {
            System.out.print(pointer.data + " " );
            pointer = pointer.next;
        } while (pointer != head);
    }

    public static void main(String[] args) {

        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.head = new Node(8);
        Node second = new Node(9);
        Node third = new Node(11);
        Node fourth = new Node(7);
        Node fifth = new Node(2);

        circularLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = circularLinkedList.head;

        circularLinkedList.traverseCircularLinkedList(circularLinkedList.head);
    }
}
