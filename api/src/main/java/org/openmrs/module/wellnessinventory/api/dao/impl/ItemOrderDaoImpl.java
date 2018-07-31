package org.openmrs.module.wellnessinventory.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
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
    @Transactional(readOnly = true)
    public List<ItemOrder> getClientOrders(Patient patient) {
	    Session session = getSession();
        Criteria criteria = session.createCriteria(ItemOrder.class, "inventory_item_order");
        criteria.add(Restrictions.eq("client",patient));
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemOrder> getClientOrders(Integer patientId) {
	    Patient patient = Context.getPatientService().getPatient(patientId);
        Session session = getSession();
        Criteria criteria = session.createCriteria(ItemOrder.class, "inventory_item_order");
        criteria.add(Restrictions.eq("client",patient));
        return criteria.list();
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
