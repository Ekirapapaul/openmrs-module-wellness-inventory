package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;

import java.util.List;

public interface InventoryItemTypeDao {
	
	public List<ItemType> getAllItemTypes();
	
	ItemType getItemType(Integer itemId);
	
	ItemType saveItemType(ItemType itemType);
	
	void purgeInventoryType(ItemType itemType);
}
