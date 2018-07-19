package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.module.wellnessinventory.api.model.ItemUnit;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface ItemUnitDao {

    public List<ItemUnit> getAllUnits();

    ItemUnit getItemUnit(Integer id);

    ItemUnit saveItemUnit(ItemUnit itemUnit);

    void purgeItemUnit(ItemUnit itemUnit);
}
