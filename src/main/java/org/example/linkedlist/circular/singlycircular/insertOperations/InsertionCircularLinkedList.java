package org.example.linkedlist.circular.singlycircular.insertOperations;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

public class InsertionCircularLinkedList {

    Node head;

    public void insertAtBegin(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node pointer = head;

        while (pointer.next != head) {
            pointer = pointer.next;
        }

        pointer.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtIndex(int data, int index) {

        Node newNode = new Node(data);
        int length = lengthOfLinkedList(head);

        Node pointer = head;

        if (index == 0) {
            insertAtBegin(data);
        } else if (index < length) {

            int i = 0;
            while (i != index - 1) {
                pointer = pointer.next;
                i++;
            }

            newNode.next = pointer.next;
            pointer.next = newNode;
        } else {
            System.out.println("Invalid Index to Insert");
        }
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node pointer = head;

        while (pointer.next != head) {
            pointer = pointer.next;
        }

        newNode.next = head;
        pointer.next = newNode;
    }

    public void insertAfter(Node givenNode, int data) {

        Node newNode = new Node(data);

        if (givenNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        newNode.next = givenNode.next;
        givenNode.next = newNode;
    }

    public void insertBefore(Node givenNode, int data) {

        Node newNode = new Node(data);

        if (givenNode == null) {
            System.out.println("Given Node is null so it's end of linked list so we are inserting at the end of linked list");
            insertAtEnd(data);
            return;
        }

        Node pointer = head;

        if (givenNode == head) {
            insertAtBegin(data);
            return;
        }

        while (pointer != givenNode) {
            if (pointer.next.data == givenNode.data) {
                newNode.next = pointer.next;
                pointer.next = newNode;
                return;
            }

            pointer = pointer.next;
        }
    }

    public void traverseCircularLinkedList(Node head) {
        Node pointer = head;

        do {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;

        } while (pointer != head);
    }

    public int lengthOfLinkedList(Node head) {
        Node pointer = head;

        int count = 0;

        do {
            count++;
            pointer = pointer.next;
        } while (pointer != head);

        return count;
    }

    public static void main(String[] args) {
        InsertionCircularLinkedList insertion = new InsertionCircularLinkedList();

        insertion.insertAtBegin(2);
        insertion.insertBefore(insertion.head, 99);
        insertion.insertAtEnd(442);
        insertion.insertAtBegin(12);
        insertion.insertAtIndex(23, 1);
        insertion.insertAtIndex(3,2);
        insertion.insertAtEnd(44);
        insertion.insertAfter(insertion.head, 121);
        insertion.insertBefore(insertion.head.next.next.next.next.next.next, 66);

        int length = insertion.lengthOfLinkedList(insertion.head);
        System.out.println("Length of LinkedList is: " + length);
        System.out.println("Created Linked list is: ");
        insertion.traverseCircularLinkedList(insertion.head);
    }
}
