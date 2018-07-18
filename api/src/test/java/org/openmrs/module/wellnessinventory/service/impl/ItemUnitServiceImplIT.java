package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.model.ItemUnit;
import org.openmrs.module.wellnessinventory.api.service.ItemUnitService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.List;

public class ItemUnitServiceImplIT extends BaseModuleContextSensitiveTest {
	
	private ItemUnitService itemUnitService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
		itemUnitService = Context.getService(ItemUnitService.class);
	}
	
	@Test
	public void shouldGetAllItemUnits() throws Exception {
		List<ItemUnit> items = itemUnitService.getAllUnits();
		Assert.assertEquals(2, items.size());
	}
	
	@Test
	public void shouldGetItemUnitById() {
		ItemUnit unit = itemUnitService.getItemUnit(1);
		Assert.assertEquals(Integer.valueOf(1), unit.getId());
	}
	
	@Test
	public void shouldSaveUnit() {
		ItemUnit itemUnit = new ItemUnit();
		itemUnit.setName("Bottles");
		itemUnit.setDescription("Bottles");
		itemUnitService.saveItemUnit(itemUnit);
		
		List<ItemUnit> items = itemUnitService.getAllUnits();
		Assert.assertEquals(3, items.size());
	}
}
