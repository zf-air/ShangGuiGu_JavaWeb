package com.zf.service;

import com.zf.pojo.GuihuanRecord;
import com.zf.pojo.ZulinRecord;

import java.util.List;

public interface RecordService {
    public int saveZulinRecord(String username, String carname, String date, int days, double totalprice);

    public int saveGuihuanRecord(String username, String carname, String date);

    public List<ZulinRecord> queryZulinAllRecords();

    public List<ZulinRecord> queryZulinNoGuihuanRecords();

    public ZulinRecord queryZulinRecordByUserAndCar(String username, String carname);

    public List<ZulinRecord> queryZulinAllRecordsByUser(String username);

    public List<ZulinRecord> queryZulinNoGuihuanRecordsByUser(String username);

    public List<ZulinRecord> queryZulinAndGuihuanRecordsByUser(String username);

    public GuihuanRecord queryGuihuanRecordByUserAndCar(String username, String carname);

    public List<GuihuanRecord> queryGuihuanAllRecords();

    public List<GuihuanRecord> queryGuihuanAllRecordsByUser(String username);

    public void updateOrder(ZulinRecord zulinRecord);
}
