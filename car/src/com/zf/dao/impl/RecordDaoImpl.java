package com.zf.dao.impl;

import com.zf.dao.RecordDao;
import com.zf.pojo.GuihuanRecord;
import com.zf.pojo.ZulinRecord;

import java.util.List;

public class RecordDaoImpl extends BaseDao implements RecordDao {

    @Override
    public int saveZulinRecord(String username, String carname, String date, int days, double totalprice) {
        String sql = "insert into zulin_info(`username`,`carname`,`date`,`days`,`totalprice`) values(?,?,?,?,?)";
        return update(sql, username, carname, date, days, totalprice);
    }

    @Override
    public int saveGuihuanRecord(String username, String carname, String date) {
        String sql = "insert into guihuan_info(`username`,`carname`,`date`) values(?,?,?)";
        return update(sql, username, carname, date);
    }

    @Override
    public ZulinRecord queryZulinRecordByUserAndCar(String username, String carname) {
        String sql = "select * from zulin_info where username = ? && carname = ?";
        return queryForOne(ZulinRecord.class, sql, username, carname);
    }


    @Override
    public GuihuanRecord queryGuihuanRecordByUserAndCar(String username, String carname) {
        String sql = "select * from guihuan_info where username = ? && carname = ?";
        return queryForOne(GuihuanRecord.class, sql, username, carname);
    }

    @Override
    public List<ZulinRecord> queryZulinAllRecordsByUser(String username) {
        String sql = "select * from zulin_info where username = ? limit 0,10";
        return queryForList(ZulinRecord.class, sql, username);
    }

    @Override
    public List<GuihuanRecord> queryGuihuanAllRecordsByUser(String username) {
        String sql = "select * from guihuan_info where username = ? limit 0,10";
        return queryForList(GuihuanRecord.class, sql, username);
    }

    @Override
    public List<ZulinRecord> queryZulinNoGuihuanRecordsByUser(String username) {
        String sql = "select * from zulin_info where username = ? and state ='租赁未归还' limit 0,10";
        return queryForList(ZulinRecord.class, sql, username);
    }

    @Override
    public List<ZulinRecord> queryZulinAndGuihuanRecordsByUser(String username) {
        String sql = "select * from zulin_info where username = ? and state ='租赁已归还' limit 0,10";
        return queryForList(ZulinRecord.class, sql, username);
    }

    @Override
    public List<ZulinRecord> queryZulinAllRecords() {
        String sql = "select * from zulin_info ";
        return queryForList(ZulinRecord.class, sql);
    }

    @Override
    public List<ZulinRecord> queryZulinNoGuihuanRecords() {
        String sql = "select * from guihuan_info where state = '租赁未归还' limit 0,10";
        return queryForList(ZulinRecord.class, sql);
    }

    @Override
    public List<GuihuanRecord> queryGuihuanAllRecords() {
        String sql = "select * from guihuan_info limit 0,10";
        return queryForList(GuihuanRecord.class, sql);
    }

    @Override
    public int updateZulinRecord(ZulinRecord zulinRecord) {
        String sql = "update zulin_info set `username`=?,`carname`=?,`date`=?,`days`=?,`totalprice`=?,`state`=? where username=? and carname = ?";
        return update(sql,zulinRecord.getUsername(),zulinRecord.getCarname(),zulinRecord.getDate(),zulinRecord.getDays(),
                zulinRecord.getTotalprice(),zulinRecord.getState(),zulinRecord.getUsername(),zulinRecord.getCarname());
    }
}
