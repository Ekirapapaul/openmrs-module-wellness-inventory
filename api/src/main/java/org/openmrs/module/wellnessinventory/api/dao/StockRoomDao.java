package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface StockRoomDao {

    public List<StockRoom> getAllStockRooms();

    StockRoom getStockRoom(Integer id);

    StockRoom saveStockRoom(StockRoom stockRoom);

    void purgeStockRoom(StockRoom stockRoom);
}
