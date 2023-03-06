package uk.ac.rgu.cm2116;

public class Stack<T> implements AbstractStack<T>{

    @Override
    public boolean push(T element) throws StackOverflowException {
        return false;
    }

    @Override
    public T pop() throws StackUnderFlowException {
        return null;
    }

    @Override
    public T peek() throws StackUnderFlowException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty(){
        return (this.size() == 0);
    }
}
