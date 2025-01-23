package com.slotov7.Java_Spring.repisitories;

import com.slotov7.Java_Spring.entities.Game;
import com.slotov7.Java_Spring.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
