package com.bestsellercodechallenge.yacinemazouz.repositories;

import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.GeographyType;
import com.bestsellercodechallenge.yacinemazouz.entity.Interest;
import com.bestsellercodechallenge.yacinemazouz.entity.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface InterestRepository extends JpaRepository<Interest,Integer> {
    ArrayList<Interest> findAllByLevelAndGamer_GeographyAndGame_Id(LevelType levelType, GeographyType geographyType, int gameId);
}
