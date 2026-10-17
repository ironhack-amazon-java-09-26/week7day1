package com.ironhack.hellocrud.service;

import com.ironhack.hellocrud.exceptions.IdNotMatchException;
import com.ironhack.hellocrud.model.Coffee;
import com.ironhack.hellocrud.model.CoffeeProcess;
import com.ironhack.hellocrud.model.UpdateCoffeeNameRequest;
import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class CoffeeService {

    private Long nextId = 1L;

    private List<Coffee>  coffees;

    @PostConstruct
    private void init() {
        coffees = new ArrayList<>();
        coffees.add(new Coffee(nextId++, "Ethiopian Yirgacheffe", "Ethiopia", CoffeeProcess.WASHED));
        coffees.add(new Coffee(nextId++, "Colombian Supremo", "Colombia", CoffeeProcess.HONEY));
        coffees.add(new Coffee(nextId++, "Brazilian Santos", "Brazil", CoffeeProcess.NATURAL));
    }

    public List<Coffee> getAll(){
        log.info("Getting all coffees");
        return coffees;
    }

    public Coffee getById(Long id) {
        log.info("Getting coffee by id: " + id);
        for (Coffee coffee : coffees) {
            if (coffee.getId() == id) {
                log.info("Found coffee: " + coffee);
                return coffee;
            }
        }
        log.info("Coffee with id " + id + " not found");
        return null;
    }


    public List<Coffee> getByProcess(CoffeeProcess process) {
        List<Coffee> foundedCoffees = new ArrayList<>();
        log.info("Getting coffees by process: " + process);
        for (Coffee coffee : coffees){
            if (coffee.getProcess().equals(process)){
                foundedCoffees.add(coffee);
            }
        }
        return foundedCoffees;
    }

    public Coffee create(Coffee coffee){
        coffee.setId(nextId++);
        coffees.add(coffee);
        log.info("Created coffee: " + coffee);
        return coffee;
    }

    public Coffee update(Long id, Coffee updatedCoffee){
        updatedCoffee.setId(id);
        for(int i = 0; i< coffees.size(); i++){
            if(coffees.get(i).getId() == id){
                coffees.set(i, updatedCoffee);
                log.info("Updated coffee with id " + id + ": " + updatedCoffee);
                return updatedCoffee;
            }
        }
        log.info("Coffee with id " + id + " not found");
        return null;
    }

    public Coffee updateName(Long id, UpdateCoffeeNameRequest request){
        if (!id.equals(request.getCoffeeId())){
            log.warning("The 2 id are not matching: " + id + " and " + request.getCoffeeId());
            throw new IdNotMatchException("The 2 id are not matching");
        }
        for(int i =0; i < coffees.size(); i++){
            if(coffees.get(i).getId() == id){
                coffees.get(i).setName(request.getName());
                log.info("Updated coffee name with id " + id + ": " + request.getName());
                return coffees.get(i);
            }
        }
        log.info("Coffee with id " + id + " not found");
        return null;
    }

    public void delete(Long id){
        for (int i = 0; i < coffees.size(); i++){
            if (coffees.get(i).getId() == id){
                coffees.remove(i);
                log.info("Deleted coffee with id " + id);
                return;
            }
        }
    }

}
