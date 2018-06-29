package org.openmrs.module.wellnessinventory.api.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.dao.ItemTypeDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.service.ItemTypeService;

import java.util.List;

public class ItemTypeServiceImpl extends BaseOpenmrsService implements ItemTypeService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ItemTypeDao itemTypeDao;
	
	/**
	 * @param inventoryItemDao the dao to set
	 */
	public void setItemTypeDao(ItemTypeDao inventoryItemDao) {
		this.itemTypeDao = inventoryItemDao;
	}
	
	/**
	 * @return the dao
	 */
	public ItemTypeDao getDao() {
		return this.itemTypeDao;
	}
	
	@Override
	public List<ItemType> getAllItemTypes() {
		return itemTypeDao.getAllItemTypes();
	}
	
	@Override
	public ItemType getInventoryItem(Integer typeId) {
		return itemTypeDao.getItemType(typeId);
	}
	
	@Override
	public ItemType saveItemType(ItemType itemType) {
		return itemTypeDao.saveItemType(itemType);
	}
	
	@Override
	public void purgeInventoryItem(ItemType itemType) {
		
	}
}
