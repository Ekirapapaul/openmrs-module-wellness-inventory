package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemService;

import static org.mockito.Mockito.verify;

public class InventoryServiceImplIT {
	
	private InventoryItemService itemService;
	
	@Mock
	private InventoryItemDao itemDao;
	
	@Before
	public void before() {
	}
	
	@Test
	public void testGetAllItems() throws Exception {
		itemService.getAllInventoryItems();
		verify(itemDao).getAllInventoryItems();
	}
}
