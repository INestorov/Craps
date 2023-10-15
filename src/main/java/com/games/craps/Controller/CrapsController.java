package com.games.craps.Controller;

import com.games.craps.Entity.GameRequest;
import com.games.craps.Entity.GameResponse;
import com.games.craps.GameLogic.CarpsGameLogic;
import com.games.craps.Validator.RequestValidator;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/playSingleRound")
    public ResponseEntity<?> playSingleRound(@RequestBody GameRequest gameRequest){
        if(!RequestValidator.validateRequest(gameRequest)) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid request, please provide typeOfGame and stakes larger than 0");

        GameResponse gameResponse = CarpsGameLogic.gameLogic(gameRequest);
        return ResponseEntity.ok(gameResponse);
    }

    @PostMapping("/playMultipleRounds")
    public ResponseEntity<?> playMultiple(@RequestParam("numberOfRounds") int numberOfRounds, @RequestBody GameRequest gameRequest) {
        if(!RequestValidator.validateRequest(gameRequest)) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid request, please provide typeOfGame and stakes larger than 0");

        List<GameResponse> gameResponses = new ArrayList<>();


        BigDecimal totalWin = new BigDecimal("0.00").setScale(2, RoundingMode.DOWN);
        double rtp;
        for(int i = 0; i < numberOfRounds; i++) {
            GameResponse gameResponse = CarpsGameLogic.gameLogic(gameRequest);
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
