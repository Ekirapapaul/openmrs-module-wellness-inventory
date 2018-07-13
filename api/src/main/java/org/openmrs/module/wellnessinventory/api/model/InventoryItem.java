package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity(name = "InventoryItem")
@Table(name = "inventory_item")
public class InventoryItem extends BaseOpenmrsData {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "item_id", nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "item_code", length = 30)
	private String itemCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private ItemType itemType;
	
	@Transient
	private int itemsNum = 0;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	private Set<ItemStockDetails> details = new HashSet<ItemStockDetails>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
    private Set<ItemOrder> orders = new HashSet<ItemOrder>();
	
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
	
	public ItemType getItemType() {
		return itemType;
	}
	
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	public Set<ItemStockDetails> getDetails() {
		return details;
	}
	
	public void setDetails(Set<ItemStockDetails> details) {
		this.details = details;
	}
	
	public int getItemsNum() {
		Iterator<ItemStockDetails> iterator = getDetails().iterator();
		if (iterator.hasNext()) {
			ItemStockDetails stockDetail = iterator.next();
			itemsNum = stockDetail.getQuantity();
		}
		return itemsNum;
	}
	
	public void setItemsNum(int itemsNum) {
		this.itemsNum = itemsNum;
	}

    public Set<ItemOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<ItemOrder> orders) {
        this.orders = orders;
    }
}
