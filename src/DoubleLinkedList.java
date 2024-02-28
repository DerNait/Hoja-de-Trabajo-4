package src;

public class DoubleLinkedList<T> implements IList<T> {
    private Node head;
    private Node tail;
    private int size;

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
