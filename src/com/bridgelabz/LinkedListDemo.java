package com.bridgelabz;
import java.util.Scanner;

class Node {

    int data;
    Node next;

    //Parameterized Constructor to initialize Data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;
    Node tail;


    // Adding new nodes.
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        //Linked List is Empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
public void showList() {

    if(head == null) {
        System.out.println("Linked List is Empty.");
    } else {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
    }
}
}

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(70);
        linkedList.insertFirst(30);
        linkedList.insertFirst(56);
        linkedList.showList();

    }
}
