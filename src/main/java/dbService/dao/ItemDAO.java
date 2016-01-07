package dbService.dao;


import dbService.dataSets.Items;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ItemDAO {

    private Session session;

    public ItemDAO(Session session) {
        this.session = session;
    }

    public Items getItemQuantity(String quantity) throws HibernateException {
        Criteria criteria = session.createCriteria(Items.class);
        return (Items) criteria.add(Restrictions.eq("quantity", quantity)).uniqueResult();
    }

    public boolean containItemQuantity(String quantity) throws HibernateException {
        Criteria criteria = session.createCriteria(Items.class);
        if (criteria.add(Restrictions.eq("quantity", quantity)).uniqueResult() != null)
            return true;
        else return false;
    }

    public long insertItems(String quantity, String description, int unit, double price, String measurement) throws HibernateException {
        return (Long) session.save(new Items(quantity, description, unit, price, measurement));
    }

    public List<Items> getAllItems() throws HibernateException {
        Criteria criteria = session.createCriteria(Items.class);
        return (List<Items>) criteria.list();
    }
}