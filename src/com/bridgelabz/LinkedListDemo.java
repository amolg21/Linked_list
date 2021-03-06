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

        if (head == null) {
            System.out.println("Linked List is Empty.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
        }
    }

    // Adding new value from last.
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertafter(int data, int newdata) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            Node nextNode;
            while (temp != null) {
                nextNode = temp.next;
                if (temp.data == newdata) {
                    temp.next = newNode;
                    newNode.next = nextNode;
                }
                temp = temp.next;
            }
        }
    }

    //Delete first node from Linked List
    public void pop() {
        if (head == null) {
            System.out.println("Linked List is Empty.");
        } else {
            head = head.next;
        }
    }

    public void popLast() {
        if (head == null) {
            System.out.println("Linked List is Empty.");
        } else {
            Node second_last = head;
            // Created an extra space secondLast, and traverse the linked list till the second last node and set the value of the next second-last node to null..
            // delete the last node, i.e. the next node of the second last node
            while (second_last.next.next != null) second_last = second_last.next;

            // Change next of second last
            second_last.next = null;
        }
    }

    public boolean search(Node head, int x) {
        Node current = head;    //Initialize current
        while (current != null) {
            if (current.data == x)
                return true;
            current = current.next;

        }
        return false;  //data not found

    }

    //Delete specific Node
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("Linked List is Empty.");
        } else {
            if (data == head.data) {
                head = head.next;
            } else {
                Node prevNode = head;
                Node temp = head.next;
                while (prevNode != null) {
                    if (temp.data == data) {
                        prevNode.next = temp.next;
                    }
                    prevNode = prevNode.next;
                    temp = temp.next;
                }
            }
        }
    }

}


public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //    linkedList.insertFirst(70);
        //  linkedList.insertFirst(30);
        //linkedList.insertFirst(56);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n 1.Insert Data from Start \n 2.Insert Data from last \n 3.Show Linked List " +
                    "\n 4. Insert data at random position \n 5. Delete first node \n 6. Delete last node" +
                    " \n 7. Search node \n Delete Specific Node \n 9.Quit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number");
                    int firstNumber = sc.nextInt();
                    linkedList.insertFirst(firstNumber);
                    break;
                case 2:
                    System.out.println("Enter the number");
                    int lastNumber = sc.nextInt();
                    linkedList.insertLast(lastNumber);
                    break;
                case 3:
                    linkedList.showList();
                    break;

                case 4:
                    System.out.println("Enter the number after which you want to add the new number ");
                    int data = sc.nextInt();
                    System.out.println("Enter the New number ");
                    int newData = sc.nextInt();
                    linkedList.insertafter(data, newData);
                    break;

                case 5:
                    linkedList.pop();
                    break;

                case 6:
                    linkedList.popLast();
                    break;

                case 7:
                    System.out.println("Enter the number ");
                    int searchNumber = sc.nextInt();
                    if (linkedList.search(linkedList.head, searchNumber)) {
                        System.out.println(" \n Yes. Element is Found");
                    } else
                        System.out.println("\n No. Element is not found");
                    break;

                case 8:
                    System.out.println("Enter the number which you want to Delete ");
                    int removeNumber = sc.nextInt();
                    linkedList.deleteNode(removeNumber);
                    break;

                case 9:
                    System.out.println("Thank you");
                    break;
            }
        } while (choice != 4);
        linkedList.showList();

    }
}
