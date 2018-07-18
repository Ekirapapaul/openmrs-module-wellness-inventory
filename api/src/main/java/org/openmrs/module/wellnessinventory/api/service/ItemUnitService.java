package org.openmrs.module.wellnessinventory.api.service;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.wellnessinventory.api.model.ItemUnit;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface ItemUnitService extends OpenmrsService {
	
	/**
	 * Gets a list of units.
	 * 
	 * @return the units list.
	 */
	List<ItemUnit> getAllUnits();
	
	/**
	 * Gets a unit for a given id.
	 * 
	 * @param unitId the unit id
	 * @return the unit with the given id
	 */
	ItemUnit getItemUnit(Integer unitId);
	
	/**
	 * Saves a new or existing inventory stock room.
	 * 
	 * @param itemUnit the stock room to save.
	 * @return the saved inventory stock room.
	 */
	ItemUnit saveItemUnit(ItemUnit itemUnit);
	
	/**
	 * Deletes a stock room the database.
	 * 
	 * @param itemUnit the room to delete.
	 */
	void purgeItemUnit(ItemUnit itemUnit);
}
