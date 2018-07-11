package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface StockDetailsDao {

    public List<ItemStockDetails> getAllStockDetails();

    ItemStockDetails getStockDetails(Integer id);

    ItemStockDetails saveStockDetails(ItemStockDetails stockDetails);

    void purgeStockDetails(ItemStockDetails stockDetails);
}
