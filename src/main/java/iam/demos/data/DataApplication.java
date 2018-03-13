package iam.demos.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DataApplication {
    //@Bean
    //InitializingBean seedData(CoffeeRepository coffeeRepository) {
    //    return () -> coffeeRepository.save(new Coffee("latte", 3.48f));
    //}
    //
    //@Bean
    //public CommandLineRunner exampleQuery(CoffeeRepository repository) {
    //    return args -> repository.findByName("latte")
    //                             .forEach(System.err::println);
    //}

    //@Bean
    //RedisCacheManager cacheManager(StringRedisTemplate template) {
    //    RedisCacheManager rcm = new RedisCacheManager(template);
    //
    //    return new RedisCacheManager(template);
    //}


    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }
}
