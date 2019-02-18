package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.service.InventoryOrderService;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemOrderServiceImplIT extends BaseModuleContextSensitiveTest {
	
	private InventoryOrderService orderService;
	
	private InventoryService itemService;
	
	@Autowired
	PatientService patientService;
	
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
		itemOrder.setQuantity(4);
		itemOrder.setPaymentMode("MPESA");
		itemOrder.setInventoryItem(inventoryItem);
		itemOrder.setAddress("Nairobi");
		itemOrder.seIsDelivery(false);
		orderService.saveOrder(itemOrder);
		
		List<ItemOrder> items = orderService.getAllOrders();
		Assert.assertEquals(2, items.size());
		
		InventoryItem updatedInventoryItem = itemService.getInventoryItem(1);
		Assert.assertEquals(42, updatedInventoryItem.getDetails().iterator().next().getQuantity());
	}
	
	@Test
	public void shouldSaveAndDispenseOrder() {
		InventoryItem inventoryItem = itemService.getInventoryItem(1);
		ItemOrder itemOrder = new ItemOrder();
		itemOrder.setQuantity(4);
		itemOrder.setPaymentMode("MPESA");
		itemOrder.setInventoryItem(inventoryItem);
		itemOrder.setAddress("Nairobi");
		itemOrder.seIsDelivery(false);
		orderService.saveAnDispenseOrder(itemOrder);
		
		List<ItemOrder> items = orderService.getAllOrders();
		Assert.assertEquals(2, items.size());
		
		InventoryItem updatedInventoryItem = itemService.getInventoryItem(1);
		Assert.assertEquals(38, updatedInventoryItem.getDetails().iterator().next().getQuantity());
	}
	
	@Test
	public void shouldDispenseOrder() {
		InventoryItem inventoryItem = itemService.getInventoryItem(1);
		ItemOrder itemOrder = new ItemOrder();
		itemOrder.setQuantity(4);
		itemOrder.setPaymentMode("MPESA");
		itemOrder.setInventoryItem(inventoryItem);
		itemOrder.setAddress("Nairobi");
		itemOrder.seIsDelivery(false);
		itemOrder = orderService.saveOrder(itemOrder);
		orderService.dispenseOrder(itemOrder);
		
		List<ItemOrder> items = orderService.getAllOrders();
		Assert.assertEquals(2, items.size());
		
		InventoryItem updatedInventoryItem = itemService.getInventoryItem(1);
		Assert.assertEquals(38, updatedInventoryItem.getDetails().iterator().next().getQuantity());
	}
	
	@Test
	public void shouldGetPatientOrders() {
		Patient patient = patientService.getPatient(12);
		Assert.assertNotNull(patient);
		List<ItemOrder> orders = orderService.getClientOrders(patient);
		Assert.assertEquals(1, orders.size());
	}
	
	@Test
	public void shouldGetPatientOrdersByPatientId() {
		Patient patient = patientService.getPatient(12);
		Assert.assertNotNull(patient);
		List<ItemOrder> orders = orderService.getClientOrders(12);
		Assert.assertEquals(1, orders.size());
	}
}
