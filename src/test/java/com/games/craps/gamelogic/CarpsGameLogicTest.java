package com.games.craps.gamelogic;

import com.games.craps.entity.GameRequest;
import com.games.craps.entity.GameResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CarpsGameLogicTest {
    @Test
    void testPlayOneGame() {
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.00"), "craps");

        ResponseEntity responseEntity = CarpsGameLogic.playOneGame(gameRequest);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    void testPlayMultipleGames() {
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.00"), "craps");

        ResponseEntity responseEntity = CarpsGameLogic.playMultipleGames(5, gameRequest);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    void playOneRoundTest() {
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.00"), "craps");

        GameResponse gameResponse = CarpsGameLogic.playOneRound(gameRequest);

        assertNotNull(gameResponse);
        assertEquals(new BigDecimal("2.00"), gameResponse.getStake());
        assertEquals("craps", gameResponse.getTypeOfGame());
        assertTrue((gameResponse.getOutcomeOfRound().equals("Win") && gameResponse.getPayout().equals(gameResponse.getStake()))
                || (gameResponse.getOutcomeOfRound().equals("Lose") && gameResponse.getPayout().equals(gameResponse.getStake().negate())));
        assertNotNull(gameResponse.getRoundDetails());
    }
}
