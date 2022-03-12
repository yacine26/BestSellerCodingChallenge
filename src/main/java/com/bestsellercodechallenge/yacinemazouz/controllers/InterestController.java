package com.bestsellercodechallenge.yacinemazouz.controllers;

import com.bestsellercodechallenge.yacinemazouz.dto.MVPResponse;
import com.bestsellercodechallenge.yacinemazouz.entity.Game;
import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.Interest;

import com.bestsellercodechallenge.yacinemazouz.entity.LevelType;
import com.bestsellercodechallenge.yacinemazouz.repositories.GameRepository;
import com.bestsellercodechallenge.yacinemazouz.repositories.GamerRepository;
import com.bestsellercodechallenge.yacinemazouz.services.GameService;
import com.bestsellercodechallenge.yacinemazouz.services.GamerService;
import com.bestsellercodechallenge.yacinemazouz.services.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

@RestController
@RequestMapping("/interest")
public class InterestController {

    @Autowired
    private InterestService interestService;
    @Autowired
    private GamerRepository gamerRepository;
    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/add/{nickname}/{gameId}")
    public Interest addInterest(
            @PathVariable(value = "nickname") String nickname,
            @PathVariable(value = "gameId") int gameId,
            @RequestBody Interest interestRequest
    ) {
        Gamer gamer = gamerRepository.findByNickname(nickname);
        Game game = gameRepository.findById(gameId);
        interestRequest.setGame(game);
        interestRequest.setGamer(gamer);
        return interestService.saveInterest(interestRequest);
    }

    @GetMapping("/mvp/{level}/{gameId}")
    public MVPResponse findMVP(
            @PathVariable(value = "level") String level,
            @PathVariable(value = "gameId") int gameId
    ){
        ArrayList<Interest> interests = interestService.getAllByLevelAndGame(level, gameId);
        Interest interest = interests.stream().max(Comparator.comparing(Interest::getCredit)).get();
        return new MVPResponse(interest.getGamer(), interest.getCredit());
    }
}
