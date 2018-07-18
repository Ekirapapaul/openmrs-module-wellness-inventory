package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.wellnessinventory.api.dao.ItemUnitDao;
import org.openmrs.module.wellnessinventory.api.model.ItemUnit;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ItemUnitDaoImpl implements ItemUnitDao {

    protected final Log log = LogFactory.getLog(this.getClass());

    public ItemUnitDaoImpl() {

    }

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemUnit> getAllUnits() {
        return getSession().createCriteria(ItemUnit.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public ItemUnit getItemUnit(Integer id) {
        return (ItemUnit) getSession().get(ItemUnit.class, id);
    }

    @Override
    @Transactional
    public ItemUnit saveItemUnit(ItemUnit itemUnit) {
        getSession().saveOrUpdate(itemUnit);
        return itemUnit;
    }

    @Override
    @Transactional
    public void purgeItemUnit(ItemUnit itemUnit) {
        getSession().delete(itemUnit);
    }
}
