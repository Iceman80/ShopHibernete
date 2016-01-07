package dbService.dao;


import dbService.dataSets.Users;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDAO {

    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public Users getUserName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(Users.class);
        return (Users) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }

    public boolean containUserName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(Users.class);
        if (criteria.add(Restrictions.eq("name", name)).uniqueResult() != null)
            return true;
        else return false;
    }

    public long insertUser(String name, String password, int age, String adress) throws HibernateException {
        return (Long) session.save(new Users(name, password, age, adress));
    }

    public List<Users> getAllUsers() throws HibernateException {
        Criteria criteria = session.createCriteria(Users.class);
        return (List<Users>) criteria.list();
    }
}