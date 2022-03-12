package com.bestsellercodechallenge.yacinemazouz.services;


import com.bestsellercodechallenge.yacinemazouz.entity.Game;
import com.bestsellercodechallenge.yacinemazouz.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public Game saveGame(Game game) {
        return repository.save(game);
    }

    public List<Game> getGames() {
        return repository.findAll();
    }

    public String deleteGame(int id) {
        repository.deleteById(id);
        return "game removed" + id;
    }




}

