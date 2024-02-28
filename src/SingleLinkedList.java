package src;

public class SingleLinkedList<T> implements IList<T> {

    /*
     * Se le pidio a la IA: Con base a mi interfaz IList crea la implementacion de una Lista simplemente encadenada
     */

    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * The `add` method adds a new node with the given value to the end of the linked list.
     * 
     * @param value The `add` method is used to add a new node with the given value to the
     * end of a linked list. The `value` parameter represents the data that will be stored in the new
     * node being added to the linked list.
     */
    @Override
    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * This function retrieves the element at the specified index in a linked list.
     * 
     * @param index The `index` parameter in the `get` method represents the position of the element
     * that you want to retrieve from the data structure. It is the index of the element you want to
     * access within the data structure.
     * @return The `get` method is returning the data stored in the node at the specified index in the
     * linked list.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * This function removes an element at a specified index from a linked list in Java.
     * 
     * @param index The `index` parameter in the `remove` method represents the position of the element
     * that you want to remove from the data structure. It is an integer value that indicates the index
     * of the element to be removed.
     * @return The `remove` method is returning the data stored in the node that was removed from the
     * specified index in the linked list.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node prev = null;
        Node current = head;

        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
        size--;
        return current.data;
    }

    /**
     * The `size()` function in Java returns the size of a data structure.
     * 
     * @return The method is returning the value of the variable "size".
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * The `isEmpty` function in Java checks if the head of a data structure is null to determine if it
     * is empty.
     * 
     * @return The `isEmpty()` method is returning a boolean value, which indicates whether the `head`
     * variable is null or not. If `head` is null, the method will return `true`, indicating that the
     * data structure is empty. Otherwise, it will return `false`.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
