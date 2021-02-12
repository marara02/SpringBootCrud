package kz.stud.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Food")


public class Food {
    @Id
    private String id;
    private String food_name;
    private double food_price;

    public Food(String food_name, double food_price) {
        this.food_name = food_name;
        this.food_price = food_price;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public double getFood_price() {
        return food_price;
    }

    public void setFood_price(double food_cost) {
        this.food_price = food_cost;
    }
}



