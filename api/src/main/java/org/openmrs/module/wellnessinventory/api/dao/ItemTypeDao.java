package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;

import java.util.List;

public interface ItemTypeDao {
	
	public List<ItemType> getAllItemTypes();
	
	ItemType getItemType(Integer itemId);
	
	ItemType saveItemType(ItemType itemType);
	
	void purgeInventoryItem(ItemType itemType);
}
