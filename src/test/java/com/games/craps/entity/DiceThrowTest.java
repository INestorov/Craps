package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceThrowTest {
    private DiceThrow diceThrow;

    @BeforeEach
    void setUp(){
        diceThrow = new DiceThrow(1, 1 ,5);
    }

    @Test
    void testGetThrowNumber(){
        assertEquals(1, diceThrow.getThrowNumber());
    }

    @Test
    void testSetThrowNumber() {
        int secondThrow = 2;
        diceThrow.setThrowNumber(secondThrow);

        assertEquals(2, diceThrow.getThrowNumber());
    }

    @Test
    void testGetFirstDice(){
        assertEquals(1, diceThrow.getFirstDice());
    }

    @Test
    void testSetFirstDice(){
        diceThrow.setFirstDice(4);

        assertEquals(4, diceThrow.getFirstDice());
    }


    @Test
    void testGetSecondDice(){
        assertEquals(5, diceThrow.getSecondDice());
    }

    @Test
    void testSetSecondDice(){
        diceThrow.setSecondDice(4);

        assertEquals(4, diceThrow.getSecondDice());
    }

    @Test
    void testConstructor(){
        int thirdThrow = 3;
        int firstDice = 4;
        int secondDice = 6;

        DiceThrow dt = new DiceThrow(thirdThrow,firstDice, secondDice);

        assertEquals(thirdThrow, dt.getThrowNumber());
        assertEquals(firstDice, dt.getFirstDice());
        assertEquals(secondDice, dt.getSecondDice());
    }

    @Test
    void testEquals(){
        DiceThrow diceThrow1 = new DiceThrow(1, 1, 5);

        assertEquals(diceThrow, diceThrow1);
    }

    @Test
    void testNotEquals(){
        DiceThrow diceThrow1 = new DiceThrow(1, 2, 5);

        assertNotEquals(diceThrow, diceThrow1);
    }
}
