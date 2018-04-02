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
    public float findPriceBy_springCache(String name) {
        simulatedLongService();

        Coffee coffee = coffeeRepository.findByName(name)
                                        .orElseThrow(() -> new RuntimeException(String.format("Coffee %s is not found", name)));
        return coffee.getPrice();
    }

    // TODO implement this, what about two threads are calling this method at the same time, cache twice?
    public float findPriceBy_redisTemplate(String name) {
        //RedisTemplate

        Coffee coffee = coffeeRepository.findByName(name)
                                        .orElseThrow(() -> new RuntimeException(String.format("Coffee %s is not found", name)));
        return coffee.getPrice();
    }

    private void simulatedLongService() {
        try {
            log.info("A really time expensive operation is happening. It will take about 5 seconds");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }
}