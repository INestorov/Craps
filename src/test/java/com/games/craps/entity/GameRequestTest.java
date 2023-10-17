package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GameRequestTest {
    private GameRequest gr;

    @BeforeEach
    void setUp() {
        gr = new GameRequest(new BigDecimal("2.00"), "craps");
    }

    @Test
    void testGetStake(){
        assertEquals(new BigDecimal("2.00"), gr.getStake());
    }

    @Test
    void testGetStakeRounding() {
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.1555"), "craps");

        assertThat(new BigDecimal("2.15"), equalTo(gameRequest.getStake()));
    }

    @Test
    void testSetStake(){
        BigDecimal newStake = new BigDecimal("2.00");
        gr.setStake(newStake);

        assertThat(newStake, equalTo(gr.getStake()));
    }

    @Test
    void testGetTypeOfGame(){
        assertEquals("craps", gr.getTypeOfGame());
    }

    @Test
    void testSetTypeOfGame(){
        gr.setTypeOfGame("crapsTest");

        assertEquals("crapstest", gr.getTypeOfGame());
    }

    @Test
    void testConstructor(){
        BigDecimal stakeTest = new BigDecimal("2.00");
        String typeOfGameTest = "craps";

        GameRequest gameRequest = new GameRequest(stakeTest, typeOfGameTest);

        assertThat(stakeTest, equalTo(gameRequest.getStake()));
        assertEquals(typeOfGameTest, gameRequest.getTypeOfGame());
    }

    @Test
    void testEquals() {
        BigDecimal stake1 = new BigDecimal("1.00");
        BigDecimal stake2 = new BigDecimal("1.00");
        String typeOfGame1 = "craps";
        String typeOfGame2 = "CRAPS";

        GameRequest gameRequest1 = new GameRequest(stake1, typeOfGame1);
        GameRequest gameRequest2 = new GameRequest(stake2, typeOfGame2);

        assertEquals(gameRequest1, gameRequest2);
    }

    @Test
    void testNotEquals() {
        BigDecimal stake1 = new BigDecimal("1.00");
        BigDecimal stake2 = new BigDecimal("2.00");
        String typeOfGame = "craps";

        GameRequest gameRequest1 = new GameRequest(stake1, typeOfGame);
        GameRequest gameRequest2 = new GameRequest(stake2, typeOfGame);

        assertNotEquals(gameRequest1, gameRequest2);
    }
}
