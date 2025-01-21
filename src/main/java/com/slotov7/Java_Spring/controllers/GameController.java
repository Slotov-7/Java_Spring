package com.slotov7.Java_Spring.controllers;

import com.slotov7.Java_Spring.dto.GameMinDTO;
import com.slotov7.Java_Spring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }
}
