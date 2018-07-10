package org.openmrs.module.wellnessinventory.api.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemTypeDao;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemTypeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InventoryItemTypeServiceImpl extends BaseOpenmrsService implements InventoryItemTypeService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private InventoryItemTypeDao itemTypeDao;
	
	/**
	 * @param inventoryItemDao the dao to set
	 */
	public void setItemTypeDao(InventoryItemTypeDao inventoryItemDao) {
		this.itemTypeDao = inventoryItemDao;
	}
	
	/**
	 * @return the dao
	 */
	public InventoryItemTypeDao getDao() {
		return this.itemTypeDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemType> getAllItemTypes() {
		return itemTypeDao.getAllItemTypes();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ItemType getItemType(Integer typeId) {
		return itemTypeDao.getItemType(typeId);
	}
	
	@Override
	@Transactional
	public ItemType saveItemType(ItemType itemType) {
		return itemTypeDao.saveItemType(itemType);
	}
	
	@Override
	@Transactional
	public void purgeItemType(ItemType itemType) {
		
	}
}
