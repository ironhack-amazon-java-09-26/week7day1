package com.ironhack.hellocrud.controller;

import com.ironhack.hellocrud.model.Coffee;
import com.ironhack.hellocrud.model.CoffeeProcess;
import com.ironhack.hellocrud.model.UpdateCoffeeNameRequest;
import com.ironhack.hellocrud.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
@RequiredArgsConstructor // nos permite inyectar el constructor de una variable final
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping
    public List<Coffee> getAll(){
        return coffeeService.getAll();
    }

    @GetMapping("/{id}")
    public Coffee getById(@PathVariable  Long id){
        return coffeeService.getById(id);
    }

    @GetMapping("/by-process")
    public List<Coffee> getAllByProcess(@RequestParam CoffeeProcess process){
        return coffeeService.getByProcess(process);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee create(@RequestBody Coffee coffee){
        return coffeeService.create(coffee);
    }


    @PutMapping("/{id}") // lo solemos utilizar cuando queremos modificar el objecto por entero
    public Coffee update(@PathVariable Long id,@RequestBody Coffee updatedCoffee){
        return coffeeService.update(id, updatedCoffee);
    }

    @PatchMapping("/{id}/name")
    public Coffee updateName(@PathVariable Long id, @RequestBody UpdateCoffeeNameRequest request){
        return coffeeService.updateName(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        coffeeService.delete(id);
    }
}
