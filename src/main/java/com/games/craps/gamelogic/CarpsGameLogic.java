package com.games.craps.gamelogic;

import com.games.craps.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarpsGameLogic {
    public ResponseEntity playOneGame(GameRequest gameRequest) {
        return ResponseEntity.ok(playOneRound(gameRequest));
    }
    public ResponseEntity playMultipleGames(int numberOfGames, GameRequest gameRequest){
        MultipleGamesStats gameStats = new MultipleGamesStats();
        gameStats.setStakes(gameRequest.getStake().multiply(BigDecimal.valueOf(numberOfGames)));
        List<GameResponse> gameResponses = new ArrayList<>();

        for(int i = 0; i < numberOfGames; i++) {
            GameResponse gameResponse = playOneRound(gameRequest);
            gameResponses.add(gameResponse);
            gameStats.setTotalWin(gameStats.getTotalWin().add(gameResponse.getPayout()));
        }

        gameStats.setReturnToPlayer(gameStats.getTotalWin().divide(gameStats.getStakes(), 5, RoundingMode.DOWN));
        return ResponseEntity.ok(new ResultFromMultipleGames(gameStats, gameResponses));
    }

    public GameResponse playOneRound(GameRequest gameRequest){
        GameResponse gameResponse = initGameResponse(gameRequest);

        int counter = 1;

        DiceThrow diceRolls = throwDice(counter);
        counter++;

        int sumOfDices = diceRolls.getFirstDice() + diceRolls.getSecondDice();

        if(sumOfDices == 2 || sumOfDices == 3 || sumOfDices == 12) {
            return setOutcome(gameResponse, "Lose", gameRequest.getStake(), diceRolls);
        }

        if(sumOfDices == 7 || sumOfDices == 11) {
            return setOutcome(gameResponse, "Win", gameRequest.getStake(), diceRolls);
        }

        gameResponse.addRoundDetails(diceRolls);

        while(true) {
            DiceThrow diceRollsPoint = throwDice(counter);
            counter++;
            int sumPointThrows = diceRollsPoint.getFirstDice() + diceRollsPoint.getSecondDice();

            if(sumPointThrows == 7){
                setOutcome(gameResponse, "Lose", gameRequest.getStake(), diceRollsPoint);
                break;
            } else if(sumPointThrows == sumOfDices) {
                setOutcome(gameResponse, "Win", gameRequest.getStake(), diceRollsPoint);
                break;
            } else {
                gameResponse.addRoundDetails(diceRollsPoint);
            }
        }
        return gameResponse;
    }

    public GameResponse initGameResponse(GameRequest gameRequest) {
        GameResponse gameResponse = new GameResponse();

        gameResponse.setTypeOfGame(gameRequest.getTypeOfGame());
        gameResponse.setStake(gameRequest.getStake());

        List<DiceThrow> roundDetails = new ArrayList<>();
        gameResponse.setRoundDetails(roundDetails);
        return gameResponse;
    }

    public DiceThrow throwDice(int counter){
        Random random = new Random();
        int diceRollFirst = random.nextInt(6) + 1;
        int diceRollSecond = random.nextInt(6) + 1;

        return new DiceThrow(counter, diceRollFirst, diceRollSecond);
    }

    public GameResponse setOutcome(GameResponse gameResponse, String outcome, BigDecimal stake, DiceThrow diceThrow){
        if(outcome.equals("Win")){
            gameResponse.setPayout(stake.multiply(new BigDecimal(2)));
            gameResponse.setOutcomeOfRound("Win");
        } else {
            gameResponse.setPayout(new BigDecimal(0));
            gameResponse.setOutcomeOfRound("Lose");
        }

        gameResponse.addRoundDetails(diceThrow);
        return gameResponse;
    }
}
