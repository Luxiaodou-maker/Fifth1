package Dao.impl;
import Dao.IProductDao;
import javabean.Product;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Util.JpaUtil;
import javabean.User;

public class ProductDao implements IProductDao {
    @Override
    public void save(Product s) {
        EntityManager manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(Product s) {
        EntityManager manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Long Id) {
        EntityManager manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        Product s=manager.find(Product.class,Id);
        manager.remove(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public User getOne(Long Id) {
        EntityManager manager=JpaUtil.getEntityManager();
        return manager.find(User.class,Id);
    }

    @Override
    public List<User> getAll() {
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "select u from Product u";
        Query query = manager.createQuery(sql);
        List list = query.getResultList();
        manager.close();
        return list;
    }
}
