package src;

import java.util.Vector;

public class StackWithVector<T> implements IStack<T> {

    private int index;
    Vector<T> internalVector;

    public StackWithVector(int qty){
        index = 0;
        internalVector = new Vector<T>(qty);
    }

    @Override
    public int count() {
        return internalVector.size();
    }

    @Override
    public boolean isEmpty() {
        return internalVector.isEmpty();
    }

    
    @Override
    public void push(T value) {
        
            internalVector.add(value);
        
    }

    @Override
    public T pop() {
        T tempValue = null;
        if (internalVector.size() > 0){
            tempValue = internalVector.remove(internalVector.size() - 1);
        }
        
        return tempValue;
    }

    @Override
    public T peek() {
        T tempValue = null;
        if (internalVector.size() > 0){
            tempValue = internalVector.get(internalVector.size() - 1);
        }
        return tempValue;
    }
    
}