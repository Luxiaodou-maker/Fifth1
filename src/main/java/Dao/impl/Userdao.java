package Dao.impl;

import Dao.IUserDao;
import javabean.User;

import java.util.List;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Util.JpaUtil;


public class Userdao implements IUserDao {

    @Override
    public void save(User s) {
        EntityManager manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(User s) {
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
        User s=manager.find(User.class,Id);
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
        String sql = "select u from User u";
        Query query = manager.createQuery(sql);
        List list = query.getResultList();
        manager.close();
        return list;

    }

    @Override
    public boolean Login(String username, String password) {
        EntityManager manager=JpaUtil.getEntityManager();
        String sql="select u from User u where u.UserName=:username and u.Password=:password";
        Query query=manager.createQuery(sql);
        query.setParameter("username",username);
        query.setParameter("password",password);
        List list=query.getResultList();
        manager.close();
        return list.size()>=1;
    }
}
