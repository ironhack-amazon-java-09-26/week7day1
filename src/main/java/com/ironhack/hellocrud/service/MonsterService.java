package com.ironhack.hellocrud.service;

import com.ironhack.hellocrud.model.Monster;
import com.ironhack.hellocrud.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonsterService {

    private final MonsterRepository monsterRepository;

    public List<Monster> getAll(){
        return monsterRepository.findAll();
    }
}
