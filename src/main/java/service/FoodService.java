package service;

import entity.Food;
import helper.PasswordUtil;
import repository.FoodRepository;

public class FoodService {
    private FoodRepository foodRepository = new FoodRepository();

    public boolean createFood(Food food) {
        try {
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            food.setCreatedAt(date);
            food.setUpdatedAt(date);
            foodRepository.save(food);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
