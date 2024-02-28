package src;

public interface IList<T> {

    /**
     * The add function takes a value of type T and adds it to a collection or data structure.
     * 
     * @param value The parameter "value" in the function "add" represents the value that you want to
     * add to a data structure or perform some operation on.
     */
    void add(T value);

    /**
     * The `get` function in Java returns the element at the specified index in a collection.
     * 
     * @param index The `index` parameter specifies the position of the element to retrieve from a data
     * structure. It is an integer value representing the index of the element to be retrieved.
     * @return The `get` method is returning an element at the specified index in a data structure.
     */
    T get(int index);

    /**
     * The `remove` function removes and returns the element at the specified index in a collection.
     * 
     * @param index The `index` parameter specifies the position of the element that you want to remove
     * from the collection.
     * @return The `remove(int index)` method is likely returning the element that was removed from the
     * collection at the specified index.
     */
    T remove(int index);
    
    /**
     * The `size()` function in Java returns the number of elements in a data structure.
     * 
     * @return The `size()` function is likely returning an integer value.
     */
    int size();

    /**
     * The `isEmpty()` function in Java returns a boolean value indicating whether a data structure is
     * empty or not.
     * 
     * @return A boolean value indicating whether the object is empty or not.
     */
    boolean isEmpty();
}
