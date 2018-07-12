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
	
	SessionFactory sessionFactory;
	
	public InventoryItemDaoImpl() {
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
	private org.hibernate.classic.Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<InventoryItem> getAllInventoryItems() {
		return getSession().createCriteria(InventoryItem.class).list();
	}
	
	@Override
	@Transactional(readOnly = true)
	public InventoryItem getInventoryItem(Integer itemId) {
		return (InventoryItem) getSession().get(InventoryItem.class, itemId);
	}
	
	@Override
	@Transactional
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
		getSession().saveOrUpdate(inventoryItem);
		return inventoryItem;
	}
	
	@Override
	@Transactional
	public void purgeInventoryItem(InventoryItem inventoryItem) {
		sessionFactory.getCurrentSession().delete(inventoryItem);
	}
}
