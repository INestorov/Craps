package com.games.craps.controller;

import com.games.craps.entity.GameRequest;
import com.games.craps.entity.GameResponse;
import com.games.craps.gamelogic.CarpsGameLogic;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/craps")
public class CrapsController {

    static BigDecimal credits = new BigDecimal("400.0").setScale(2, RoundingMode.DOWN);

    @PostMapping("/play-single-round")
    public ResponseEntity playSingleRound(@Valid @RequestBody GameRequest gameRequest){
        GameResponse gameResponse = CarpsGameLogic.playOneRound(gameRequest);

        return ResponseEntity.ok(gameResponse);
    }

    @PostMapping("/play-multiple-rounds")
    public ResponseEntity playMultiple(@RequestParam("numberOfRounds") int numberOfRounds, @Valid @RequestBody GameRequest gameRequest) {
        List<GameResponse> gameResponses = new ArrayList<>();

        BigDecimal totalWin = new BigDecimal("0.00").setScale(2, RoundingMode.DOWN);

        double rtp;

        for(int i = 0; i < numberOfRounds; i++) {
            GameResponse gameResponse = CarpsGameLogic.playOneRound(gameRequest);
            totalWin = totalWin.add(gameResponse.getPayout());

            gameResponses.add(gameResponse);
        }

        BigDecimal playedMoney = gameRequest.getStake().multiply(new BigDecimal(numberOfRounds));

        rtp = totalWin.divide(playedMoney, 5, RoundingMode.DOWN).doubleValue();

        credits = credits.add(totalWin);

        System.out.println("Stake: " + gameRequest.getStake());
        System.out.println("Money Played: " + playedMoney);
        System.out.println("Total Win: " + totalWin);
        System.out.println("Current Credits: " + credits);
        System.out.println("RTP: " + rtp +  "\n" );

        return ResponseEntity.ok(gameResponses);
    }

}
