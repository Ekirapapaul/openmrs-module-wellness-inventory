package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ItemOrder")
@Table(name = "inventory_item_order")
public class ItemOrder extends BaseOpenmrsData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private InventoryItem inventoryItem;


    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "delivery_date", nullable = true)
    private Date deliveryDate;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "payment_mode", nullable = true)
    private String paymentMode;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
