package org.example.linkedlist.circular.singlycircular.deleteOperations;

class Node {
    int data;
    Node next;

    Node (int d) {
        data = d;
    }
}

public class DeletionCircularLinkedList {

    public Node deleteAtBegin (Node head) {

        if (head == null)
            return null;

        Node pointer = head;

        while (pointer.next != head) {
            pointer = pointer.next;
        }

        head = head.next;
        pointer.next = head;

        return head;
    }

    public Node deleteAtIndex (Node head, int index) {

        if (head == null)
            return null;

        int length = lengthOfLinkedList(head);
        Node pointer = head;
        Node temp = head.next;

        if (index == 0) {
            head = deleteAtBegin(head);
        } else if (index < length) {
            int i = 0;
            while (i != index - 1) {
                pointer = pointer.next;
                temp = temp.next;
                i++;
            }
            pointer.next = temp.next;
        } else {
            System.out.println("Invalid Index to Delete");
        }

        return head;
    }

    public Node deleteAtEnd(Node head) {

        if (head == null)
            return null;

        Node pointer = head;
        Node temp = head.next;

        while (temp.next != head) {
            pointer = pointer.next;
            temp = temp.next;
        }

        pointer.next = temp.next;

        return head;
    }

    public Node deleteAfter(Node head, Node givenNode) {

        if (head == null && givenNode == null)
            return null;

        // for removing node after last node in circular linked list
        if (givenNode.next == head) {
            head = head.next;
            givenNode.next = head;
            return head;
        }

        givenNode.next = givenNode.next.next;

        return head;
    }

    public Node deleteBefore(Node head, Node givenNode) {

        if (head == null && givenNode == null)
            return null;

        Node pointer = head;
        Node temp = null;

        while (pointer.next != givenNode) {
            temp = pointer;
            pointer = pointer.next;
        }

        if (givenNode == head.next) {
            head = deleteAtBegin(head);
        } else {
            temp.next = pointer.next;
        }

        return head;
    }

    public Node deleteAtGivenKey(Node head, int data) {

        if (head == null)
            return null;

        Node pointer = head;
        Node temp = head.next;

        if (temp.next != head && pointer.data != data) {
            while (temp.data != data ) {
                pointer = pointer.next;
                temp = temp.next;
            }
        } else {
            head = deleteAtBegin(head);
        }

        if (pointer.next.data == data)
            pointer.next = temp.next;

        return head;
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

        DeletionCircularLinkedList deletion = new DeletionCircularLinkedList();

        Node head;
        Node second;
        Node third;
        Node fourth;
        Node fifth;

        head = new Node(8);
        second = new Node(11);
        third = new Node(11);
        fourth = new Node(11);
        fifth = new Node(2);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = head;

//        head = deletion.deleteAtBegin(head);
//        head = deletion.deleteAtIndex(head, 5);
//        head = deletion.deleteAtEnd(head);
//        head = deletion.deleteAfter(head, head.next.next.next);
//        head = deletion.deleteAtGivenKey(head, 8);
        head = deletion.deleteBefore(head, head.next.next.next.next.next);

        System.out.println("The Length of Linked List is: " + deletion.lengthOfLinkedList(head));
        System.out.println("Created Linked list is: ");
        deletion.traverseCircularLinkedList(head);
    }
}
