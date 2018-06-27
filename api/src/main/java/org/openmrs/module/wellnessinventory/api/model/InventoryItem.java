package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

public class InventoryItem extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	private Integer itemId;
	
	private String name;
	
	private String description;
	
	private String itemCode;
	
	@Override
	public Integer getId() {
		return this.itemId;
	}
	
	@Override
	public void setId(Integer id) {
		this.itemId = id;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	
	public String getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}
