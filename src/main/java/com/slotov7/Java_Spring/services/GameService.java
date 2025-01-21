package com.slotov7.Java_Spring.services;

import com.slotov7.Java_Spring.repisitories.GameRepository;
import com.slotov7.Java_Spring.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
    return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }
}
