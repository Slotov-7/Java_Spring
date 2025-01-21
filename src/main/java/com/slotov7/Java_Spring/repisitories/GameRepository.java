package com.slotov7.Java_Spring.repisitories;

import com.slotov7.Java_Spring.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
