package org.example.linkedlist.deleteOperations;

// A complete working Java program to demonstrate all deletion methods on linked list

/* Linked list Node*/
class Node {
    int data;
    Node next;

    Node (int d) {
        data = d;
        next = null;
    }
}

public class DeletionLinkedList {

    /* Delete a Node at front of the list. */
    public Node deleteAtBegin(Node head) {

        // if head is null then our linked list is empty
        if (head == null)
            return null;

        // Move the head pointer to the next node
        Node pointer = head;
        head = head.next;

        return head;
    }

    /* Delete a Node at given index of the list. */
    public Node deleteAtIndex(Node head, int index) {

        // if head is null then our linked list is empty
        if (head == null)
            return null;

        // taking 2 pointers to delete node at given index
        Node pointer = head;
        Node temp = head.next;

        int i = 0;
        while (i != index-1) {
            pointer = pointer.next;
            temp = temp.next;
            i++;
        }

        // Make next of pointer as next of temp to delete node
        pointer.next = temp.next;

        return head;
    }

    public void traverseLinkedList(Node head) {
        Node pointer = head;

        // printing node-data
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
    }

    /* Driver program to test above functions. Ideally this function
        should be in a separate user class. It is kept here to keep
        code compact */
    public static void main(String[] args) {

        DeletionLinkedList llist = new DeletionLinkedList();

        Node head;
        Node second;
        Node third;
        Node fourth;
        Node fifth;

        head = new Node(18);
        second = new Node(9);
        third = new Node(11);
        fourth = new Node(7);
        fifth = new Node(2);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        head = llist.deleteAtBegin(head);
        head = llist.deleteAtIndex(head, 2);

        System.out.println("Created Linked list is: ");
        llist.traverseLinkedList(head);

    }
}
