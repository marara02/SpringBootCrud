package kz.stud.demo;

import kz.stud.demo.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public
class DemoApplicationTests {
    @Autowired
    private ShopRepository shopRepository;

    @Test
    void contextLoads() {
    }
}
