package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.service.InventoryItemTypeService;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.openmrs.module.wellnessinventory.api.service.impl.InventoryItemTypeServiceImpl;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;

public class InventoryTypeServiceImplIT extends BaseModuleContextSensitiveTest {
	
	private InventoryItemTypeService itemService;
	private InventoryService inventoryService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
		itemService = Context.getService(InventoryItemTypeService.class);
        inventoryService = Context.getService(InventoryService.class);
	}
	
	@Test
	public void testGetAllItemTypess() throws Exception {
		List<ItemType> items = itemService.getAllItemTypes();
		Assert.assertEquals(2, items.size());
	}
	
	@Test
	public void shouldSaveItemType() {
		ItemType itemType = new ItemType();
		itemType.setName("new");
		itemType.setUuid("f08c3ff4-7b8e-11e8-b051-9ff718629e8a");
		itemType.setCreator(Context.getAuthenticatedUser());
		itemType.setDateCreated(new Date());
		ItemType itsavedItem = itemService.saveItemType(itemType);
		//        Assert.assertNotNull(itsavedItem);
		Assert.assertEquals(itemType, itsavedItem);
		
		List<ItemType> itemTypes = Context.getService(InventoryItemTypeService.class).getAllItemTypes();
		Assert.assertEquals(3, itemTypes.size());
	}
	
	@Test
	public void shouldGetItemTypeById() {
		ItemType itemType = itemService.getItemType(1);
		Assert.assertEquals(1, (int) itemType.getId());
		Assert.assertEquals(2, itemType.getInventoryItems().size());
	}

	@Test
    public void shouldSetInventoryItems(){
        ItemType itemType = itemService.getItemType(1);
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setName("new");
        inventoryItem.setItemCode("4545");
        inventoryItem.setDescription("description");

        Set<InventoryItem> items = new HashSet<InventoryItem>();
        items.add(inventoryItem);

        itemType.setInventoryItems(items);
        Assert.assertEquals(3, itemType.getInventoryItems().size());
        System.out.println("Size" + inventoryService.getAllInventoryItems().size());
    }
}
