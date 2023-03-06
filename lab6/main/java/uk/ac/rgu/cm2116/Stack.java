package uk.ac.rgu.cm2116;

public class Stack<T> implements AbstractStack<T>{
    private Object[] stack;
    private int top;

    public Stack(){
        this.stack = new Object[10];
        this.top = -1;
    }

    @Override
    public boolean push(T element) throws StackOverflowException {
        if(this.top == (this.stack.length - 1)){
            throw new StackOverflowException("Whoopsie");
        }

        this.top = this.top -1;
        this.stack[this.top] = element;
        return true;
    }

    @Override
    public T pop() throws StackUnderFlowException {
        if(this.top < 0){
            throw new StackUnderFlowException("OOchie");
        }

        T element = (T) this.stack[this.top];
        this.stack[this.top] = null;

        this.top = this.top -1;
        return element;
    }

    @Override
    public T peek() throws StackUnderFlowException {
        if(this.top < 0){
            throw new StackUnderFlowException("uh oh spaghettio");
        }

        return (T) this.stack[this.top];
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean isEmpty(){
        return (this.size() == 0);
    }
}
