package kz.stud.demo.controller;

import kz.stud.demo.model.Food;
import kz.stud.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class shopController {

    @Autowired
    private ShopRepository shopRepository;
/*
    @PostMapping("/addFood")
    public String saveFood(@RequestBody Food food){
        shopRepository.save(food);
        return "Food added successfully: " + food.getFood_name();
    }
    @GetMapping("/findAllFoods")
    public List<Food> getFoods(){
        return shopRepository.findAll();
    }
    @GetMapping("/findAllFoods/{id}")
    public Optional<Food> getFood(@PathVariable String id){
        return shopRepository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteFood(@PathVariable String id){
        shopRepository.deleteById(id);
        return "Food deleted with id: " + id;
    }
*/

    @GetMapping("/GetFood")
    public ResponseEntity<List<Food>> getAllFood(@RequestParam(required = false) String food_name) {
        try {
            List<Food> list_of_foods = new ArrayList<>();
            if (food_name == null || food_name.isEmpty()) {
                list_of_foods.addAll(shopRepository.findAll());
            }

            if (list_of_foods.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list_of_foods, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Food/{id}")
    public ResponseEntity<Food> getFoodByID(@PathVariable("id") String id) {
        try {
            Optional<Food> foodOptional = shopRepository.findById(id);
            return new ResponseEntity<>(foodOptional.get(), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/AddFood")
    public ResponseEntity<Food> addFoodToShop(@RequestBody Food food) {
        try {
            Food createdFood = shopRepository.save(new Food(food.getFood_name(), food.getFood_price()));
            return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/UpdateFood{id}")
    public ResponseEntity<Food> updateFood(@PathVariable("id") String id, @RequestBody Food shop) {
        Optional<Food> foodOptional = shopRepository.findById(id);
        if (foodOptional.isPresent()) {
            Food updateFood = foodOptional.get();
            updateFood.setFood_name(shop.getFood_name());
            updateFood.setFood_price(shop.getFood_price());
            return new ResponseEntity<>(shopRepository.save(updateFood), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/DeleteFood/{id}")
    public ResponseEntity<HttpStatus> deleteFood(@PathVariable("id") String id) {
        try {
            shopRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}