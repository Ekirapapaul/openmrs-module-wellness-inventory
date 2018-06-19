package org.openmrs.module.wellnessinventory.api.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemService;

import java.util.List;

public class InventoryServiceImpl extends BaseOpenmrsService implements InventoryItemService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private InventoryItemDao inventoryItemDao;
	
	/**
	 * @param inventoryItemDao the dao to set
	 */
	public void setInventoryItemDao(InventoryItemDao inventoryItemDao) {
		this.inventoryItemDao = inventoryItemDao;
	}
	
	/**
	 * @return the dao
	 */
	public InventoryItemDao getDao() {
		return this.inventoryItemDao;
	}
	
	/**
	 * @see InventoryItemService#getAllInventoryItems()
	 */
	@Override
	public List<InventoryItem> getAllInventoryItems() {
		return inventoryItemDao.getAllInventoryItems();
	}
	
	/**
	 * @see InventoryItemService#getInventoryItem(Integer) ()
	 */
	@Override
	public InventoryItem getInventoryItem(Integer itemId) {
		return inventoryItemDao.getInventoryItem(itemId);
	}
	
	/**
	 * @see InventoryItemService#saveInventoryItem(InventoryItem) ()
	 */
	@Override
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
		return inventoryItemDao.saveInventoryItem(inventoryItem);
	}
	
	/**
	 * @see InventoryItemService#purgeInventoryItem(InventoryItem) ()
	 */
	@Override
	public void purgeInventoryItem(InventoryItem inventoryItem) {
		inventoryItemDao.purgeInventoryItem(inventoryItem);
	}
}
