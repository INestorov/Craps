package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GameResponseTest {
    private GameResponse gr;

    @BeforeEach
    void setUp(){
        List<DiceThrow> roundDetails = new ArrayList<>();

        DiceThrow dicesThrown = new DiceThrow(1, 2, 5);

        roundDetails.add(dicesThrown);

        gr = new GameResponse(new BigDecimal("2.00"), "craps", "Win", new BigDecimal("2.00"), roundDetails);
    }

    @Test
    void testGetStake(){
        assertThat(new BigDecimal("2.00"), equalTo(gr.getStake()));
    }

    @Test
    void testSetStake(){
        BigDecimal bd = new BigDecimal("2.50");
        gr.setStake(bd);

        assertThat(bd, equalTo(gr.getStake()));
    }

    @Test
    void testGetTypeOfGame(){
        assertEquals("craps", gr.getTypeOfGame());
    }

    @Test
    void testSetTypeOfGame(){
        gr.setTypeOfGame("crapsTest");

        assertEquals("crapsTest", gr.getTypeOfGame());
    }

    @Test
    void testGetOutcome() {
        assertEquals("Win", gr.getOutcomeOfRound());
    }

    @Test
    void testSetOutcome(){
        gr.setOutcomeOfRound("Lose");

        assertEquals("Lose", gr.getOutcomeOfRound());
    }

    @Test
    void testGetPayout(){
        assertThat(new BigDecimal("2.00"), equalTo(gr.getPayout()));
    }

    @Test
    void testSetPayout(){
        BigDecimal bd = new BigDecimal("2.50");
        gr.setPayout(bd);

        assertThat(bd, equalTo(gr.getPayout()));
    }

    @Test
    void testGetRoundDetails(){
        List<DiceThrow> roundDetailsTest = new ArrayList<>();

        DiceThrow dicesThrownTest = new DiceThrow(1, 2, 5);
        roundDetailsTest.add(dicesThrownTest);

        assertEquals(roundDetailsTest, gr.getRoundDetails());
    }

    @Test
    void testSetRoundDetails(){
        List<DiceThrow> roundDetailsTest = new ArrayList<>();

        DiceThrow dicesThrownTest = new DiceThrow(1, 2, 9);

        roundDetailsTest.add(dicesThrownTest);
        gr.setRoundDetails(roundDetailsTest);

        assertEquals(roundDetailsTest, gr.getRoundDetails());
    }

    @Test
    void testConstructor(){
        BigDecimal stake = new BigDecimal("2.00");
        String typeOfGame = "craps";
        String outcome = "Win";
        BigDecimal payout = new BigDecimal("2.00");

        List<DiceThrow> roundDetailsTest = new ArrayList<>();

        DiceThrow dicesThrownTest = new DiceThrow(1, 2, 5);

        roundDetailsTest.add(dicesThrownTest);

        GameResponse gameResponse = new GameResponse(stake, typeOfGame, outcome, payout, roundDetailsTest);

        assertThat(stake, equalTo(gameResponse.getStake()));
        assertEquals(typeOfGame, gameResponse.getTypeOfGame());
        assertEquals(outcome, gameResponse.getOutcomeOfRound());
        assertThat(payout, equalTo(gameResponse.getPayout()));
        assertEquals(roundDetailsTest, gameResponse.getRoundDetails());
    }

    @Test
    void testEquals() {
        BigDecimal stake = new BigDecimal("1.00");

        String typeOfGame = "Craps";
        String outcomeOfRound = "Win";
        BigDecimal payout = new BigDecimal("1.00");

        List<DiceThrow> roundDetails = new ArrayList<>();
        roundDetails.add(new DiceThrow(1, 4, 3));

        GameResponse gameResponse1 = new GameResponse(stake, typeOfGame, outcomeOfRound, payout, roundDetails);
        GameResponse gameResponse2 = new GameResponse(stake, typeOfGame, outcomeOfRound, payout, roundDetails);

        assertEquals(gameResponse1, gameResponse2);
    }

    @Test
    void testNotEquals() {
        BigDecimal stake1 = new BigDecimal("1.00");
        BigDecimal stake2 = new BigDecimal("2.00");

        String typeOfGame = "Craps";
        String outcomeOfRound = "Win";
        BigDecimal payout = new BigDecimal("1.00");

        List<DiceThrow> roundDetails = new ArrayList<>();
        roundDetails.add(new DiceThrow(1, 4, 3));

        GameResponse gameResponse1 = new GameResponse(stake1, typeOfGame, outcomeOfRound, payout, roundDetails);
        GameResponse gameResponse2 = new GameResponse(stake2, typeOfGame, outcomeOfRound, payout, roundDetails);

        assertNotEquals(gameResponse1, gameResponse2);
    }
}
