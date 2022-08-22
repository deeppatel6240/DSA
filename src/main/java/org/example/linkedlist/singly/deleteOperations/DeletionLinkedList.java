package org.example.linkedlist.singly.deleteOperations;

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

    /* Delete a Node at end of the list. */
    public Node deleteAtEnd(Node head) {

        // if head is null then our linked list is empty
        if (head == null)
            return null;

        // taking 2 pointers to delete node at end of the list.
        Node pointer = head;
        Node temp = head.next;

        // loop until pointer will reach at second last and temp will reach at last element
        while (temp.next != null) {
            pointer = pointer.next;
            temp = temp.next;
        }

        // Make next of second last index as temp.next which is null so our last element will remove from the list.
        pointer.next = temp.next; // temp.next is null

        return head;
    }

    /* Delete a Node after give Node of the list. */
    public Node deleteAfter(Node head, Node givenNode) {

        // if head is null then our linked list is empty
        if (head == null && givenNode == null)
            return null;

        // Make next of givenNode as next of next of givenNode to remove after given Node in list.
        givenNode.next = givenNode.next.next;

        return head;
    }

    /* Delete a Node before give Node of the list. */
    public Node deleteBefore(Node head, Node givenNode) {

        // if head is null then our linked list is empty
        if (head == null)
            return null;

        // Maintaining 2 pointer to delete node before given node.
        Node pointer = head;
        Node temp = null; // we will assign value once while loop execute

        // loop until pointer is not null and next of pointer is not given node.
        while (pointer != null && pointer.next != givenNode) {
            temp = pointer; // Make temp as pointer
            pointer = pointer.next;
        }

        /*  if you try to remove before head then inside above while loop, pointer can point null.
            so we can not remove before head as there is no Node available before head.
            to ensure that we will return null in this case */
        if (pointer == null)
            return null;
        else if (pointer == head) /* in case your givenNode is directly linked to head then you have to remove head,
                                     so we make givenNode as head, so we can delete our actual head */
            head = givenNode;
        else
            temp.next = pointer.next; /* in any other cases, Once our while loop breaks, temp will point to node which index is 2 less than index of givenNode
                                      Lets say my linkedList is given below:

                                       8->9->11->7->2->NULL
                                       Lets say I want to remove Node before 2 [which is givenNode].
                                       (you need to remove node which contain data=7 and address of givenNode)

                                       in this case you can iterate while loop to check values of pointer and temp

                                       pointer will be at 7
                                       temp will at 11

                                       so in order to remove 7 you need to link temp to next of pointer (givenNode).

                                    */

        return head;
    }

    /* Delete a Node at give data in the list. */
    public Node deleteAtGivenKey(Node head, int data) {

        // if head is null then our linked list is empty
        if (head == null)
            return null;

        // Maintaining 2 pointer to delete node before given node.
        Node pointer = head;
        Node temp = head.next;

        // conditioning to ensure if you want to remove head node.
        if (pointer.data != data) {
            // loop until next of temp is not null and data of temp is not equal to data.
            while (temp.next != null && temp.data != data) {
                pointer = pointer.next;
                temp = temp.next;
            }
        } else
            // if we are trying to remove head then make head as next of head
            head = head.next;

        // if data of next of pointer equals to data then remove assign next of pointer as next of temp to remove node.
        if (pointer.next.data == data)
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

        head = new Node(8);
        second = new Node(9);
        third = new Node(11);
        fourth = new Node(7);
        fifth = new Node(2);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

//        head = llist.deleteAtBegin(head);
//        head = llist.deleteAtIndex(head, 1);
//        head = llist.deleteAtEnd(head);
//        head = llist.deleteAfter(head, head.next.next.next);
//        head = llist.deleteBefore(head, head.next.next.next.next.next);
        head = llist.deleteAtGivenKey(head, 2);

        System.out.println("Created Linked list is: ");
        llist.traverseLinkedList(head);
    }
}
