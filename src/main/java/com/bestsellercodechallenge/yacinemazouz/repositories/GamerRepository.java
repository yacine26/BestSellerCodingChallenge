package com.bestsellercodechallenge.yacinemazouz.repositories;

import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.GeographyType;
import com.bestsellercodechallenge.yacinemazouz.entity.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer,Integer> {

    Gamer findByGeography(GeographyType geography);

    Gamer findByNickname(String nickname);
}
