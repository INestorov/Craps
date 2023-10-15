package com.games.craps.gamelogic;

import com.games.craps.entity.GameRequest;
import com.games.craps.entity.GameResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarpsGameLogic {
    public static GameResponse playOneRound(GameRequest gameRequest) {
        GameResponse gameResponse = new GameResponse();

        gameResponse.setTypeOfGame(gameRequest.getTypeOfGame());
        gameResponse.setStake(gameRequest.getStake());


        if(gameResponse.getRoundDetails() == null)  {
            List<List<Integer>> roundDetails = new ArrayList<>();
            gameResponse.setRoundDetails(roundDetails);
        }

        Random random = new Random();
        int diceRollFirst = random.nextInt(6) + 1;
        int diceRollSecond = random.nextInt(6) + 1;

        List<Integer> diceRolls = new ArrayList<>();
        diceRolls.add(diceRollFirst);
        diceRolls.add(diceRollSecond);

        int sumOfDices = diceRollFirst + diceRollSecond;

        if(sumOfDices == 2 || sumOfDices == 3 || sumOfDices == 12) {
            gameResponse.setOutcomeOfRound("Lose");
            gameResponse.setPayout(gameResponse.getStake().negate());
            gameResponse.addRoundDetails(diceRolls);
            return gameResponse;
        }

        if(sumOfDices == 7 || sumOfDices == 11) {
            gameResponse.setOutcomeOfRound("Win");
            gameResponse.setPayout(gameResponse.getStake());
            gameResponse.addRoundDetails(diceRolls);
            return gameResponse;
        }

        gameResponse.addRoundDetails(diceRolls);

        while(true) {
            int pointThrowFirst = random.nextInt(6) + 1;
            int pointThrowSecond = random.nextInt(6) + 1;
            int sumPointThrows = pointThrowFirst + pointThrowSecond;
            List<Integer> diceRollsPoint = new ArrayList<>();
            diceRollsPoint.add(pointThrowFirst);
            diceRollsPoint.add(pointThrowSecond);

            if(sumPointThrows == 7){
                gameResponse.setOutcomeOfRound("Lose");
                gameResponse.setPayout(gameRequest.getStake().negate());
                gameResponse.addRoundDetails(diceRollsPoint);
                break;
            } else if(sumPointThrows == sumOfDices) {
                gameResponse.setOutcomeOfRound("Win");
                gameResponse.setPayout(gameResponse.getStake());
                gameResponse.addRoundDetails(diceRollsPoint);
                break;
            } else {
                gameResponse.addRoundDetails(diceRollsPoint);
            }
        }

        return gameResponse;
    }
}
