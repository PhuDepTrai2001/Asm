package controller;

import entity.Food;
import entity.FoodCategory;
import service.FoodCategoryService;
import service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Create extends HttpServlet {
    private FoodCategoryService foodCategoryService = new FoodCategoryService();
    private FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<FoodCategory> categories = foodCategoryService.findAll();
        req.setAttribute("status", "");
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/Food/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chạy vào đây");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String categoryId = req.getParameter("categoryId");
        String description = req.getParameter("description");
        String thumbnail = req.getParameter("thumbnail");
        String price = req.getParameter("price").length()>0?req.getParameter("price"):"0";
        Food food = new Food();
        food.setName(name);
        food.setCategoryId(Integer.parseInt(categoryId));
        food.setDescription(description);
        food.setThumbnail(thumbnail);
        food.setPrice(Double.valueOf(price));
        boolean res = foodService.createFood(food);
        if (!res) {
            req.setAttribute("categories", foodCategoryService.findAll());
            req.setAttribute("status", "Tạo món ăn thất bại yêu cầu nhập đầy đủ thông tin và đúng định dạng !!!!");
            req.getRequestDispatcher("/Food/create.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("/Food/list.jsp");
    }
}
