package com.epam.algorithms;

/**
 * NOT TESTED
 */
public class WierdQueue<T extends Comparable<? super T>> {

    private LinkedListPrototype<T> in = new LinkedListPrototype<>();
    private LinkedListPrototype<T> out = new LinkedListPrototype<>();

    public void addFirst(T value){
        in.addFirst(value);
    }

    public void removeLast(){
        if (out.head() == null) {
            while(in.head() != null){
                out.addFirst(in.head());
                in.removeFirst();
            }
        }
    }

    public int size(){
        return in.size() + out.size();
    }

    public T head(){
        return in.head();
    }

    public T tail(){
        return out.head();
    }

}
