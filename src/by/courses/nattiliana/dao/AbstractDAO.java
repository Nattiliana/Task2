package by.courses.nattiliana.dao;

import by.courses.nattiliana.entities.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nataly on 02.12.2016.
 * ${VERSION}
 */
public interface AbstractDAO<T extends Entity> {

    List<T> findAll() throws SQLException;
    List<T> findAllById(int id) throws SQLException;
    public void createEntity(T entity) throws SQLException;
}
