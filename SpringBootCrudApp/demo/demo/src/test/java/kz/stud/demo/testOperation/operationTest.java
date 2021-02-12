package kz.stud.demo.testOperation;


import kz.stud.demo.model.Food;
import kz.stud.demo.repository.ShopRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataMongoTest
public class operationTest {
    @Autowired
    private ShopRepository shopRepository;

    @Test
    @Rollback(value = false)

    public void testCreateTests(){
        Food savedFood = (Food)this.shopRepository.save(new Food("tea", 1.17));
        Assertions.assertThat(savedFood.getId());
    }

    @Test
    public void testFindAll(){
         List <Food> food = this.shopRepository.findAll();
         Assertions.assertThat(food).size().isGreaterThan(0);

    }
    }

