package org.example.linkedlist.doubly.insertOperations;

class Node {
    int data;
    Node next;
    Node prev;

    Node (int d) {
        data = d;
    }
}

public class InsertionDoublyLinkedList {

    Node head;

    /* Inserts a new Node at front of the list. */
    public void insertAtBegin(int data) {

        /* 1 & 2: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        /* 3. Make next of new node as head and previous as NULL */
        newNode.next = head;
        newNode.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = newNode;

        /* 5. move the head to point to the new node */
        head = newNode;
    }

    public void insertAtIndex(int data, int index) {
        /* 1 & 2: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        /* 3. Make next of new node as head and previous as NULL */
        Node pointer = head;

        int i = 0;
        while (i != index - 1) {
            pointer = pointer.next;
            i++;
        }

        newNode.next = pointer.next;
        newNode.prev = pointer;

        pointer.next = newNode;

        if(newNode.next != null) // to ensure that next of new node is not null
            newNode.next.prev = newNode;
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        Node pointer = head;

        /* 4. If the Linked List is empty, then make the
			new node as head */
        if (head == null) {
            head = newNode;
            return;
        }

        while (pointer.next != null) {
            pointer = pointer.next;
        }

        newNode.next = pointer.next; // null
        newNode.prev = pointer;

        pointer.next = newNode;
    }

    /* Inserts a new node after the given node. */
    public void insertAfter(int data, Node givenNode) {

        if (givenNode == null) {
            System.out.println("The given node cannot be null");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = givenNode.next;
        newNode.prev = givenNode;

        givenNode.next = newNode;

        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    public void insertBefore(int data, Node givenNode) {

        if (givenNode == null) {
            System.out.println("The given node cannot be null");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = givenNode;
        newNode.prev = givenNode.prev;

        givenNode.prev = newNode;

        if (newNode.prev != null)
            newNode.prev.next = newNode;
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

        InsertionDoublyLinkedList insertion = new InsertionDoublyLinkedList();

        insertion.insertAtEnd(123);
        insertion.insertAtBegin(7);
        insertion.insertAtBegin(6);
        insertion.insertAtIndex(11, 1); // not design for 0th element insertion
        insertion.insertAtIndex(12, 3);
        insertion.insertAtEnd(2);
        insertion.insertAfter(21, insertion.head);
        insertion.insertBefore(44, insertion.head.next.next.prev); // not design for 0th element insertion

        System.out.println("Created Linked list is: ");
        insertion.traverseDoublyLinkedListInForward(insertion.head);
    }
}
