package com.bestsellercodechallenge.yacinemazouz.services;

import com.bestsellercodechallenge.yacinemazouz.entity.*;
import com.bestsellercodechallenge.yacinemazouz.repositories.GamerRepository;
import com.bestsellercodechallenge.yacinemazouz.repositories.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestService {

    @Autowired
    private InterestRepository repository;

    public Interest saveInterest(Interest interest) {
        return repository.save(interest);
    }

    public ArrayList<Interest> getAllByLevelAndGame(String levelName, int gameId){
        List<Interest> interests = repository.findAll();
        ArrayList<Interest> result = new ArrayList<>();
        LevelType level = LevelType.valueOf(levelName);
        for(Interest interest: interests) {
            if(interest.getGame().getId() == gameId && interest.getLevel().equals(level)) {
                result.add(interest);
            }
        }
        return result;
    }

    public ArrayList<Interest> getByGeographyAndLevelAndGame(String geography, String level, int gameId) {
        GeographyType geographyType = GeographyType.valueOf(geography);
        LevelType levelType = LevelType.valueOf(level);

        return repository.findAllByLevelAndGamer_GeographyAndGame_Id(levelType, geographyType, gameId);
    }


}
