package com.bestsellercodechallenge.yacinemazouz.repositories;

import com.bestsellercodechallenge.yacinemazouz.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {
    Game findById(int id);
}
