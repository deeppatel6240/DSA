package org.example.linkedlist;

// A Linked List Node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {

    Node head;

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
        LinkedList linkedList = new LinkedList();

        Node second;
        Node third;

        // Assign value values
        linkedList.head = new Node(1);
        second = new Node(22);
        third = new Node(3);

        // Connect nodes
        linkedList.head.next = second;
        second.next = third;

        linkedList.traverseLinkedList(linkedList.head);

    }
}
