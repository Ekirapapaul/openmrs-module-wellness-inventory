package org.openmrs.module.wellnessinventory.api.service;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemStock;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    /**
     * Gets a list of the stock details by item.
     *
     * @return the inventory item stock details.
     */
    Set<ItemStockDetails> getStockDetaisByItem(InventoryItem inventoryItem);

    /**
     * Gets a list of the stock details by item id.
     *
     * @return the inventory item stock details.
     */
    Set<ItemStockDetails> getStockDetaisByItemId(Integer itemId);

    /**
     * Saves a new or existing inventory item stock.
     *
     * @param itemStockDetail the item stock to save.
     * @return the saved inventory item stock detail.
     */
    ItemStockDetails saveItemStockDetail(ItemStockDetails itemStockDetail);

    /**
     * Gets an item stock detail for a given id.
     *
     * @param id the inventory item id
     * @return the item stock detail with the given id
     */
    ItemStockDetails getItemStockDetail(Integer id);
}
