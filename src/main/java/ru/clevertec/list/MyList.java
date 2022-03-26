package ru.clevertec.list;

public interface MyList<T> {
    T get(int index);

    void set(int index, T t);

    void add(T t);

    void add(int index, T t);

    void remove(T t);

    void remove(int index);

    int getSize();

}
