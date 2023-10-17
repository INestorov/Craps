package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MultipleGamesStatsTest {
    private MultipleGamesStats mgs;

    @BeforeEach
    void setUp(){
        BigDecimal stakes = new BigDecimal("50.00");
        BigDecimal totalWin = new BigDecimal("10.00");
        BigDecimal rtp = totalWin.divide(stakes, 2, RoundingMode.DOWN);

        mgs = new MultipleGamesStats(stakes, totalWin, rtp);
    }

    @Test
    void testGetStakes(){   assertThat(mgs.getStakes(), equalTo(new BigDecimal("50.00")));   }

    @Test
    void testSetStakes(){
        BigDecimal newStake = new BigDecimal("65.00");
        mgs.setStakes(newStake);

        assertThat(mgs.getStakes(), equalTo(newStake));
    }

    @Test
    void testGetTotalWin(){ assertThat(mgs.getTotalWin(), equalTo(new BigDecimal("10.00")));    }

    @Test
    void testSetTotalWin(){
        BigDecimal newTotalWin = new BigDecimal("15.00");
        mgs.setStakes(newTotalWin);

        assertThat(mgs.getStakes(), equalTo(newTotalWin));
    }

    @Test
    void testGetRtp(){  assertThat(mgs.getReturnToPlayer(), equalTo(new BigDecimal("0.20")));   }

    @Test
    void testSetRtp(){
        BigDecimal newRtp = new BigDecimal("1.00");
        mgs.setReturnToPlayer(newRtp);

        assertThat(mgs.getReturnToPlayer(), equalTo(newRtp));
    }

    @Test
    void testEquals(){
        BigDecimal stakes = new BigDecimal("50.00");
        BigDecimal totalWin = new BigDecimal("10.00");
        BigDecimal rtp = totalWin.divide(stakes, 2, RoundingMode.DOWN);

        MultipleGamesStats multipleGamesStats = new MultipleGamesStats(stakes, totalWin, rtp);

        assertEquals(mgs, multipleGamesStats);
    }

    @Test
    void testNotEquals(){
        BigDecimal stakes = new BigDecimal("50.00");
        BigDecimal totalWin = new BigDecimal("15.00");
        BigDecimal rtp = totalWin.divide(stakes, 2, RoundingMode.DOWN);

        MultipleGamesStats multipleGamesStats = new MultipleGamesStats(stakes, totalWin, rtp);

        assertNotEquals(mgs, multipleGamesStats);
    }
}
