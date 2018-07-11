package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ItemStockDetails")
@Table(name = "inventory_stock_details")
public class ItemStockDetails extends BaseOpenmrsData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "detail_id", nullable = false)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "details")
    private Set<InventoryItem> inventoryItems = new HashSet<InventoryItem>();

    @Column(name = "quantity", nullable = false)
    private int quantity = 0;

    @Column(name = "name")
    private String name;

    @Column(name = "expiration")
    private Date expiration;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Set<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Set<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}
