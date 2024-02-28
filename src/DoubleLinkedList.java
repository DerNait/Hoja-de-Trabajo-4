package src;

public class DoubleLinkedList<T> implements IList<T> {
    private Node head;
    private Node tail;
    private int size;
    
    /**
     * The class `Node` represents a node in a doubly linked list with data of type `T`.
     */
    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * The `add` method adds a new node with the given value to the end of a doubly linked list.
     * 
     * @param value The `value` parameter represents the data that will be stored in the new node being
     * added to the linked list.
     */
    @Override
    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * This function retrieves the element at a specified index in a doubly linked list.
     * 
     * @param index The `index` parameter in the `get` method represents the position of the element
     * that you want to retrieve from the data structure. It is an integer value that indicates the
     * index of the element you are trying to access within the data structure.
     * @return The `get` method is returning the data stored in the node at the specified index in a
     * doubly linked list.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    /**
     * This function removes an element at a specified index from a doubly linked list.
     * 
     * @param index The `index` parameter in the `remove` method represents the position of the element
     * that you want to remove from the list. It is an integer value that indicates the index of the
     * element to be removed.
     * @return The method is returning the data stored in the node that was removed from the linked
     * list at the specified index.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node target;
        if (index == 0) {
            target = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List became empty
            }
        } else if (index == size - 1) {
            target = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            if (index < size / 2) {
                target = head;
                for (int i = 0; i < index; i++) {
                    target = target.next;
                }
            } else {
                target = tail;
                for (int i = size - 1; i > index; i--) {
                    target = target.prev;
                }
            }
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
        return target.data;
    }

    /**
     * This function returns the size of a data structure.
     * 
     * @return The `size` variable is being returned.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * The `isEmpty` function in Java checks if the size of a data structure is equal to zero.
     * 
     * @return The `isEmpty()` method is returning a boolean value that indicates whether the size of
     * the data structure is equal to 0. If the size is 0, it will return `true`, indicating that the
     * data structure is empty. Otherwise, it will return `false`.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
