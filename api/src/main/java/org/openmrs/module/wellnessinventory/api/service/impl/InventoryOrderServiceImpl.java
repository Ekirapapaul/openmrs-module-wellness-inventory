package org.openmrs.module.wellnessinventory.api.service.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.ItemOrderDao;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.service.InventoryOrderService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InventoryOrderServiceImpl extends BaseOpenmrsService implements InventoryOrderService {
	
	private ItemOrderDao itemOrderDao;
	
	public ItemOrderDao getItemOrderDao() {
		return itemOrderDao;
	}
	
	public void setItemOrderDao(ItemOrderDao itemOrderDao) {
		this.itemOrderDao = itemOrderDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemOrder> getAllOrders() {
		return itemOrderDao.getAllOrders();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ItemOrder getItemType(Integer orderId) {
		return itemOrderDao.getItemOrder(orderId);
	}
	
	@Override
	@Transactional
	public ItemOrder saveOrder(ItemOrder order) {
		return itemOrderDao.saveItemOrder(order);
	}
	
	@Override
	@Transactional
	public void purgeItemType(ItemOrder itemOrder) {
		itemOrderDao.purgeItemOrder(itemOrder);
	}
}
