package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.verify;

public class InventoryServiceImplIT extends BaseModuleContextSensitiveTest {
	
	@Autowired
	private InventoryItemService itemService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
	}
	
	@Test
	public void testGetAllItems() throws Exception {
		List<InventoryItem> items = itemService.getAllInventoryItems();
		Assert.assertEquals(4, items.size());
	}
	
	@Test
	public void shouldSaveItem() {
		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setName("new");
		inventoryItem.setItemCode("4545");
		inventoryItem.setDescription("description");
		InventoryItem savedItem = itemService.saveInventoryItem(inventoryItem);
		Assert.assertNotNull(savedItem);
		Assert.assertEquals(inventoryItem, savedItem);
	}
}
