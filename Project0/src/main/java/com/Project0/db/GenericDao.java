package com.Project0.db;

import com.Project0.util.CarCollection;

/**
 * A dao contract to determine functionality in the GymDao objects.
 * @param <T> The class used for this dao object.
 * @param <I> The primary key used by the class.
 */
public interface GenericDao<T, I> {


    int save(T t);

    T getById(I id);

    void getAll();

    boolean remove(I id);

    boolean update(T t);

    int updateAll(CarCollection collection);

}
