package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.*;

@Entity(name = "InventopryItem")
@Table(name = "inventory_item_stock")
public class ItemStock extends BaseOpenmrsData {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "stock_id", nullable = false)
	private Integer id;
	
	@Column(name = "quantity", nullable = false)
	private int quantity = 0;
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer id) {
		
	}
}
