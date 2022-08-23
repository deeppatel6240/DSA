package org.example.linkedlist.doubly.deleteOperations;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
    }
}

public class DeletionDoublyLinkedList {

    public Node deleteAtBegin(Node head) {

        if (head == null)
            return null;

        head = head.next;
        head.prev = null;

        return head;
    }

    public Node deleteAtIndex(Node head, int index) {

        if (head == null)
            return null;

        Node pointer = head;
        Node temp = head.next;

        int i = 0;
        while (i != index - 1) {
            pointer = pointer.next;
            temp = temp.next;
            i++;
        }

        pointer.next = temp.next;
        temp.prev = pointer;

        return head;
    }

    public Node deleteAtEnd(Node head) {

        if (head == null)
            return null;

        Node pointer = head;

        while (pointer.next.next != null) {
            pointer = pointer.next;
        }

        pointer.next = pointer.next.next;

        return head;
    }

    public Node deleteAfter(Node head, Node givenNode) {

        if (head == null && givenNode == null)
            return null;

        givenNode.next = givenNode.next.next;

        if (givenNode.next != null)
            givenNode.next.prev = givenNode;

        return head;
    }

    public Node deleteBefore(Node head, Node givenNode) {

        if (head == null || givenNode == null)
            return null;

        if (head == givenNode.prev) {
            head = givenNode.prev.next;
            return head;
        }

        givenNode.prev = givenNode.prev.prev;

        if (givenNode.prev != null) {
            givenNode.prev.next = givenNode;
        }

        return head;
    }

    public Node deleteAtGivenKey(Node head, int data) {

        if (head == null)
            return null;

        Node pointer = head;
        Node temp = head.next;

        // if you are deleting head node then need to change head
        if (pointer.data != data) {
            while (temp.next != null && temp.data != data) {
                pointer = pointer.next;
                temp = temp.next;
            }
        }
        else {
            head = head.next;
            head.prev = null;
            return head;
        }

        if (temp.data == data && temp.next != null) { // to delete any node except last and first node of linked list
            pointer.next = temp.next;
            temp.next.prev = pointer;
        } else if (temp.data == data) { // to delete last node of linked list
            pointer.next = temp.next; // null
        }

        return head;
    }

    /* This function prints contents of linked list starting from
       the given node */
    public void traverseDoublyLinkedListInForward(Node head) {
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
    public void traverseDoublyLinkedListInBackward(Node tail) {
        Node pointer = tail;

        System.out.println("Traversal in reverse direction");
        // printing node-data
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.prev;
        }
    }

    public static void main(String[] args) {

        DeletionDoublyLinkedList deletion = new DeletionDoublyLinkedList();

        Node head;
        Node second;
        Node third;
        Node fourth;
        Node fifth;

        head = new Node(8);
        second = new Node(9);
        third = new Node(11);
        fourth = new Node(7);
        fifth = new Node(2);

        head.next = second;
        head.prev = null;

        second.next = third;
        second.prev = head;

        third.next = fourth;
        third.prev = second;

        fourth.next = fifth;
        fourth.prev = third;

        fifth.next = null;
        fifth.prev = fourth;

//        head = deletion.deleteAtBegin(head);
//        head = deletion.deleteAtIndex(head, 4);
//        head = deletion.deleteAtEnd(head);
//        head = deletion.deleteAfter(head, head.next.next.next);
//        head = deletion.deleteBefore(head, head.next.next.next.next);
        head = deletion.deleteAtGivenKey(head, 11);

        System.out.println("Created Linked list is: ");
        deletion.traverseDoublyLinkedListInForward(head);
    }
}
