package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.openmrs.module.wellnessinventory.api.dao.ItemOrderDao;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemOrderDaoImpl implements ItemOrderDao {

    SessionFactory sessionFactory;

    public ItemOrderDaoImpl() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return the sessionFactory
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemOrder> getAllOrders() {
        return getSession().createCriteria(ItemOrder.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public ItemOrder getItemOrder(Integer id) {
        return (ItemOrder) getSession().get(ItemOrder.class, id);
    }

    @Override
    @Transactional
    public ItemOrder saveItemOrder(ItemOrder order) {
        getSession().saveOrUpdate(order);
        return order;
    }

    @Override
    @Transactional
    public void purgeItemOrder(ItemOrder order) {
        getSession().delete(order);
    }
}
