package com.Project0.util;
import com.Project0.model.User;

public abstract class CarCollection {

    /**
     * Optional size number for non expandable subclasses
     */
    protected int maxSize;

    public abstract Object get(Object o);

    public abstract void add(User u) throws Exception;

    public abstract int size();

    public abstract void remove(Object o);

    public abstract Object next();

    public abstract Object previous();

    public abstract String toString();

    abstract boolean isEmpty();

    protected abstract void clear();
}
