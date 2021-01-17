package com.zf.service;

import com.zf.pojo.Car;
import com.zf.pojo.Page;

import java.util.List;

public interface CarService {

    public void addCar(Car car);

    public void deleteCarByName(String name);

    public void updateCar(Car car);

    public Car queryCarByName(String name);

    public List<Car> queryCarByType(String type);

    public List<Car> queryCars();

    Page<Car> page(int pageNo, int pageSize);

    Page<Car> pageByPrice(int pageNo, int pageSize, int min, int max);

    Page<Car> pageByType(int pageNo, int pageSize, String type);
}
