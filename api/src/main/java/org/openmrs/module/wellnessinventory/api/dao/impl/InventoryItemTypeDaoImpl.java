package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemTypeDao;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InventoryItemTypeDaoImpl implements InventoryItemTypeDao {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	SessionFactory sessionFactory;
	
	public InventoryItemTypeDaoImpl() {
		
	}
	
	/**
	 * @return the sessionFactory
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemType> getAllItemTypes() {
		return getSession().createCriteria(ItemType.class).list();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ItemType getItemType(Integer itemId) {
		return (ItemType) getSession().get(ItemType.class, itemId);
	}
	
	@Override
	@Transactional
	public ItemType saveItemType(ItemType itemType) {
		getSession().saveOrUpdate(itemType);
		return itemType;
	}
	
	@Override
	@Transactional
	public void purgeInventoryType(ItemType itemType) {
		getSession().delete(itemType);
	}
}
