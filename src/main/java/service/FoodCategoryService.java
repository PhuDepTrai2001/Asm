package service;

import entity.FoodCategory;
import repository.CategoryRepository;
import repository.ICategoryRepository;

import java.util.ArrayList;
import java.util.Date;

public class FoodCategoryService {
    ICategoryRepository iCategoryRepository = new CategoryRepository();
    public boolean create(FoodCategory foodCategory){
        if(foodCategory.validate()){
            foodCategory.setCreatedAt(new Date());
            foodCategory.setUpdatedAt(new Date());
            return iCategoryRepository.save(foodCategory);
        }
        return false;
    };
    public FoodCategory edit(FoodCategory foodCategory){
        if(foodCategory.validate()&&iCategoryRepository.findById(foodCategory.getId())!=null){
            foodCategory.setUpdatedAt(new Date());
            return iCategoryRepository.update(foodCategory);
        }
        return null;
    }
    public boolean delete(Object id){
        FoodCategory category =iCategoryRepository.findById(id);
        if(category!=null&&category.getStatus()!=0){
            category.setStatus(0);
            iCategoryRepository.update(category);
            return true;
        }
        return false;
    }
    public ArrayList<FoodCategory> findAll(){
        return iCategoryRepository.findAll();
    }
}
