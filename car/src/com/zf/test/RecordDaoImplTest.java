package com.zf.test;

import com.zf.dao.RecordDao;
import com.zf.dao.impl.RecordDaoImpl;
import com.zf.pojo.ZulinRecord;
import org.junit.Test;

import java.util.List;

public class RecordDaoImplTest {
    private RecordDao recordDao = new RecordDaoImpl();

    @Test
    public void saveZulinRecord() {
        recordDao.saveZulinRecord("zhangfan","488","2020-12-12",10,1000);
    }

    @Test
    public void saveGuihuanRecord() {
        recordDao.saveGuihuanRecord("zhangfan","911","2020-12-13");
    }

    @Test
    public void queryZulinRecordByUserAndCar() {
        System.out.println(recordDao.queryZulinRecordByUserAndCar("zhangfan","911"));
    }

    @Test
    public void queryGuihuanRecordByUserAndCar() {
        System.out.println(recordDao.queryGuihuanRecordByUserAndCar("zhangfan","911"));
    }

    @Test
    public void updateZulinRecord(){
        recordDao.updateZulinRecord(new ZulinRecord("zhangfan","911","2020-12-12",10,1000.0,""));
    }

    @Test
    public void queryZulinAllRecords(){
        List<ZulinRecord> zulinRecords = recordDao.queryZulinAllRecords();
        for(ZulinRecord zulinRecord : zulinRecords){
            System.out.println(zulinRecord);
        }
    }
}