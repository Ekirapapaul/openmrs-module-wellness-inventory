package org.openmrs.module.wellnessinventory.api.service;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemTypeService extends OpenmrsService {
	
	/**
	 * Gets a list of ite types.
	 * 
	 * @return the inventory items list.
	 */
	@Transactional(readOnly = true)
	List<ItemType> getAllItemTypes();
	
	/**
	 * Gets an inventory item type for a given id.
	 * 
	 * @param typeId the item type id
	 * @return the item with the given id
	 */
	@Transactional(readOnly = true)
	ItemType getItemType(Integer typeId);
	
	/**
	 * Saves a new or existing inventory item type.
	 * 
	 * @param itemType the item type to save.
	 * @return the saved inventory item type.
	 */
	@Transactional
	ItemType saveItemType(ItemType itemType);
	
	/**
	 * Deletes an inventory item from the database.
	 * 
	 * @param itemType the item to delete.
	 */
	@Transactional
	void purgeItemType(ItemType itemType);
}
