package com.bestsellercodechallenge.yacinemazouz.controllers;

import com.bestsellercodechallenge.yacinemazouz.dto.MatchmakingRequest;
import com.bestsellercodechallenge.yacinemazouz.entity.Game;
import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.Interest;
import com.bestsellercodechallenge.yacinemazouz.repositories.InterestRepository;
import com.bestsellercodechallenge.yacinemazouz.services.GameService;

import com.bestsellercodechallenge.yacinemazouz.services.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService service;

    @Autowired
    private InterestService interestService;

    @PostMapping("/add")
    public Game addGame(@RequestBody Game game) {
        return service.saveGame(game);
    }


    @GetMapping("/list")
    public List<Game> findAllGames() {
        return service.getGames();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteGame(@PathVariable int id) {
        return service.deleteGame(id);
    }

    @GetMapping("/matchmaking/{gameId}")
    public ArrayList<Gamer> matchmaking(@PathVariable int gameId, @RequestBody MatchmakingRequest request, HttpServletResponse response) {
        ArrayList<Interest> interests = interestService.getByGeographyAndLevelAndGame(request.geography, request.level, gameId);
        ArrayList<Gamer> gamers = new ArrayList<Gamer>();
        if(interests.size() < 2) {
            response.setStatus(204);
            return gamers;
        }

        int firstIndex = new Random().nextInt(interests.size());
        gamers.add(interests.get(firstIndex).getGamer());

        int secondIndex;

        do {
            secondIndex = new Random().nextInt(interests.size());
        } while(secondIndex == firstIndex);

        gamers.add(interests.get(secondIndex).getGamer());
        return gamers;
    }
}

