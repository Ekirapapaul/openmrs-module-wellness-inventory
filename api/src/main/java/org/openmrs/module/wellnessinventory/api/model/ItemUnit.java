package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.*;

@Entity(name = "ItemUnit")
@Table(name = "inventory_item_unit")
public class ItemUnit extends BaseOpenmrsData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "unit_id", nullable = false)
    private Integer unit_id;

    @Basic
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Override
    public Integer getId() {
        return this.unit_id;
    }

    @Override
    public void setId(Integer id) {
        this.unit_id = id;
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
}
