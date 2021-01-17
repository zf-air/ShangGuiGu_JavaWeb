package com.zf.dao;

import com.zf.pojo.Car;

import java.util.List;

public interface CarDao {

    public int addCar(Car car);

    public int deleteCarByName(String name);

    public int updateCar(Car car);

    public Car queryCarByName(String name);

    public List<Car> queryCarByType(String type);

    public List<Car> queryCars();

    Integer queryForPageTotalCount();

    List<Car> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Car> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

    Integer queryForPageTotalCountByType(String type);

    List<Car> queryForPageItemsByType(int begin, int pageSize, String type);
}
