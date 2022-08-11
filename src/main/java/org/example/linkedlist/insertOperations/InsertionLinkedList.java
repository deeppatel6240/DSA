package org.example.linkedlist.insertOperations;

// A complete working Java program to demonstrate all insertion methods on linked list

/* Linked list Node*/
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class InsertionLinkedList {
    Node head; // head of list

    /* Inserts a new Node at front of the list. */
    public void insertAtBegin(int data) {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        /* 3. Make next of new Node as head */
        newNode.next = head;

        /* 4. Move the head to point to new Node */
        head = newNode;
    }

    /* Inserts a new Node at given index of the list. */
    public void insertAtIndex(int data, int index) {

        /* 1 & 2: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        // Pointer which we traverse to given index
        Node pointer = head;

        // "i" used to reach given index
        int i = 0;
        while (i != index - 1) {
            pointer = pointer.next;
            i++;
        }

        // Make next of new Node as next of pointer
        newNode.next = pointer.next;

        // Make next of pointer as new Node
        pointer.next = newNode;
    }

    /* Appends a new node at the end. This method is
    defined inside LinkedList class shown above */
    public void insertAtEnd(int data) {
		/* 1. Allocate the Node &
		2. Put in the data
		3. Set next as null */
        Node newNode = new Node(data);

		/* 4. If the Linked List is empty, then make the
			new node as head */
        if (head == null) {
            head = newNode;
            return;
        }

        /* 4. Else traverse till the last node */
        Node pointer = head;
        while (pointer.next != null)
            pointer = pointer.next;

        /* 5. Change the next of last node */
        pointer.next = newNode;

        /* 6. This new node is going to be the last node, so
			make next of it as null */
        newNode.next = null;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node givenNode, int data) {
        /* 1. Check if the given Node is null */
        if (givenNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

		/* 2 & 3: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        /* 4. Make next of new Node as next of prev_node */
        newNode.next = givenNode.next;

        /* 5. make next of prev_node as new_node */
        givenNode.next = newNode;
    }

    public void insertBefore(Node givenNode, int data) {
        /* 1. Check if the given Node is null */
        if (givenNode == null) {
            System.out.println("Given Node is null so it's end of linked list so we are inserting at the end of linked list");
            insertAtEnd(data);
            return;
        }

        /* 2 & 3: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);

        Node pointer = head;
        while (pointer != givenNode) {
            if (pointer.next.data == givenNode.data) {
                newNode.next = pointer.next;
                pointer.next = newNode;
                return;
            }

            pointer = pointer.next;
        }
    }

    /* This function prints contents of linked list starting from
        the given node */
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
        /* Start with the empty list */
        InsertionLinkedList llist = new InsertionLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        llist.insertAtEnd(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NULL
        llist.insertAtBegin(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NULL
        llist.insertAtBegin(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NULL
        llist.insertAtEnd(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NULL
        llist.insertAfter(llist.head.next, 8);

        // Insert 21 at index 4. So linked list becomes
        // 1->7->8->6>21->4->NULL
        llist.insertAtIndex(21, 5); // can not insert into 0 index

        llist.insertBefore(llist.head.next.next.next.next.next, 98);

        System.out.println("Created Linked list is: ");
        llist.traverseLinkedList(llist.head);
    }
}