package src;

public interface IStack<T>{

    /**
     * Devuelve la cantidad de elementos
     * @return un entero que devuelve la cantidad de elementos
     */
    int count();

    /**
     * Este metodo nos indica si la ED stack esta vacia o no
     * @return verdadero si esta vacia, falso de lo contrario
     */
    boolean isEmpty();

    /**
     * The `push` function adds a value to a data structure.
     * 
     * @param value The `push` function is used to add a new element of type `T` to a data structure,
     * such as a stack or a queue. The `value` parameter represents the element that you want to add to
     * the data structure.
     */
    void push(T value);

    /**
     * The pop() function removes and returns the top element from a stack data structure.
     * 
     * @return The `pop()` function is likely removing and returning the top element of a stack data
     * structure.
     */
    T pop();

    /**
     * The `peek()` function in Java returns the element at the top of a stack without removing it.
     * 
     * @return the element at the top of the stack without removing it.
     */
    T peek();
}