package org.openmrs.module.wellnessinventory.api.dao;

import org.openmrs.Patient;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface ItemOrderDao {
	
	public List<ItemOrder> getAllOrders();
	
	ItemOrder getItemOrder(Integer id);

    List<ItemOrder> getClientOrders(Patient patient);

    List<ItemOrder> getClientOrders(Integer patientId);
	
	ItemOrder saveItemOrder(ItemOrder order);
	
	void purgeItemOrder(ItemOrder order);
}
