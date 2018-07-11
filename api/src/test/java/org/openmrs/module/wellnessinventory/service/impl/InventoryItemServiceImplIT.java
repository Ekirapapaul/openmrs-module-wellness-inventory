package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.Date;
import java.util.List;

public class InventoryItemServiceImplIT extends BaseModuleContextSensitiveTest {
	
	private InventoryService itemService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
		itemService = Context.getService(InventoryService.class);
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
		
		List<InventoryItem> items = Context.getService(InventoryService.class).getAllInventoryItems();
		Assert.assertEquals(5, items.size());
	}
}
