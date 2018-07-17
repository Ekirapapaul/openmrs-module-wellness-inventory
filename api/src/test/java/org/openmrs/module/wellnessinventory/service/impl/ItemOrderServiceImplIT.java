package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.service.InventoryOrderService;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.List;

public class ItemOrderServiceImplIT extends BaseModuleContextSensitiveTest {
	
	private InventoryOrderService orderService;
	
	private InventoryService itemService;
	
	@Before
	public void before() throws Exception {
		executeDataSet("inventoryItems.xml");
		orderService = Context.getService(InventoryOrderService.class);
		itemService = Context.getService(InventoryService.class);
	}
	
	@Test
	public void testGetAllItemTypess() throws Exception {
		List<ItemOrder> items = orderService.getAllOrders();
		Assert.assertEquals(1, items.size());
	}
	
	@Test
	public void shouldGetOrderById() {
		ItemOrder order = orderService.getOrder(1);
		Assert.assertEquals(false, order.getIsDelivery());
		Assert.assertEquals(Integer.valueOf(1), order.getId());
	}
	
	@Test
	public void shouldSaveOrder() {
		InventoryItem inventoryItem = itemService.getInventoryItem(1);
		ItemOrder itemOrder = new ItemOrder();
		itemOrder.setQuantity(40);
		itemOrder.setPaymentMode("MPESA");
		itemOrder.setInventoryItem(inventoryItem);
		itemOrder.setAddress("Nairobi");
		itemOrder.seIsDelivery(false);
		orderService.saveOrder(itemOrder);
		
		List<ItemOrder> items = orderService.getAllOrders();
		Assert.assertEquals(2, items.size());
	}
}
