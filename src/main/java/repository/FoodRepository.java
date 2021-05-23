package repository;

import entity.Food;

public class FoodRepository {
    private GenericRepository<Food> genericRepository = new GenericRepository<>(Food.class);


    public boolean save(Food food) {
        genericRepository.save(food);
        return true;
    }
}
