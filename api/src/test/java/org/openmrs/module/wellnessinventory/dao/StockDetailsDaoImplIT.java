package org.openmrs.module.wellnessinventory.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemTypeDao;
import org.openmrs.module.wellnessinventory.api.dao.StockDetailsDao;
import org.openmrs.module.wellnessinventory.api.model.ItemStockDetails;
import org.openmrs.module.wellnessinventory.api.model.ItemType;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.test.context.ContextConfiguration(locations = {"classpath:TestingApplicationContext.xml"}, inheritLocations = true)
public class StockDetailsDaoImplIT extends BaseModuleContextSensitiveTest {

    @Autowired
    StockDetailsDao stockDetailsDao;

    @Before
    public void beforeAllTests() throws Exception {
        executeDataSet("inventoryItems.xml");
    }

    @Test
    public void shouldGetAllItems() {
        List<ItemStockDetails> stockDetails = stockDetailsDao.getAllStockDetails();
        Assert.assertEquals(1, stockDetails.size());
    }

    @Test
    public void shouldGetStockDetailById() {
        ItemStockDetails stockDetails = stockDetailsDao.getStockDetails(1);
        Assert.assertEquals(1, (int) stockDetails.getId());
    }

    @Test
    public void shuldSaveSockDetail(){
        ItemStockDetails stockDetail = new ItemStockDetails();
        stockDetail.setName("TRIAL");
        stockDetail.setExpiration(new Date());
        stockDetail.setQuantity(45);
        stockDetail.setUuid("ItemStockDetails");

        stockDetailsDao.saveStockDetails(stockDetail);

        Assert.assertEquals(2, stockDetailsDao.getAllStockDetails().size());

    }

}
