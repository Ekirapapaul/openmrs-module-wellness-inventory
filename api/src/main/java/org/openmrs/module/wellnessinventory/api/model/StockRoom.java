package org.openmrs.module.wellnessinventory.api.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Location;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "StockRoom")
@Table(name = "inventory_stock_room")
public class StockRoom extends BaseOpenmrsData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "room_id", nullable = false)
    private Integer room_id;

    @Basic
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public StockRoom() {

    }

    public Integer getId() {
        return this.room_id;
    }

    @Override
    public void setId(Integer id) {
        this.room_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
