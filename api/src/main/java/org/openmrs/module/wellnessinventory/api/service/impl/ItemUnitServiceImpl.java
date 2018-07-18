package org.openmrs.module.wellnessinventory.api.service.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.ItemUnitDao;
import org.openmrs.module.wellnessinventory.api.model.ItemUnit;
import org.openmrs.module.wellnessinventory.api.service.ItemUnitService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemUnitServiceImpl extends BaseOpenmrsService implements ItemUnitService {

    private ItemUnitDao itemUnitDao;

    public ItemUnitDao getItemUnitDao() {
        return itemUnitDao;
    }

    public void setItemUnitDao(ItemUnitDao itemUnitDao) {
        this.itemUnitDao = itemUnitDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemUnit> getAllUnits() {
        return itemUnitDao.getAllUnits();
    }

    @Override
    @Transactional(readOnly = true)
    public ItemUnit getItemUnit(Integer unitId) {
        return itemUnitDao.getItemUnit(unitId);
    }

    @Override
    @Transactional
    public ItemUnit saveItemUnit(ItemUnit itemUnit) {
        return itemUnitDao.saveItemUnit(itemUnit);
    }

    @Override
    @Transactional
    public void purgeItemUnit(ItemUnit itemUnit) {
        itemUnitDao.purgeItemUnit(itemUnit);
    }
}
