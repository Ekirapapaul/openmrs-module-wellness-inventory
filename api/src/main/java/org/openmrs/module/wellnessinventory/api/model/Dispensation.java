package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "Dispensation")
@Table(name = "inventory_dispensation")
public class Dispensation extends BaseOpenmrsData {

    @Id
    @GeneratedValue
    @Column(name = "dispensation_id", nullable = false)
    private Integer id;

    @Column(name = "dispensation_date")
    private Date deliveryDate;

    @ManyToOne
    @JoinColumn(name = "dispensed_by", nullable = true)
    private User dispensedBy;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public User getDispensedBy() {
        return dispensedBy;
    }

    public void setDispensedBy(User dispensedBy) {
        this.dispensedBy = dispensedBy;
    }
}
