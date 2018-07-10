package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.openmrs.module.wellnessinventory.api.service.StockRoomService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.List;

public class StockRoomServiceImplIT extends BaseModuleContextSensitiveTest {
	
	private StockRoomService stockRoomService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
        stockRoomService = Context.getService(StockRoomService.class);
	}
	
	@Test
	public void testGetAllRooms() throws Exception {
		List<StockRoom> items = stockRoomService.getAllStockRooms();
		Assert.assertEquals(1, items.size());
	}
	
	@Test
	public void shouldSaveStockRoom() {
		StockRoom stockRoom = new StockRoom();
		stockRoom.setName("Main room");

        Location location = Context.getLocationService().getLocation(1);
        stockRoom.setLocation(location);

		StockRoom savedItem = stockRoomService.saveItemType(stockRoom);
		Assert.assertNotNull(savedItem);
		Assert.assertEquals(stockRoom, savedItem);
		
		List<StockRoom> stockRooms = Context.getService(StockRoomService.class).getAllStockRooms();
		Assert.assertEquals(2, stockRooms.size());
	}
}
