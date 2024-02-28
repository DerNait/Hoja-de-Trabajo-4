package src;

import java.util.ArrayList;

public class StackWithArray<T> implements IStack<T> {

    ArrayList<T> internalArray;

    public StackWithArray(int qty){
        internalArray = new ArrayList<T>(qty);
    }

    /**
     * The `count` function returns the size of an internal array.
     * 
     * @return The `count()` method is returning the size of the internal array.
     */
    @Override
    public int count() {
        return internalArray.size();
    }

    /**
     * This function checks if the internal array is empty and returns a boolean value accordingly.
     * 
     * @return The `isEmpty` method is returning a boolean value indicating whether the `internalArray`
     * is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return internalArray.isEmpty();
    }

    
    /**
     * The `push` function adds a value to an internal array in Java.
     * 
     * @param value The `push` method is used to add a new element to a data structure, typically a
     * stack. The `value` parameter represents the element that you want to add to the data structure.
     */
    @Override
    public void push(T value) {
        
            internalArray.add(value);
        
    }

    /**
     * This function removes and returns the last element from an internal array if it is not empty.
     * 
     * @return The `pop()` method is returning the last element (of type T) from the internalArray list
     * after removing it. If the internalArray is empty, it will return null.
     */
    @Override
    public T pop() {
        T tempValue = null;
        if (internalArray.size() > 0){
            tempValue = internalArray.remove(internalArray.size() - 1);
        }
        
        return tempValue;
    }

    /**
     * This function returns the last element in the internalArray, or null if the array is empty.
     * 
     * @return The `peek` method is returning the last element in the `internalArray` list, if the list
     * is not empty. If the list is empty, it will return `null`.
     */
    @Override
    public T peek() {
        T tempValue = null;
        if (internalArray.size() > 0){
            tempValue = internalArray.get(internalArray.size() - 1);
        }
        return tempValue;
    }
    
}