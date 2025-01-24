package com.slotov7.Java_Spring.controllers;

import com.slotov7.Java_Spring.dto.GameDTO;
import com.slotov7.Java_Spring.dto.GameListDTO;
import com.slotov7.Java_Spring.dto.GameMinDTO;
import com.slotov7.Java_Spring.dto.ReplacementDTO;
import com.slotov7.Java_Spring.services.GameListService;
import com.slotov7.Java_Spring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")//http://localhost:8080/lists
public class GameListController {

    @Autowired
    private GameListService gameListService;//servico que vai ser injetado

    @Autowired
    private GameService gameService;//servico que vai ser injetado

    @GetMapping
    public List<GameListDTO> findAll(){//funcao que retorna uma lista de jogos para o usuario
        return gameListService.findAll();
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){//funcao que retorna uma lista de jogos para o usuario
        return gameService.findByList(listId);
    }
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){//funcao que retorna uma lista de jogos para o usuario
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
