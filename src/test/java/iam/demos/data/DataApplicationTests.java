package iam.demos.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class DataApplicationTests {
    @Autowired
    CoffeeRepository coffeeRepository;

    @Before
    public void setUp() throws Exception {
        coffeeRepository.save(new Coffee("latte", 3.48f));
        coffeeRepository.save(new Coffee("americano", 2.18f));
    }

    @Test
    public void contextLoads() {
        for (Coffee coffee : coffeeRepository.findAll()) {
            switch (coffee.getName()) {
                case "latte":
                    assert coffee.getPrice() == 3.48f;
                    break;
                case "americano":
                    assert coffee.getPrice() == 2.18f;
                    break;
            }
        }
    }
}
