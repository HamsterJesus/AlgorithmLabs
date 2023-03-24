package uk.ac.rgu.cm2116;

import java.util.NoSuchElementException;

public class Queue<T> extends SoCQueue<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(){
        this.queue = new Object[5];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T e) throws IllegalStateException {
        int index = this.rear % this.queue.length;
        if(this.front == index && this.size != 0){
            throw new IllegalStateException("waahhh");
        }

        this.queue[index] = e;
        this.rear = this.rear+1;
        this.size = this.size+1;
        return true;
    }

    @Override
    public boolean offer(T e) {
        int index = this.rear % this.queue.length;
        if(this.front == index && this.size != 0){
            return false;
        }

        this.queue[index] = e;
        this.rear = this.rear+1;
        this.size = this.size+1;
        return true;
    }

    @Override
    public T remove() {
        if(this.size == 0){
            return null;
        }

        T element = (T) this.queue[this.front % this.queue.length];
        this.front = this.front + 1;
        this.size = this.size - 1;
        return element;
    }

    @Override
    public boolean isEmpty(){
        return (this.size() == 0);
    }

}
