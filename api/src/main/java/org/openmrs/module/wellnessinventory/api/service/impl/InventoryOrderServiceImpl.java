package org.openmrs.module.wellnessinventory.api.service.impl;

import org.openmrs.Patient;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.dao.ItemOrderDao;
import org.openmrs.module.wellnessinventory.api.dao.StockDetailsDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.service.InventoryOrderService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

public class InventoryOrderServiceImpl extends BaseOpenmrsService implements InventoryOrderService {
	
	private ItemOrderDao itemOrderDao;
	
	private StockDetailsDao stockDetailsDao;
	
	public ItemOrderDao getItemOrderDao() {
		return itemOrderDao;
	}
	
	public void setItemOrderDao(ItemOrderDao itemOrderDao) {
		this.itemOrderDao = itemOrderDao;
	}
	
	public StockDetailsDao getStockDetailsDao() {
		return stockDetailsDao;
	}
	
	public void setStockDetailsDao(StockDetailsDao stockDetailsDao) {
		this.stockDetailsDao = stockDetailsDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemOrder> getAllOrders() {
		return itemOrderDao.getAllOrders();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ItemOrder getOrder(Integer orderId) {
		return itemOrderDao.getItemOrder(orderId);
	}
	
	@Override
	@Transactional
	public ItemOrder saveOrder(ItemOrder order) {
		return itemOrderDao.saveItemOrder(order);
	}
	
	@Override
	@Transactional
	public ItemOrder saveAnDispenseOrder(ItemOrder order) {
		order.setDispensed(true);
		ItemOrder savedOrder = itemOrderDao.saveItemOrder(order);
		InventoryItem inventoryItem = savedOrder.getInventoryItem();
		Iterator<ItemStockDetails> iterator = inventoryItem.getDetails().iterator();
		if (iterator.hasNext()) {
			ItemStockDetails stockDetail = iterator.next();
			int quantity = stockDetail.getQuantity();
			quantity = quantity - savedOrder.getQuantity();
			stockDetail.setQuantity(quantity);
			stockDetailsDao.saveStockDetails(stockDetail);
			
		}
		return savedOrder;
	}
	
	@Override
	@Transactional
	public ItemOrder dispenseOrder(ItemOrder order) {
		
		InventoryItem inventoryItem = order.getInventoryItem();
		Iterator<ItemStockDetails> iterator = inventoryItem.getDetails().iterator();
		if (iterator.hasNext()) {
			ItemStockDetails stockDetail = iterator.next();
			int quantity = stockDetail.getQuantity();
			quantity = quantity - order.getQuantity();
			stockDetail.setQuantity(quantity);
			stockDetailsDao.saveStockDetails(stockDetail);
			order.setDispensed(true);
			ItemOrder savedOrder = itemOrderDao.saveItemOrder(order);
		}
		return order;
	}
	
	@Override
	public List<ItemOrder> dispenseOrders(List<ItemOrder> orders) {
		for (ItemOrder order : orders) {
			order.setDispensed(true);
			ItemOrder savedOrder = itemOrderDao.saveItemOrder(order);
			InventoryItem inventoryItem = savedOrder.getInventoryItem();
			Iterator<ItemStockDetails> iterator = inventoryItem.getDetails().iterator();
			if (iterator.hasNext()) {
				ItemStockDetails stockDetail = iterator.next();
				int quantity = stockDetail.getQuantity();
				quantity = quantity - savedOrder.getQuantity();
				stockDetail.setQuantity(quantity);
				stockDetailsDao.saveStockDetails(stockDetail);
			}
		}
		return orders;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemOrder> getClientOrders(Patient patient) {
		return itemOrderDao.getClientOrders(patient);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemOrder> getClientOrders(Integer patientId) {
		return itemOrderDao.getClientOrders(patientId);
	}
	
	@Override
	@Transactional
	public void purgeItemType(ItemOrder itemOrder) {
		itemOrderDao.purgeItemOrder(itemOrder);
	}
}
