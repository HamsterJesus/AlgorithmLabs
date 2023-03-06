package uk.ac.rgu.cm2116;

import java.util.NoSuchElementException;

public class Queue<T> extends SoCQueue<T> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(T e) throws IllegalStateException {
        return false;
    }

    @Override
    public boolean offer(T e) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean isEmpty(){
        return (this.size() == 0);
    }

}
