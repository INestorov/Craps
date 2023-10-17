package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ResultsFromMultipleGamesTest {

    private MultipleGamesStats mgs;
    private List<GameResponse> grList;

    ResultFromMultipleGames resultFromMultipleGames;

    @BeforeEach
    void setUp(){
        BigDecimal stake = new BigDecimal("2.00");
        BigDecimal win = new BigDecimal("1.00");
        BigDecimal rtp = new BigDecimal("0.50");

        mgs = new MultipleGamesStats(stake, win, rtp);
        grList = new ArrayList<>();
        List<DiceThrow> diceThrows = new ArrayList<>();

        GameResponse gr = new GameResponse(stake, "craps", "win", win, diceThrows);
        grList.add(gr);

        resultFromMultipleGames = new ResultFromMultipleGames(mgs, grList);
    }

    @Test
    void testGetMultipleGamesStats(){
        BigDecimal stakeNew = new BigDecimal("2.00");
        BigDecimal winNew = new BigDecimal("1.00");
        BigDecimal rtpNew = new BigDecimal("0.50");

        MultipleGamesStats mgsNew = new MultipleGamesStats(stakeNew, winNew, rtpNew);

        assertEquals(mgsNew, resultFromMultipleGames.getGameStats());
    }
    @Test
    void testSetMultipleGamesStats(){
        BigDecimal stakeNew = new BigDecimal("2.00");
        BigDecimal winNew = new BigDecimal("0.50");
        BigDecimal rtpNew = new BigDecimal("0.25");

        MultipleGamesStats mgsNew = new MultipleGamesStats(stakeNew, winNew, rtpNew);
        resultFromMultipleGames.setGameStats(mgsNew);

        assertEquals(mgsNew, resultFromMultipleGames.getGameStats());
    }

    @Test
    void testGetGameResponses(){
        BigDecimal stakeNew = new BigDecimal("2.00");
        BigDecimal winNew = new BigDecimal("1.00");

        List<GameResponse> grListNew = new ArrayList<>();
        List<DiceThrow> diceThrows = new ArrayList<>();

        GameResponse gr = new GameResponse(stakeNew, "craps", "win", winNew, diceThrows);
        grListNew.add(gr);

        assertEquals(grListNew, resultFromMultipleGames.getGameResponses());
    }

    @Test
    void testSetGameResponses(){
        BigDecimal stakeNew = new BigDecimal("2.00");
        BigDecimal winNew = new BigDecimal("2.00");

        List<GameResponse> grListNew = new ArrayList<>();
        List<DiceThrow> diceThrows = new ArrayList<>();

        GameResponse gr = new GameResponse(stakeNew, "craps", "win", winNew, diceThrows);
        grListNew.add(gr);

        resultFromMultipleGames.setGameResponses(grListNew);

        assertEquals(grListNew, resultFromMultipleGames.getGameResponses());
    }
    @Test
    public void testEquals() {

        ResultFromMultipleGames resultFromMultipleGamesNew = new ResultFromMultipleGames(mgs, grList);

        assertEquals(resultFromMultipleGames, resultFromMultipleGamesNew);
    }

    @Test
    void testNotEquals(){


        BigDecimal stakeNew = new BigDecimal("2.00");
        BigDecimal winNew = new BigDecimal("0.50");
        BigDecimal rtpNew = new BigDecimal("0.25");
        MultipleGamesStats mgsNew = new MultipleGamesStats(stakeNew, winNew, rtpNew);
        ResultFromMultipleGames result1 = new ResultFromMultipleGames(mgs, grList);
        ResultFromMultipleGames result2 = new ResultFromMultipleGames(mgsNew, grList);

        assertNotEquals(result1, result2);
    }
}
