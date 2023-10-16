package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameRequestTest {
    private GameRequest gr;

    @BeforeEach
    public void setUp() {
        gr = new GameRequest(new BigDecimal("2.00"), "craps");
    }

    @Test
    public void getStakeTest(){
        assertEquals(new BigDecimal("2.00"), gr.getStake());
    }

    @Test
    public void setStakeTest(){
        BigDecimal newStake = new BigDecimal("2.00");
        gr.setStake(newStake);

        assertEquals(newStake, gr.getStake());
    }

    @Test
    public void getTypeOfGameTest(){
        assertEquals("craps", gr.getTypeOfGame());
    }

    @Test
    public void setTypeOfGameTest(){
        gr.setTypeOfGame("crapsTest");

        assertEquals("crapstest", gr.getTypeOfGame());
    }

    @Test
    public void constructorTest(){
        BigDecimal stakeTest = new BigDecimal("2.00");
        String typeOfGameTest = "craps";

        GameRequest gameRequest = new GameRequest(stakeTest, typeOfGameTest);

        assertEquals(stakeTest, gameRequest.getStake());
        assertEquals(typeOfGameTest, gameRequest.getTypeOfGame());
    }
}
