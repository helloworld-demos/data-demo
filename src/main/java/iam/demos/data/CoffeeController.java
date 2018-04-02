package iam.demos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/{coffeeName}/price")
    public float greeting(@PathVariable("coffeeName") String coffeeName) {
        return coffeeService.findPriceBy_springCache(coffeeName);
    }

    @PostMapping
    public ResponseEntity<Coffee> save(@RequestBody Coffee coffee) {
        Coffee savedCoffee = coffeeService.save(coffee);

        return ResponseEntity.ok(savedCoffee);
    }
}