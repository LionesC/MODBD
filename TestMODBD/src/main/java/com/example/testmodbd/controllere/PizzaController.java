package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Pizza;
import com.example.testmodbd.repo.PizzaRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class PizzaController {
    PizzaRepo pizzaRepo = new PizzaRepo();

    @GetMapping("/pizza")
    public List<Pizza> getAllPizza() throws ClassNotFoundException{
        return pizzaRepo.findAll();
    }

    @DeleteMapping("/pizza/{id}")
    public void deletePizza(@PathVariable("id") int id) throws ClassNotFoundException{
        pizzaRepo.delete(id);
    }

    @PostMapping("/pizza")
    public void addPizza(int id_pizza, String tip_blat, String vegetarian) throws ClassNotFoundException{
        Pizza pizza = new Pizza(id_pizza, tip_blat, vegetarian);
        pizzaRepo.insert(pizza);
    }

    @PutMapping("/pizza/{id}")
    public ResponseEntity<Void> updatePizza(@PathVariable("id") int id, @RequestBody Pizza entity) throws ClassNotFoundException{
        Pizza pizza = pizzaRepo.findById(id);
        if (pizza != null){
            pizza.setId_pizza(entity.getId_pizza());
            pizza.setTip_blat(entity.getTip_blat());;
            pizza.setVegetarian(entity.getVegetarian());

            pizzaRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }
}
