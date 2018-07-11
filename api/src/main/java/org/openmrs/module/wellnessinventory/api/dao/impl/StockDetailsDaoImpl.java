package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.openmrs.module.wellnessinventory.api.dao.StockDetailsDao;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StockDetailsDaoImpl implements StockDetailsDao {


    @Autowired
    SessionFactory sessionFactory;

    public StockDetailsDaoImpl() {

    }

    /**
     * @return the sessionFactory
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemStockDetails> getAllStockDetails() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ItemStockDetails getStockDetails(Integer id) {
        return null;
    }

    @Override
    public ItemStockDetails saveStockDetails(ItemStockDetails stockDetails) {
        getSession().saveOrUpdate(stockDetails);
        return stockDetails;
    }


    @Override
    @Transactional
    public void purgeStockDetails(ItemStockDetails stockDetails) {

    }
}
