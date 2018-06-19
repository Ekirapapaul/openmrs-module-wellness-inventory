package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

public class InventoryItem extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer itemId;
	
	private String name;
	
	private String description;
	
	private String itemCode;
	
	public String getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getItemId() {
		return itemCode;
	}
	
	public void setItemId(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public Integer getId() {
		return itemId;
	}
	
	@Override
	public void setId(Integer integer) {
		this.itemId = integer;
	}
}
