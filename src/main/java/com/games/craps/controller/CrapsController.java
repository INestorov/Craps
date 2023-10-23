package com.games.craps.controller;

import com.games.craps.entity.GameRequest;
import com.games.craps.gamelogic.CarpsGameLogic;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/craps")
public class CrapsController {

    @PostMapping("/play-single-game")
    public ResponseEntity playOneGame(@Valid @RequestBody GameRequest gameRequest){
        return new CarpsGameLogic().playOneGame(gameRequest);
    }

    @PostMapping("/play-multiple-games")
    public ResponseEntity playMultipleGames(@RequestParam("numberOfGames") int numberOfGames, @Valid @RequestBody GameRequest gameRequest) {
        return new CarpsGameLogic().playMultipleGames(numberOfGames, gameRequest);
    }

}
