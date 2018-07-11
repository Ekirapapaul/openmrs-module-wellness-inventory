package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.wellnessinventory.api.dao.StockRoomDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StockRoomDaoImpl implements StockRoomDao {

    protected final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public List<StockRoom> getAllStockRooms() {
        return getSession().createCriteria(StockRoom.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public StockRoom getStockRoom(Integer id) {
        return (StockRoom) getSession().get(StockRoom.class, id);
    }

    @Override
    @Transactional
    public StockRoom saveStockRoom(StockRoom stockRoom) {
        getSession().saveOrUpdate(stockRoom);
        return stockRoom;
    }

    @Override
    @Transactional
    public void purgeStockRoom(StockRoom stockRoom) {
        sessionFactory.getCurrentSession().delete(stockRoom);
    }
}
