package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.dao.ItemTypeDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemTypeDaoImpl implements ItemTypeDao {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public ItemTypeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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
	public List<ItemType> getAllItemTypes() {
		return getSessionFactory().getCurrentSession().createCriteria(ItemType.class).list();
	}
	
	@Override
	public ItemType getItemType(Integer itemId) {
		return (ItemType) sessionFactory.getCurrentSession().get(ItemType.class, itemId);
	}
	
	@Override
	public ItemType saveItemType(ItemType itemType) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(itemType);
		session.flush();
		return itemType;
	}
	
	@Override
	public void purgeInventoryItem(ItemType itemType) {
		sessionFactory.getCurrentSession().delete(itemType);
	}
}
