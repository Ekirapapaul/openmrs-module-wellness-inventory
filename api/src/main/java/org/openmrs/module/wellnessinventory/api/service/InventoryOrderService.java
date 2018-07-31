package org.openmrs.module.wellnessinventory.api.service;

import org.openmrs.Patient;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.wellnessinventory.api.model.ItemOrder;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;

import java.util.List;

public interface InventoryOrderService extends OpenmrsService {
	
	/**
	 * Gets a list all orders.
	 * 
	 * @return all orders list.
	 */
	List<ItemOrder> getAllOrders();
	
	/**
	 * Gets an order by id
	 * 
	 * @param orderId
	 * @return the order with the given id
	 */
	ItemOrder getOrder(Integer orderId);
	
	/**
	 * Saves a new or existing order
	 * 
	 * @param order the order to save.
	 * @return the saved order.
	 */
	ItemOrder saveOrder(ItemOrder order);

    /**
     * Gets a patients supplement orders by patient object
     *
     * @param patient the patient instance.
     * @return the list of orders.
     */
    List<ItemOrder> getClientOrders(Patient patient);

    /**
     * Gets a patients supplement orders by patient id
     *
     * @param patientId the patient instance.
     * @return the list of orders.
     */
    List<ItemOrder> getClientOrders(Integer patientId);
	
	/**
	 * Deletes an order
	 * 
	 * @param itemOrder the room to delete.
	 */
	void purgeItemType(ItemOrder itemOrder);
}
