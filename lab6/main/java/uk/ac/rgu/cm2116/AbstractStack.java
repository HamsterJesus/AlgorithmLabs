package uk.ac.rgu.cm2116;

public interface AbstractStack<T> {

    /**
     * Push the given element onto the stack
     * @param element
     * @return
     * @throws StackOverflowException
     */
    public boolean push(T element) throws StackOverflowException;

    /**
     * Pop from the stack
     * @return
     * @throws StackUnderFlowException
     */
    public T pop() throws StackUnderFlowException;

    /**
     * Examine the first element in the stack without popping it
     * @return
     * @throws StackUnderFlowException
     */
    public T peek() throws StackUnderFlowException;

    /**
     * Get the size of this stack
     * @return
     */
    public int size();

    /**
     * Is this stack empty?
     * @return
     */
    public boolean isEmpty();

    public static class StackOverflowException extends Exception{
        public StackOverflowException(String message){
            super(message);
        }
    }

    public static class StackUnderFlowException extends Exception{
        public StackUnderFlowException(String message){
            super(message);
        }
    } 
}
