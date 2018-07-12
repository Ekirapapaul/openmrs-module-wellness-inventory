package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.openmrs.module.wellnessinventory.api.dao.StockDetailsDao;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StockDetailsDaoImpl implements StockDetailsDao {
	
	SessionFactory sessionFactory;
	
	public StockDetailsDaoImpl() {
		
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
	public List<ItemStockDetails> getAllStockDetails() {
		return getSession().createCriteria(ItemStockDetails.class).list();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ItemStockDetails getStockDetails(Integer id) {
		return (ItemStockDetails) getSession().get(ItemStockDetails.class, id);
	}
	
	@Override
	@Transactional
	public ItemStockDetails saveStockDetails(ItemStockDetails stockDetails) {
		getSession().saveOrUpdate(stockDetails);
		return stockDetails;
	}
	
	@Override
	@Transactional
	public void purgeStockDetails(ItemStockDetails stockDetails) {
		
	}
}
