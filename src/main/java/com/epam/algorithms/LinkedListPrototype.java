package com.epam.algorithms;

public class LinkedListPrototype<T> {

    private Node first;
    private int size;

    public void addFirst(T value){
        Node newNode = new Node(value, first);
        size++;
        first = newNode;
    }

    public void removeFirst(){
        if (first != null) {
            first = first.next;
            size--;
        }
    }

    public int size(){
        return size;
    }

    public T head(){
        return first == null ? null : first.value;
    }

    public void revert(){
        Node current = first;
        Node previous = null;
        Node next;
        while(current != null){
            next = current.next;
            current.next=previous;
            previous = current;
            current = next;
        }
    }

    private class Node{
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
