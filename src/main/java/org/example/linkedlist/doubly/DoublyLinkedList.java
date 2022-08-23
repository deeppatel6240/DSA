package org.example.linkedlist.doubly;

class Node {
    int data;
    Node next;
    Node prev;

    Node (int d) {
        data = d;
    }
}

public class DoublyLinkedList {

    Node head;

    /* This function prints contents of linked list starting from
        the given node */
    public void traverseLinkedListInForward(Node head) {
        Node pointer = head;

        System.out.println("Traversal in forward Direction");
        // printing node-data
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
    }

    /* This function prints contents of linked list starting from
        the given node */
    public void traverseLinkedListInBackward(Node tail) {
        Node pointer = tail;

        System.out.println("Traversal in reverse direction");
        // printing node-data
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.prev;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        Node second;
        Node third;
        Node fourth;
        Node fifth;

        doublyLinkedList.head = new Node(8);
        second = new Node(9);
        third = new Node(11);
        fourth = new Node(7);
        fifth = new Node(2);

        doublyLinkedList.head.next = second;
        doublyLinkedList.head.prev = null;

        second.next = third;
        second.prev = doublyLinkedList.head;

        third.next = fourth;
        third.prev = second;

        fourth.next = fifth;
        fourth.prev = third;

        fifth.next = null;
        fifth.prev = fourth;

//        doublyLinkedList.traverseLinkedListInForward(doublyLinkedList.head);
        doublyLinkedList.traverseLinkedListInBackward(doublyLinkedList.head.next.next.next.next);
    }
}
