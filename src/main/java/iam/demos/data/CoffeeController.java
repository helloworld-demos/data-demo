package iam.demos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    @Autowired
    CoffeeService coffeeService;

    @RequestMapping("/{coffeeName}/price")
    public float greeting(@PathVariable(value = "coffeeName") String coffeeName) {
        return coffeeService.findPriceBy(coffeeName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Coffee> save(@RequestBody Coffee coffee) {
        Coffee savedCoffee = coffeeService.save(coffee);

        return ResponseEntity.ok(savedCoffee);
    }
}