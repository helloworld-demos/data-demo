package iam.demos.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CoffeeService {
    @Autowired
    CoffeeRepository coffeeRepository;

    @Cacheable("coffeePrice")
    // redis key will be "coffeePrice:${name}"
    public float findPriceBy(String name) {
        try {
            log.info("A really time expensive operation to get price for coffee: {}. It will take about 5 seconds", name);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Coffee coffee = coffeeRepository.findByName(name)
                                        .orElseThrow(() -> new RuntimeException(String.format("Coffee %s is not found", name)));
        return coffee.getPrice();
    }

    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }
}