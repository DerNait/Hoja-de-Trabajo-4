package src;

public class StackWithSingleList<T> implements IStack<T> {
    private SingleLinkedList<T> list;

    public StackWithSingleList() {
        list = new SingleLinkedList<>();
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Override
    public int count() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
