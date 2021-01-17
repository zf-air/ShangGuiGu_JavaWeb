package com.zf.dao.impl;

import com.zf.dao.CarDao;
import com.zf.pojo.Car;

import java.util.List;

public class CarDaoImpl extends BaseDao implements CarDao {
    @Override
    public int addCar(Car car) {
        String sql = "insert into car_info(`name`,`type`,`price`,`stock`,`img_path`) values(?,?,?,?,?)";
        return update(sql,  car.getName(), car.getType(), car.getPrice(), car.getStock(),car.getImg_path());
    }

    @Override
    public int deleteCarByName(String name) {
        String sql = "delete from car_info where name = ?";
        return update(sql, name);
    }

    @Override
    public int updateCar(Car car) {
        String sql = "update car_info set `name`=?,`type`=?,`price`=?,`stock`=?,`img_path`=? where name = ?";
        return update(sql, car.getName(), car.getType(), car.getPrice(), car.getStock(),car.getImg_path(), car.getName());
    }

    @Override
    public Car queryCarByName(String name) {
        String sql = "select `name` , `type` , `price` , `stock`, `img_path` from car_info where name = ?";
        return queryForOne(Car.class, sql, name);
    }

    @Override
    public List<Car> queryCarByType(String type) {
        String sql = "select `name` , `type` , `price` , `stock`,`img_path` from car_info where type = ?";
        return queryForList(Car.class, sql, type);
    }


    @Override
    public List<Car> queryCars() {
        String sql = "select `name` , `type` , `price` ,  `stock` , `img_path`  from car_info";
        return queryForList(Car.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from car_info";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Car> queryForPageItems(int begin, int pageSize) {
        String sql = "select `name` , `type` , `price` ,  `stock` , `img_path` from car_info limit ?,?";
        return queryForList(Car.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from car_info where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Car> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `name`,`type`,`price`,`stock`,`img_path` " +
                "from car_info where price between ? and ? order by price limit ?,?";
        return queryForList(Car.class, sql, min, max, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByType(String type) {
        String sql = "select count(*) from car_info where type = ?";
        Number count = (Number) queryForSingleValue(sql, type);
        return count.intValue();
    }

    @Override
    public List<Car> queryForPageItemsByType(int begin, int pageSize, String type) {
        String sql = "select `name`,`type`,`price`,`stock`,`img_path` " +
                "from car_info where type = ? order by price limit ?,?";
        return queryForList(Car.class, sql, type, begin, pageSize);
    }
}
