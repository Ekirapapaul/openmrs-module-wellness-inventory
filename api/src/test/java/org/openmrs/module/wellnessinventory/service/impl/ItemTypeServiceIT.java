package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemService;
import org.openmrs.module.wellnessinventory.api.service.ItemTypeService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;

public class ItemTypeServiceIT extends BaseModuleContextSensitiveTest {
	
	@Autowired
	private ItemTypeService itemTypeService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
	}
	
	@Test
	public void testGetAllItems() throws Exception {
		List<ItemType> items = itemTypeService.getAllItemTypes();
		Assert.assertEquals(2, items.size());
	}
	
	@Test
	public void shouldSaveItem() {
		ItemType itemType = new ItemType();
		itemType.setName("new");
		itemType.setUuid("f08c3ff4-7b8e-11e8-b051-9ff718629e8a");
		itemType.setCreator(Context.getAuthenticatedUser());
		itemType.setDateCreated(new Date());
		ItemType itsavedItem = itemTypeService.saveItemType(itemType);
		//        Assert.assertNotNull(itsavedItem);
		Assert.assertEquals(itemType, itsavedItem);
		
		List<ItemType> itemTypes = Context.getService(ItemTypeService.class).getAllItemTypes();
		Assert.assertEquals(3, itemTypes.size());
	}
}
