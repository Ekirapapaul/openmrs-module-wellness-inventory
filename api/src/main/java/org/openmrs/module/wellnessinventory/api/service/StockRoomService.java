package org.openmrs.module.wellnessinventory.api.service;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface StockRoomService extends OpenmrsService {
	
	/**
	 * Gets a list of stock rooms.
	 * 
	 * @return the stock rooms list.
	 */
	List<StockRoom> getAllStockRooms();
	
	/**
	 * Gets an inventory stock room for a given id.
	 * 
	 * @param typeId the item type id
	 * @return the Room with the given id
	 */
	StockRoom getItemType(Integer typeId);
	
	/**
	 * Saves a new or existing inventory stock room.
	 * 
	 * @param stockRoom the stock room to save.
	 * @return the saved inventory stock room.
	 */
	StockRoom saveItemType(StockRoom stockRoom);
	
	/**
	 * Deletes a stock room the database.
	 * 
	 * @param stockRoom the room to delete.
	 */
	void purgeItemType(StockRoom stockRoom);
}
