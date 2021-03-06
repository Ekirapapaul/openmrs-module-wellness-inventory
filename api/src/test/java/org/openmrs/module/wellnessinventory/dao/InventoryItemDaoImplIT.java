package org.openmrs.module.wellnessinventory.dao;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openmrs.module.wellnessinventory.api.dao.InventoryItemDao;
import org.openmrs.module.wellnessinventory.api.dao.impl.InventoryItemDaoImpl;
import org.openmrs.module.wellnessinventory.api.model.InventoryItem;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.test.context.ContextConfiguration(locations = { "classpath:TestingApplicationContext.xml" }, inheritLocations = true)
public class InventoryItemDaoImplIT extends BaseModuleContextSensitiveTest {
	
	@Autowired
	InventoryItemDao itemDao;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Before
	public void beforeAllTests() throws Exception {
		executeDataSet("inventoryItems.xml");
	}
	
	@Test
	public void shouldGetAllItems() {
		List<InventoryItem> inventoryItems = itemDao.getAllInventoryItems();
		Assert.assertEquals(4, inventoryItems.size());
	}
	
	@Test
	public void shouldAddItemTypes() {
		
	}
}
