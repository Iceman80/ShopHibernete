package dbService.dataSets;

import dbService.HibernateUtil;
import dbService.dao.UserDAO;
import org.hibernate.*;

import java.util.List;


public class UserDataSet {

    public long addUser(String name, String password, int age, String adress) throws DBException {
        try {
            if (userContains(name)) {
                System.out.println("Покупатель с " + name + " именем уже зарегестрирован в системе");
                return 0;
            } else {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                UserDAO userDao = new UserDAO(session);
                long id = userDao.insertUser(name, password, age, adress);
                System.out.println(id);
                transaction.commit();
                session.close();
                return id;
            }
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(users);
        transaction.commit();
        session.close();

        System.out.println("Update User OK");
    }

    public Users getUserForName(String name) throws DBException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UserDAO userDao = new UserDAO(session);
            Users user = userDao.getUserName(name);
            session.close();
            return user;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public boolean userContains(String name) throws DBException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UserDAO userDao = new UserDAO(session);
            boolean temp = userDao.containUserName(name);
            session.close();
            return temp;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public boolean userDel(String name, String password) throws DBException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Users tmp = getUserForName(name);
            if (tmp != null) {
                if (tmp.getPassword().equals(password)) {
                    Transaction transaction1 = session.beginTransaction();
                    session.delete(tmp);
                    transaction1.commit();
                    session.close();
                    return true;
                } else return false;
            } else
                return false;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public List<Users> readAllUser() throws DBException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UserDAO userDao = new UserDAO(session);
            List<Users> temp = userDao.getAllUsers();
            session.close();
            return temp;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }
}
