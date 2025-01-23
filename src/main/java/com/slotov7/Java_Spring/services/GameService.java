package com.slotov7.Java_Spring.services;

import com.slotov7.Java_Spring.dto.GameDTO;
import com.slotov7.Java_Spring.projections.GameMinProjection;
import com.slotov7.Java_Spring.repisitories.GameRepository;
import com.slotov7.Java_Spring.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(long id){
        return new GameDTO(gameRepository.findById(id).get());
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.searchByList(listId).stream().map(GameMinDTO::new).toList();
    }
}
