package kz.stud.demo.repository;

import kz.stud.demo.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Food, String> {
}
