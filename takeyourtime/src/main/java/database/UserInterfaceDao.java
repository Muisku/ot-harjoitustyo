/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.*;
public interface UserInterfaceDao<T, K> {
    T findOne(K key) throws SQLException;
    List<T> findAll() throws SQLException;
    boolean saveOrUpdate(T object) throws SQLException;
    void delete(K key) throws SQLException;
}
