package com.Project0.db;

import com.Project0.util.CarCollection;

/**
 * A dao contract to determine functionality in the GymDao objects.
 * @param <T> The class used for this dao object.
 * @param <I> The primary key used by the class.
 */
public interface GenericDao<T, I> {

    //save an instance to the db
    int save(T t);

    //select an object by its primary key
    T getById(I id);

    //gather all objects in the db
    //changing this from CarCollection getAll() --> void getAll()
    void getAll();
    //this needs to be made with custom datastructure

    //delete an object from the db
    boolean remove(I id);

    //update an object in the db
    boolean update(T t);

    //update all records in a table that correspond to the objects inside the GymCollection argument
    int updateAll(CarCollection collection);
    //this one above should be for getting rid of car and offers once sold
}
