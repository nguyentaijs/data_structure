package com.nguyentai;

import java.lang.module.ModuleReader;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    public static final int INDEX_NOT_FOUND = -1;
    private T[] baseArray;
    private int size = 0;
    private int capacity = 0;
    public static int DEFAULT_CAPACITY = 10;

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can not be negative");
        }
        this.capacity = capacity;
        baseArray = (T[]) new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    /***
     * This method is not required
     * @return capacity
     */
    public int capacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public T get(int index) {
        return baseArray[index];
    }

    public void set(int index, T element) {
        baseArray[index] = element;
    }
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            baseArray[i] = null;
        }
        size = 0;
        capacity = 0;
    }

    public void add(T element) {
        if (capacity <= 0) {
            capacity = 1;
        }
        if (size >= capacity - 1) {
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = baseArray[i];
            }
            baseArray = newArray;
        }

        baseArray[size] = element;
        size++;
    }

    public void removeAt(int removeIndex) {
        int newSize = size - 1;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == removeIndex) {
                j--;
            } else {
                newArray[j] = baseArray[i];
            }
        }
        baseArray = newArray;
        size = newSize;
    }

    public void remove(T element) {
        int removeIndex = indexOf(element);
        if (removeIndex != INDEX_NOT_FOUND) {
            removeAt(removeIndex);
        }
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (baseArray[i] == null) {
                    return i;
                }
            } else {
                if (element.equals(baseArray[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public boolean contains(T element) {
        return indexOf(element) != INDEX_NOT_FOUND;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return baseArray[index++];
            }
        };
    }

    public String toString() {
        if (size <= 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size - 1; i++) {
            builder.append(baseArray[i]).append(", ");
        }
        builder.append(baseArray[size - 1]).append("]");
        return builder.toString();
    }
}
