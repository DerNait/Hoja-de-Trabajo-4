package src;

public class StackWithSingleList<T> implements IStack<T> {
    private SingleLinkedList<T> list;

    public StackWithSingleList() {
        list = new SingleLinkedList<>();
    }

    /**
     * The `push` function adds a value to the end of a list.
     * 
     * @param value The `push` method is used to add a new element to the top of a stack. The `value`
     * parameter represents the element that you want to add to the stack.
     */
    @Override
    public void push(T value) {
        list.add(value);
    }

    /**
     * This function removes and returns the last element from a list if the list is not empty.
     * 
     * @return The `pop()` method is returning the element that is removed from the end of the list. If
     * the list is empty, it returns `null`.
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
     * The `count` function returns the size of a list.
     * 
     * @return The `count()` method is returning the size of the list.
     */
    @Override
    public int count() {
        return list.size();
    }

    /**
     * The `isEmpty` function in Java checks if a list is empty.
     * 
     * @return The `isEmpty()` method is being overridden to return whether the list is empty or not.
     * It returns a boolean value - `true` if the list is empty, and `false` if it is not empty.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
