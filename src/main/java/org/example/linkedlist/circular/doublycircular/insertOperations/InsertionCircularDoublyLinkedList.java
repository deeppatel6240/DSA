package org.example.linkedlist.circular.doublycircular.insertOperations;

class Node {
    int data;
    Node next;
    Node prev;

    Node (int d) {
        data = d;
    }
}

public class InsertionCircularDoublyLinkedList {

    Node head;

    /* Inserts a new Node at front of the list. */
    public void insertAtBegin(int data) {

        /* 1 & 2: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
            return;
        }

        Node pointer = head;

        while (pointer.next != head) {
            pointer = pointer.next;
        }

        /* 3. Make next of new node as head and previous as NULL */
        newNode.next = pointer.next;
        newNode.prev = pointer;

        /* 4. change prev of head node to new node and next of pointer to new node*/
        pointer.next = newNode;
        head.prev = newNode;

        /* 5. move the head to point to the new node */
        head = newNode;
    }

    public void traverseDoublyCircularLinkedList(Node head) {
        Node pointer = head;

        // printing node-data
        do {
            System.out.print(pointer.data + " " );
            pointer = pointer.next;
        } while (pointer != head);
    }

    public static void main(String[] args) {

        InsertionCircularDoublyLinkedList insertion = new InsertionCircularDoublyLinkedList();

        insertion.insertAtBegin(8);

        System.out.println("Created Linked list is: ");
        insertion.traverseDoublyCircularLinkedList(insertion.head);

    }
}
