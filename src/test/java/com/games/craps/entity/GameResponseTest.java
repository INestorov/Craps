package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResponseTest {
    private GameResponse gr;

    @BeforeEach
    public void setUp(){
        List<List<Integer>> roundDetails = new ArrayList<>();

        List<Integer> dicesThrown = new ArrayList<>();
        dicesThrown.add(Integer.valueOf(2));
        dicesThrown.add(Integer.valueOf(5));

        roundDetails.add(dicesThrown);

        gr = new GameResponse(new BigDecimal("2.00"), "craps", "Win", new BigDecimal("2.00"), roundDetails);
    }

    @Test
    public void getStakeTest(){
        assertEquals(new BigDecimal("2.00"), gr.getStake());
    }

    @Test
    public void setStakeTest(){
        BigDecimal bd = new BigDecimal("2.50");
        gr.setStake(bd);

        assertEquals(bd, gr.getStake());
    }

    @Test
    public void getTypeOfGameTest(){
        assertEquals("craps", gr.getTypeOfGame());
    }

    @Test
    public void setTypeOfGameTest(){
        gr.setTypeOfGame("crapsTest");

        assertEquals("crapsTest", gr.getTypeOfGame());
    }

    @Test
    public void getOutcomeTest() {
        assertEquals("Win", gr.getOutcomeOfRound());
    }

    @Test
    public void setOutcomeTest(){
        gr.setOutcomeOfRound("Lose");

        assertEquals("Lose", gr.getOutcomeOfRound());
    }

    @Test
    public void getPayoutTest(){
        assertEquals(new BigDecimal("2.00"), gr.getPayout());
    }

    @Test
    public void setPayoutTest(){
        BigDecimal bd = new BigDecimal("2.50");
        gr.setPayout(bd);

        assertEquals(bd, gr.getPayout());
    }

    @Test
    public void getRoundDetailsTest(){
        List<List<Integer>> roundDetailsTest = new ArrayList<>();

        List<Integer> dicesThrownTest = new ArrayList<>();
        dicesThrownTest.add(Integer.valueOf(2));
        dicesThrownTest.add(Integer.valueOf(5));

        roundDetailsTest.add(dicesThrownTest);

        assertEquals(roundDetailsTest, gr.getRoundDetails());
    }

    @Test
    public void setRoundDetailsTest(){
        List<List<Integer>> roundDetailsTest = new ArrayList<>();

        List<Integer> dicesThrownTest = new ArrayList<>();
        dicesThrownTest.add(Integer.valueOf(2));
        dicesThrownTest.add(Integer.valueOf(9));

        roundDetailsTest.add(dicesThrownTest);
        gr.setRoundDetails(roundDetailsTest);

        assertEquals(roundDetailsTest, gr.getRoundDetails());
    }

    @Test
    public void constructorTest(){
        BigDecimal stake = new BigDecimal("2.00");
        String typeOfGame = "craps";
        String outcome = "Win";
        BigDecimal payout = new BigDecimal("2.00");

        List<List<Integer>> roundDetailsTest = new ArrayList<>();

        List<Integer> dicesThrownTest = new ArrayList<>();
        dicesThrownTest.add(Integer.valueOf(2));
        dicesThrownTest.add(Integer.valueOf(5));

        roundDetailsTest.add(dicesThrownTest);

        GameResponse gameResponse = new GameResponse(stake, typeOfGame, outcome, payout, roundDetailsTest);

        assertEquals(stake, gameResponse.getStake());
        assertEquals(typeOfGame, gameResponse.getTypeOfGame());
        assertEquals(outcome, gameResponse.getOutcomeOfRound());
        assertEquals(payout, gameResponse.getPayout());
        assertEquals(roundDetailsTest, gameResponse.getRoundDetails());
    }
}
