package org.openmrs.module.wellnessinventory.api.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.wellnessinventory.api.dao.StockRoomDao;
import org.openmrs.module.wellnessinventory.api.model.StockRoom;
import org.openmrs.module.wellnessinventory.api.service.StockRoomService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StockRoomServiceImpl extends BaseOpenmrsService implements StockRoomService {

    protected final Log log = LogFactory.getLog(this.getClass());

    private StockRoomDao stockRoomDao;

    public StockRoomDao getStockRoomDao() {
        return stockRoomDao;
    }

    public void setStockRoomDao(StockRoomDao stockRoomDao) {
        this.stockRoomDao = stockRoomDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StockRoom> getAllStockRooms() {
        return stockRoomDao.getAllStockRooms();
    }

    @Override
    @Transactional(readOnly = true)
    public StockRoom getItemType(Integer id) {
        return stockRoomDao.getStockRoom(id);
    }

    @Override
    @Transactional
    public StockRoom saveItemType(StockRoom stockRoom) {
        return stockRoomDao.saveStockRoom(stockRoom);
    }

    @Override
    @Transactional
    public void purgeItemType(StockRoom stockRoom) {
        stockRoomDao.purgeStockRoom(stockRoom);
    }
}
