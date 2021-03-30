package com.david.vella.algorithms;

public class SumOfLinkedList {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * You're given two Linked Lists of potentially unequal length. Each Linked List
     * represents a non-negative integer, where each node in the Linked List is a
     * digit of that integer, and the first node in each Linked List always
     * represents the least significant digit of the integer. Write a function that
     * returns the head of a new Linked List that represents the sum of the integers
     * represented by the two input Linked Lists.
     */
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList newLinkedList = new LinkedList(0);
        LinkedList currentNode = newLinkedList;

        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != null || nodeTwo != null || carry != 0){
            int num1 = nodeOne != null ? nodeOne.value : 0;
            int num2 = nodeTwo != null ? nodeTwo.value : 0;

            int sumOfValues = num1 + num2 + carry;
            int newValue = sumOfValues % 10;
            carry = sumOfValues / 10;

            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;

            currentNode = newNode;

            nodeOne = nodeOne != null ? nodeOne.next : null;
            nodeTwo = nodeTwo != null ? nodeTwo.next : null;
        }

        return newLinkedList.next;
    }


}
