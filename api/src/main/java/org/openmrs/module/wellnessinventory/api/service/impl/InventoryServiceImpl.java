package org.openmrs.module.wellnessinventory.api.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.dao.StockDetailsDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemStock;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public class InventoryServiceImpl extends BaseOpenmrsService implements InventoryService {

	protected final Log log = LogFactory.getLog(this.getClass());

	private InventoryItemDao inventoryItemDao;

	private StockDetailsDao stockDetailsDao;

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

    public StockDetailsDao getStockDetailsDao() {
        return stockDetailsDao;
    }

    public void setStockDetailsDao(StockDetailsDao stockDetailsDao) {
        this.stockDetailsDao = stockDetailsDao;
    }

    /**
	 * @see InventoryService#getAllInventoryItems()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<InventoryItem> getAllInventoryItems() {
		return inventoryItemDao.getAllInventoryItems();
	}

	/**
	 * @see InventoryService#getInventoryItem(Integer) ()
	 */
	@Override
	@Transactional(readOnly = true)
	public InventoryItem getInventoryItem(Integer itemId) {
		return inventoryItemDao.getInventoryItem(itemId);
	}

	/**
	 * @see InventoryService#saveInventoryItem(InventoryItem) ()
	 */
	@Override
	@Transactional
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
		return inventoryItemDao.saveInventoryItem(inventoryItem);
	}

	@Override
	public void purgeInventoryItem(InventoryItem inventoryItem) {
		inventoryItemDao.purgeInventoryItem(inventoryItem);
	}

    @Override
    public Set<ItemStockDetails> getStockDetais(InventoryItem inventoryItem) {
        return inventoryItem.getDetails();
    }

    @Override
    public Set<ItemStockDetails> getStockDetais(Integer itemId) {
	    InventoryItem inventoryItem = inventoryItemDao.getInventoryItem(itemId);
	    if(inventoryItem != null){
	        return inventoryItem.getDetails();
        }
        return null;
    }

    @Override
    public ItemStockDetails saveItemStockDetail(ItemStockDetails itemStockDetail) {
        return stockDetailsDao.saveStockDetails(itemStockDetail);
    }

    @Override
    public ItemStockDetails getItemStockDetail(Integer id) {
        return stockDetailsDao.getStockDetails(id);
    }

}
