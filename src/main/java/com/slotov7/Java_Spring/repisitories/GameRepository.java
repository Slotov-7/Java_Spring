package com.slotov7.Java_Spring.repisitories;

import com.slotov7.Java_Spring.entities.Game;
import com.slotov7.Java_Spring.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
        SELECT games.id, games.title, games.game_year AS gameYear, games.img_url AS imgUrl,
        games.short_description AS shortDescription, belongings.position
        FROM games
        INNER JOIN belongings ON games.id = belongings.game_id
        WHERE belongings.list_id = :listId
        ORDER BY belongings.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
