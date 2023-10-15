package com.games.craps.gamelogic;

import com.games.craps.entity.GameRequest;
import com.games.craps.entity.GameResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CarpsGameLogicTest {

    @Test
    public void playOneRoundTest() {
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.00"), "craps");

        GameResponse gameResponse = CarpsGameLogic.playOneRound(gameRequest);

        assertNotNull(gameResponse);
        assertEquals(new BigDecimal("2.00"), gameResponse.getStake());
        assertEquals("craps", gameResponse.getTypeOfGame());
        assertTrue(gameResponse.getOutcomeOfRound().equals("Win") || gameResponse.getOutcomeOfRound().equals("Lose"));
        assertTrue(gameResponse.getPayout().equals(gameResponse.getStake()) || gameResponse.getPayout().equals(gameResponse.getStake().negate()));
        assertNotNull(gameResponse.getRoundDetails());
    }
}
