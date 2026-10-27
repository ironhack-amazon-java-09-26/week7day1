package com.ironhack.hellocrud.repository;

import com.ironhack.hellocrud.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository< Monster, Integer> {
}
