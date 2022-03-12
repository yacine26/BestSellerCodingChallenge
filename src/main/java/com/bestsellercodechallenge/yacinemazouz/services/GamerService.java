package com.bestsellercodechallenge.yacinemazouz.services;


import com.bestsellercodechallenge.yacinemazouz.dto.GamerResponse;
import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.GeographyType;
import com.bestsellercodechallenge.yacinemazouz.repositories.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamerService {
    @Autowired
    private GamerRepository repository;

    public Gamer saveGamer(Gamer gamer) {
        return repository.save(gamer);
    }

    public Gamer getGamerByGeography(GeographyType geography) {
        return repository.findByGeography(geography);
    }

    public GamerResponse getGamerByNickname(String nickname) {
        GamerResponse response = new GamerResponse();
        Gamer gamer = repository.findByNickname(nickname);
        response.setGamer(gamer);
        return response;
    }

}
