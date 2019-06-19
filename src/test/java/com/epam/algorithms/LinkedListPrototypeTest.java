package com.epam.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        Object o = new Object();
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

        Object o = new Object();
        Object o1 = new Object();

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

        rawLinkedListPrototype.addFirst(new Object());
        assertEquals(1, rawLinkedListPrototype.size());

        rawLinkedListPrototype.removeFirst();
        assertEquals(0, rawLinkedListPrototype.size());
    }

    @Test
    public void head() {
        assertNull(rawLinkedListPrototype.head());

        Object o = new Object();
        rawLinkedListPrototype.addFirst(o);
        assertEquals(o, rawLinkedListPrototype.head());

        Object o1 = new Object();
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
}