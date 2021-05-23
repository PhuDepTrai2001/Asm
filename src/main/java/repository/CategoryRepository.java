package repository;

import entity.Food;
import entity.FoodCategory;

import java.util.ArrayList;

public class CategoryRepository implements ICategoryRepository{
    GenericRepository<FoodCategory> repository = new GenericRepository<>(FoodCategory.class);
    @Override
    public boolean save(FoodCategory category) {
        return repository.save(category);
    }

    @Override
    public ArrayList<FoodCategory> findAll() {
        return repository.findByCondition("SELECT * FROM food_categories WHERE status != 0");
    }

    @Override
    public FoodCategory findById(Object id) {
        return repository.findById(id);
    }

    @Override
    public ArrayList<FoodCategory> findByCondition(String strCmd) {
        return repository.findByCondition(strCmd);
    }

    @Override
    public FoodCategory update(FoodCategory category) {
        return repository.update(category);
    }

    @Override
    public boolean delete(Object id) {
        return repository.delete(id);
    }
}
