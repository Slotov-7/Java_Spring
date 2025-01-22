package com.slotov7.Java_Spring.controllers;

import com.slotov7.Java_Spring.dto.GameDTO;
import com.slotov7.Java_Spring.dto.GameMinDTO;
import com.slotov7.Java_Spring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")//http://localhost:8080/games
public class GameController {

    @Autowired
    private GameService gameService;//servico que vai ser injetado

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){//funcao que retorna uma lista de jogos para o usuario
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){//funcao que retorna uma lista de jogos para o usuario
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
