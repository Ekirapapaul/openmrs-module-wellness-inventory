package org.openmrs.module.wellnessinventory.api.service;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryService extends OpenmrsService {
	
	/**
	 * Gets a list of inventory items.
	 * 
	 * @return the inventory items list.
	 */
	List<InventoryItem> getAllInventoryItems();
	
	/**
	 * Gets an inventory item for a given id.
	 * 
	 * @param itemId the inventory item id
	 * @return the item with the given id
	 */
	InventoryItem getInventoryItem(Integer itemId);
	
	/**
	 * Saves a new or existing inventory item.
	 * 
	 * @param inventoryItem the item to save.
	 * @return the saved inventory item.
	 */
	InventoryItem saveInventoryItem(InventoryItem inventoryItem);
	
	/**
	 * Deletes an inventory item from the database.
	 * 
	 * @param inventoryItem the item to delete.
	 */
	void purgeInventoryItem(InventoryItem inventoryItem);
}
