package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

public class InventoryItem extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String description;
	
	private int itemId;
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		return this.itemId;
	}
	
	@Override
	public void setId(Integer integer) {
		this.itemId = itemId;
	}
}
