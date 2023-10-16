package com.games.craps.controller;

import com.games.craps.entity.GameRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class CrapsControllerTest {
    @InjectMocks
    CrapsController crapsController;

    @Test
    public void singleRoundTest(){
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.00"), "craps");
        ResponseEntity responseEntity = crapsController.playSingleRound(gameRequest);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void multipleRoundTest(){
        GameRequest gameRequest = new GameRequest(new BigDecimal("2.00"), "craps");
        ResponseEntity responseEntity = crapsController.playMultiple(5, gameRequest);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }
}