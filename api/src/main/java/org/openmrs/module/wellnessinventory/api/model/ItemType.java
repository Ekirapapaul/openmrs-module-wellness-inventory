package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.*;

@Entity(name = "ItemType")
@Table(name = "inventory_item_type")
public class ItemType extends BaseOpenmrsData {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "type_id", nullable = false)
	private Integer type_id;
	
	@Basic
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	public ItemType() {

	}
	
	public Integer getId() {
		return this.type_id;
	}
	
	@Override
	public void setId(Integer id) {
		this.type_id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
