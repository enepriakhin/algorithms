package com.epam.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LinkedListPrototypeTest {

    private LinkedListPrototype rawLinkedListPrototype;
    private LinkedListPrototype<String> stringLinkedListPrototype;
    private LinkedListPrototype<Integer> integerLinkedListPrototype;

    @Before
    public void init() {
        rawLinkedListPrototype = new LinkedListPrototype();
        stringLinkedListPrototype = new LinkedListPrototype<>();
        integerLinkedListPrototype = new LinkedListPrototype<>();
    }

    @Test
    public void addFirst() {
        Date o = new Date();
        rawLinkedListPrototype.addFirst(o);
        assertEquals(o, rawLinkedListPrototype.head());
        String string = "asd";
        rawLinkedListPrototype.addFirst(string);
        assertEquals(string, rawLinkedListPrototype.head());
        Integer integer = 1;
        rawLinkedListPrototype.addFirst(integer);
        assertEquals(integer, rawLinkedListPrototype.head());

        stringLinkedListPrototype.addFirst(string);
        assertEquals(string, stringLinkedListPrototype.head());
    }

    @Test
    public void removeFirst() {
        assertNull(rawLinkedListPrototype.head());
        rawLinkedListPrototype.removeFirst();
        assertNull(rawLinkedListPrototype.head());

        Date o = new Date();
        Date o1 = new Date(100L);

        rawLinkedListPrototype.addFirst(o);
        rawLinkedListPrototype.addFirst(o1);

        rawLinkedListPrototype.removeFirst();
        assertEquals(o, rawLinkedListPrototype.head());

        rawLinkedListPrototype.removeFirst();
        assertNull(rawLinkedListPrototype.head());

    }

    @Test
    public void size() {
        assertEquals(0, rawLinkedListPrototype.size());

        rawLinkedListPrototype.removeFirst();
        assertEquals(0, rawLinkedListPrototype.size());

        rawLinkedListPrototype.addFirst(new Date());
        assertEquals(1, rawLinkedListPrototype.size());

        rawLinkedListPrototype.removeFirst();
        assertEquals(0, rawLinkedListPrototype.size());
    }

    @Test
    public void head() {
        assertNull(rawLinkedListPrototype.head());

        Date o = new Date();
        rawLinkedListPrototype.addFirst(o);
        assertEquals(o, rawLinkedListPrototype.head());

        Date o1 = new Date();
        rawLinkedListPrototype.addFirst(o1);
        assertEquals(o1, rawLinkedListPrototype.head());
    }

    @Test
    public void revert() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        integers.forEach(integerLinkedListPrototype::addFirst);
        integerLinkedListPrototype.revert();

        integers.forEach(i -> {
            assertEquals(i, integerLinkedListPrototype.head());
            integerLinkedListPrototype.removeFirst();
        });
    }

    @Test
    public void revertEmpty() {
        integerLinkedListPrototype.revert();
        assertNull(integerLinkedListPrototype.head());
    }

    @Test
    public void revertSingleElement() {
        integerLinkedListPrototype.addFirst(1);
        integerLinkedListPrototype.revert();

        assertEquals(Integer.valueOf(1), integerLinkedListPrototype.head());
    }

    @Test
    public void getMax() {
        assertNull(integerLinkedListPrototype.getMax());

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 5, 3, 5, 1));
        integers.forEach(integerLinkedListPrototype::addFirst);

        for (int i = integers.size() - 1; i >= 0; i--) {
            assertEquals(Collections.max(integers), integerLinkedListPrototype.getMax());
            integerLinkedListPrototype.removeFirst();
            integers.remove(i);
        }
    }
}