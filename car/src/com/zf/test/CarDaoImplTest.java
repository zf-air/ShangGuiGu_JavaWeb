package com.zf.test;

import com.zf.dao.CarDao;
import com.zf.dao.impl.CarDaoImpl;
import com.zf.pojo.Car;
import com.zf.pojo.Page;
import org.junit.Test;

public class CarDaoImplTest {
    private CarDao carDao = new CarDaoImpl();

    @Test
    public void addCar() {
        carDao.addCar(new Car("奥迪R8", "跑车", 240.0, 10,"static/img/奥迪R8.jpg"));
    }


    @Test
    public void deleteCarByName() {
        carDao.deleteCarByName("通用别克英朗");
    }

    @Test
    //一定要改id
    public void updateCar() {
        carDao.updateCar(new Car( "大众朗逸", "轿车", 200, 10,"/static/img/大众朗逸.jpg"));
    }

    @Test
    public void queryCarByName() {
        System.out.println(carDao.queryCarByName("奥迪A6"));
    }

    @Test
    public void queryCarByType() {
        for (Car queryCar : carDao.queryCarByType("跑车")) {
            System.out.println(queryCar);
        }
    }

    @Test
    public void queryCars() {
        for (Car queryCar : carDao.queryCars()) {
            System.out.println(queryCar);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println( carDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Car car : carDao.queryForPageItems(0, Page.PAGE_SIZE)) {
            System.out.println(car);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println( carDao.queryForPageTotalCountByPrice(0,100));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Car car : carDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,0,100)) {
            System.out.println(car);
        }
    }

    @Test
    public void queryForPageItemsByType() {
        for (Car car : carDao.queryForPageItemsByType(0, Page.PAGE_SIZE,"跑车")) {
            System.out.println(car);
        }
    }

    @Test
    public void queryForPageTotalCountByType() {
        System.out.println( carDao.queryForPageTotalCountByType("跑车"));
    }
}