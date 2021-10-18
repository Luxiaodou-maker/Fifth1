package Dao;

import javabean.Product;
import javabean.User;

import java.util.List;

public interface IProductDao {
    void save(Product s);
    void update(Product s);
    void delete(Long Id);
    User getOne(Long Id);
    List<User> getAll();
}
