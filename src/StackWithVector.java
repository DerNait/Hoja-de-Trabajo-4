package src;

import java.util.Vector;

public class StackWithVector<T> implements IStack<T> {

    private int index;
    Vector<T> internalVector;

    public StackWithVector(int qty){
        index = 0;
        internalVector = new Vector<T>(qty);
    }

    /**
     * The count() function returns the size of the internalVector.
     * 
     * @return The `count()` method is returning the size of the `internalVector`, which represents the
     * number of elements in the vector.
     */
    @Override
    public int count() {
        return internalVector.size();
    }

    /**
     * The `isEmpty` function in Java checks if an internal vector is empty and returns a boolean value
     * accordingly.
     * 
     * @return The `isEmpty()` method is returning a boolean value indicating whether the internal
     * vector is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return internalVector.isEmpty();
    }

    
    /**
     * The `push` function adds a value to an internal vector in Java.
     * 
     * @param value The `push` method is used to add an element to a collection. In this case, the
     * method is adding a value of type `T` to an internal vector.
     */
    @Override
    public void push(T value) {
        
            internalVector.add(value);
        
    }

    /**
     * This function removes and returns the last element from a vector if it is not empty.
     * 
     * @return The method is returning the value that was removed from the end of the internalVector,
     * or null if the internalVector is empty.
     */
    @Override
    public T pop() {
        T tempValue = null;
        if (internalVector.size() > 0){
            tempValue = internalVector.remove(internalVector.size() - 1);
        }
        
        return tempValue;
    }

    /**
     * This function returns the last element in a vector without removing it.
     * 
     * @return The `peek` method is returning the element at the top of the stack without removing it.
     */
    @Override
    public T peek() {
        T tempValue = null;
        if (internalVector.size() > 0){
            tempValue = internalVector.get(internalVector.size() - 1);
        }
        return tempValue;
    }
    
}