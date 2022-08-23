package org.example.linkedlist.circular.doublycircular;

class Node {
    int data;
    Node next;
    Node prev;

    Node (int d) {
        data = d;
    }
}

public class CircularDoublyLinkedList {

    Node head;

    public void traverseDoublyCircularLinkedList(Node head) {
        Node pointer = head;

        // printing node-data
        do {
            System.out.print(pointer.data + " " );
            pointer = pointer.next;
        } while (pointer != head);
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();

        Node second;
        Node third;
        Node fourth;
        Node fifth;

        circularDoublyLinkedList.head = new Node(8);
        second = new Node(9);
        third = new Node(11);
        fourth = new Node(7);
        fifth = new Node(2);

        circularDoublyLinkedList.head.next = second;
        circularDoublyLinkedList.head.prev = fifth;

        second.next = third;
        second.prev = circularDoublyLinkedList.head;

        third.next = fourth;
        third.prev = second;

        fourth.next = fifth;
        fourth.prev = third;

        fifth.next = circularDoublyLinkedList.head;
        fifth.prev = fourth;

        circularDoublyLinkedList.traverseDoublyCircularLinkedList(circularDoublyLinkedList.head);
    }
}
