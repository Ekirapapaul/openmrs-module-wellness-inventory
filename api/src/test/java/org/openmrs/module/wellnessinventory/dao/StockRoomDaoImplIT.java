package org.openmrs.module.wellnessinventory.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemTypeDao;
import org.openmrs.module.wellnessinventory.api.dao.StockRoomDao;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.test.context.ContextConfiguration(locations = { "classpath:TestingApplicationContext.xml" }, inheritLocations = true)
public class StockRoomDaoImplIT extends BaseModuleContextSensitiveTest {
	
	@Autowired
    StockRoomDao stockRoomDao;
	
	@Before
	public void beforeAllTests() throws Exception {
		executeDataSet("inventoryItems.xml");
	}
	
	@Test
	public void shouldGetAllItems() {
		List<StockRoom> inventoryItems = stockRoomDao.getAllStockRooms();
		Assert.assertEquals(1, inventoryItems.size());
	}
	
	//	@Test
	//	public void shouldGetItemTypeById() {
	//		ItemType itemType = itemTypeDao.getItemType(1);
	//		Assert.assertEquals(1, (int) itemType.getId());
	//		Assert.assertEquals(3, itemType.getInventoryItems().size());
	//	}
	
}
