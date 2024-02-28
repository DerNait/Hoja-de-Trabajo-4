package src;

public class StackWithDoubleList<T> implements IStack<T> {

    /*
     * Se le pidio a la IA: Con base a mi interfaz IList crea la implementacion de una Lista simplemente encadenada
     */

    private DoubleLinkedList<T> list;

    public StackWithDoubleList() {
        list = new DoubleLinkedList<>();
    }

    /**
     * The `push` function adds a value to the end of a list.
     * 
     * @param value The `value` parameter represents the element that you want to add to the list when
     * the `push` method is called.
     */
    @Override
    public void push(T value) {
        list.add(value);
    }

    /**
     * This function removes and returns the last element from a list if the list is not empty.
     * 
     * @return The `pop()` method is returning the last element of the list, which is removed from the
     * list before being returned. If the list is empty, it returns `null`.
     */
    @Override
    public T pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    /**
     * The `peek` function in Java returns the last element of a list if it is not empty.
     * 
     * @return The `peek()` method is returning the last element in the list, or `null` if the list is
     * empty.
     */
    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    /**
     * The `count` function returns the size of an internal array.
     * 
     * @return The `count()` method is returning the size of the internal array.
     */
    @Override
    public int count() {
        return list.size();
    }

    /**
     * This function checks if the internal array is empty and returns a boolean value accordingly.
     * 
     * @return The `isEmpty` method is returning a boolean value indicating whether the `internalArray`
     * is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
