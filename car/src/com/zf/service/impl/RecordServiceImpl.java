package com.zf.service.impl;

import com.zf.dao.RecordDao;
import com.zf.dao.impl.RecordDaoImpl;
import com.zf.pojo.GuihuanRecord;
import com.zf.pojo.ZulinRecord;
import com.zf.service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {
    private RecordDao recordDao = new RecordDaoImpl();

    @Override
    public int saveZulinRecord(String username, String carname, String date, int days, double totalprice) {
        return recordDao.saveZulinRecord(username, carname, date, days, totalprice);
    }

    @Override
    public int saveGuihuanRecord(String username, String carname, String date) {
        return recordDao.saveGuihuanRecord(username, carname, date);
    }

    @Override
    public List<ZulinRecord> queryZulinAllRecords() {
        return recordDao.queryZulinAllRecords();
    }

    @Override
    public List<ZulinRecord> queryZulinNoGuihuanRecords() {
        return recordDao.queryZulinNoGuihuanRecords();
    }

    @Override
    public ZulinRecord queryZulinRecordByUserAndCar(String username, String carname) {
        return recordDao.queryZulinRecordByUserAndCar(username,carname);
    }

    @Override
    public List<ZulinRecord> queryZulinAllRecordsByUser(String username) {
        return recordDao.queryZulinAllRecordsByUser(username);
    }

    @Override
    public List<ZulinRecord> queryZulinNoGuihuanRecordsByUser(String username) {
        return recordDao.queryZulinNoGuihuanRecordsByUser(username);
    }

    @Override
    public List<ZulinRecord> queryZulinAndGuihuanRecordsByUser(String username) {
        return recordDao.queryZulinAndGuihuanRecordsByUser(username);
    }

    @Override
    public GuihuanRecord queryGuihuanRecordByUserAndCar(String username, String carname) {
        return recordDao.queryGuihuanRecordByUserAndCar(username,carname);
    }

    @Override
    public List<GuihuanRecord> queryGuihuanAllRecords() {
        return recordDao.queryGuihuanAllRecords();
    }

    @Override
    public List<GuihuanRecord> queryGuihuanAllRecordsByUser(String username) {
        return recordDao.queryGuihuanAllRecordsByUser(username);
    }

    @Override
    public void updateOrder(ZulinRecord zulinRecord) {
        recordDao.updateZulinRecord(zulinRecord);
    }
}
