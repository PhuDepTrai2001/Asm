package repository;


import entity.FoodCategory;

import java.util.ArrayList;

public interface ICategoryRepository {
    boolean save(FoodCategory foodCategory);
    ArrayList<FoodCategory> findAll();
    FoodCategory findById(Object id);
    ArrayList<FoodCategory> findByCondition(String strCmd);
    FoodCategory update(FoodCategory foodCategory);
    boolean delete(Object id);
}
