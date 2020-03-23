package com.ds.linkedlist;

/**
 * Node structure
 */
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }    
}

/**
 * FindMiddleNode
 */
public class FindMiddleNode {

    static void findMiddleElement(Node list) {
        Node fastPointer = list, slowPointer = list; 
        while(fastPointer.next!=null && fastPointer!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }  
        System.out.println("Middle Element:"+ slowPointer.data);
    }

    static void printList(Node list) {
        while(list!=null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = new Node(6);
        list.next.next.next.next.next.next = new Node(7);
        printList(list);
        findMiddleElement(list);
    }
}