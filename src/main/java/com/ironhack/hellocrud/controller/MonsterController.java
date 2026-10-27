package com.ironhack.hellocrud.controller;

import com.ironhack.hellocrud.model.Monster;
import com.ironhack.hellocrud.service.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monsters")
@RequiredArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;


    @GetMapping
    public List<Monster> getAll(){
        return monsterService.getAll();
    }

}
