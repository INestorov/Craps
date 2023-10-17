package com.games.craps.entity;

import java.util.Objects;

public class DiceThrow {
    private int throwNumber;
    private int firstDice;
    private int secondDice;

    public DiceThrow(int throwNumber, int firstDice, int secondDice) {
        this.throwNumber = throwNumber;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
    }

    public int getThrowNumber() {
        return throwNumber;
    }

    public void setThrowNumber(int throwNumber) {
        this.throwNumber = throwNumber;
    }

    public int getFirstDice() {
        return firstDice;
    }

    public void setFirstDice(int firstDice) {
        this.firstDice = firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }

    public void setSecondDice(int secondDice) {
        this.secondDice = secondDice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiceThrow diceThrow = (DiceThrow) o;
        return throwNumber == diceThrow.throwNumber && firstDice == diceThrow.firstDice && secondDice == diceThrow.secondDice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(throwNumber, firstDice, secondDice);
    }

    @Override
    public String toString() {
        return "DiceThrow{" +
                "throwNumber=" + throwNumber +
                ", firstDice=" + firstDice +
                ", secondDice=" + secondDice +
                '}';
    }
}
