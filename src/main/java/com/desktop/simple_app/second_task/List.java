package com.desktop.simple_app.second_task;

public class List<T> {
    private final int DEFAULT_CAPACITY = 10;
    private Object[] list = new Object[DEFAULT_CAPACITY];
    private int size;

    public void add(Object object) {
        if (size == list.length)
            changeCapacity(list.length * 2);
        list[size] = object;
        size++;
        changed(size);
    }

    private void changeCapacity(int newCapacity) {
        Object[] newList = new Object[newCapacity];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        checkIndex(index);
        return (T) list[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The index is out of bounds");
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(list, index + 1, list, index, size - index);
        list[size] = null;
        size--;
        changed(size);
        if (list.length > DEFAULT_CAPACITY && size < list.length / 2) {
            changeCapacity(list.length / 2);
        }
    }

    private void changed(int size) {
        System.out.println("The size has changed! New list size: " + size);
    }

    public static void main(String[] args) {
        List<String> someList = new List<>();

        for (int i = 0; i < 5; i++) {
            someList.add(new String(Integer.toString(i)));
        }

        System.out.println(someList.get(3));
        System.out.println(someList.size());

        for (int i = 4; i >= 0; i--) {
            someList.remove(i);
        }
    }
}
