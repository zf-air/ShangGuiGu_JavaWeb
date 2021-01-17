package com.zf.service.impl;


import com.zf.dao.CarDao;
import com.zf.dao.impl.CarDaoImpl;
import com.zf.pojo.Car;
import com.zf.pojo.Page;
import com.zf.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private CarDao carDao = new CarDaoImpl();

    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    public void deleteCarByName(String name) {
        carDao.deleteCarByName(name);
    }

    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }


    @Override
    public Car queryCarByName(String name) {
        return carDao.queryCarByName(name);
    }

    @Override
    public List<Car> queryCarByType(String type) {
        return carDao.queryCarByType(type);
    }

    @Override
    public List<Car> queryCars() {
        return carDao.queryCars();
    }

    @Override
    public Page<Car> page(int pageNo, int pageSize) {
        Page<Car> page = new Page<Car>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount =carDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Car> items = carDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Car> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Car> page = new Page<Car>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = carDao.queryForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Car> items = carDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Car> pageByType(int pageNo, int pageSize, String type) {
        Page<Car> page = new Page<Car>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = carDao.queryForPageTotalCountByType(type);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Car> items = carDao.queryForPageItemsByType(begin,pageSize,type);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
