package com.slotov7.Java_Spring.services;

import com.slotov7.Java_Spring.dto.GameListDTO;
import com.slotov7.Java_Spring.projections.GameMinProjection;
import com.slotov7.Java_Spring.repisitories.GameListRepository;
import com.slotov7.Java_Spring.repisitories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List <GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
