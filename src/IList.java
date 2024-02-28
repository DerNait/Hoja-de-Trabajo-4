package src;

public interface IList<T> {
    void add(T value);
    T get(int index);
    T remove(int index);
    int size();
    boolean isEmpty();
}
