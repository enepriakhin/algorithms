package com.epam.algorithms;

public class LinkedListPrototype<T extends Comparable<? super T>> {

    private Node first;
    private int size;
    private LinkedListPrototype<T> maxValues;

    private LinkedListPrototype(Object o) {
    }

    public LinkedListPrototype() {
        this.maxValues = new LinkedListPrototype<>(new Object());
    }

    public void addFirst(T value) {
        Node newNode = new Node(value, first);
        size++;
        first = newNode;
        if (maxValues != null && (maxValues.head() == null || maxValues.head().compareTo(value) <= 0)) {
            maxValues.addFirst(value);
        }
    }

    public void removeFirst() {
        if (first != null) {
            if (maxValues!=null && this.head().equals(maxValues.head())) {
                maxValues.removeFirst();
            }
            first = first.next;
            size--;
        }
    }

    public T getMax() {
        return maxValues.head();
    }

    public int size() {
        return size;
    }

    public T head() {
        return first == null ? null : first.value;
    }

    public void revert() {
        Node current = first;
        Node previous = null;
        Node rememberedNext;
        while (current != null) {
            rememberedNext = current.next;
            current.next = previous;
            previous = current;
            current = rememberedNext;
        }
        first = previous;
    }

    private class Node {
        T value;
        Node next;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
