package com.zf.dao;

import com.zf.pojo.GuihuanRecord;
import com.zf.pojo.ZulinRecord;

import java.util.List;

public interface RecordDao {
    //保存租赁记录
    public int saveZulinRecord(String username, String carname, String date, int days, double totalprice);

    //保存归还记录
    public int saveGuihuanRecord(String username, String carname, String date);

    //通过用户和汽车查询租赁记录
    public ZulinRecord queryZulinRecordByUserAndCar(String username, String carname);

    //通过用户和汽车查询归还记录
    public GuihuanRecord queryGuihuanRecordByUserAndCar(String username, String carname);

    //通过用户查询所有租赁记录
    public List<ZulinRecord> queryZulinAllRecordsByUser(String username);

    //通过用户查询所有租赁未归还的记录
    public List<ZulinRecord> queryZulinNoGuihuanRecordsByUser(String username);

    //通过用户查询所有租赁已归还的记录
    public List<ZulinRecord> queryZulinAndGuihuanRecordsByUser(String username);

    //通过用户查询所有归还记录
    public List<GuihuanRecord> queryGuihuanAllRecordsByUser(String username);

    //查询所有租赁记录
    public List<ZulinRecord> queryZulinAllRecords();

    //查询所有租赁未归还的记录
    public List<ZulinRecord> queryZulinNoGuihuanRecords();

    //查询所有归还记录
    public List<GuihuanRecord> queryGuihuanAllRecords();

    //修改租赁记录
    public int updateZulinRecord(ZulinRecord zulinRecord);
}
