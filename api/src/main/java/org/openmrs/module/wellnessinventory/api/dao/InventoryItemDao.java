package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.module.wellnessinventory.api.model.InventoryItem;

import java.util.List;

/**
 * Database methods for {@link org.openmrs.module.wellnessinventory.api.model.InventoryItem}.
 */
public interface InventoryItemDao {

    public List<InventoryItem> getAllInventoryItems();

    InventoryItem getInventoryItem(Integer itemId);

    InventoryItem saveInventoryItem(InventoryItem inventoryItem);

    void purgeInventoryItem(InventoryItem department);
}
