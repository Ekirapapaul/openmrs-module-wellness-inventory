package org.openmrs.module.wellnessinventory.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.module.wellnessinventory.api.service.InventoryService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Test
    public void shouldGetStockDetailsByItemId() {
        Set<ItemStockDetails> stockDetails = itemService.getStockDetaisByItemId(1);
        Assert.assertEquals(1, stockDetails.size());

    }

    @Test
    public void shouldNotGetStockDetailsByItemId() {
        Set<ItemStockDetails> stockDetails = itemService.getStockDetaisByItemId(2);
        Assert.assertEquals(0, stockDetails.size());

    }

    @Test
    public void shuldSaveSockDetail() {
        ItemStockDetails stockDetail = new ItemStockDetails();
        stockDetail.setName("TRIAL");
        stockDetail.setExpiration(new Date());
        stockDetail.setQuantity(45);
        stockDetail.setUuid("ItemStockDetails");

        InventoryItem inventoryItem = itemService.getInventoryItem(1);
        stockDetail.setInventoryItem(inventoryItem);

        itemService.saveItemStockDetail(stockDetail);
        Assert.assertEquals(2, itemService.getStockDetaisByItemId(1).size());

    }
}
