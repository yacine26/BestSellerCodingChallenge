package com.bestsellercodechallenge.yacinemazouz.controllers;

import com.bestsellercodechallenge.yacinemazouz.dto.GamerResponse;
import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.GeographyType;
import com.bestsellercodechallenge.yacinemazouz.entity.Interest;
import com.bestsellercodechallenge.yacinemazouz.entity.LevelType;
import com.bestsellercodechallenge.yacinemazouz.services.GamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gamer")
public class GamerController {

    @Autowired
    private GamerService service;

    @PostMapping("/add")
    public Gamer addGamer(@RequestBody Gamer gamer) {
        return service.saveGamer(gamer);
    }

    @GetMapping("/{nickname}")
    public GamerResponse getGamer(@PathVariable String nickname) {
        return service.getGamerByNickname(nickname);
    }

    @GetMapping("/maximum/{geography}")
    public Gamer findGamerByGeography(@PathVariable GeographyType geography) {
        return service.getGamerByGeography(geography);
    }


}
