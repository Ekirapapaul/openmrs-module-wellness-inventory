package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InventoryItemDaoImpl implements InventoryItemDao {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public List<InventoryItem> getAllInventoryItems() {
		return getSessionFactory().getCurrentSession().createCriteria(InventoryItem.class).list();
	}
	
	@Override
	public InventoryItem getInventoryItem(Integer itemId) {
		return (InventoryItem) sessionFactory.getCurrentSession().get(InventoryItem.class, itemId);
	}
	
	@Override
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(inventoryItem);
		session.flush();
		return inventoryItem;
	}
	
	@Override
	public void purgeInventoryItem(InventoryItem inventoryItem) {
		sessionFactory.getCurrentSession().delete(inventoryItem);
	}
}
