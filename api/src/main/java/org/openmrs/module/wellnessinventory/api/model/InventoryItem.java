package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

public class InventoryItem extends BaseOpenmrsData {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String itemCode;
	
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
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
