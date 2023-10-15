package com.games.craps.entity;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Component
public class GameRequest {
    private BigDecimal stake;
    private String typeOfGame;

    public GameRequest() {}

    public GameRequest(BigDecimal stake, String typeOfGame) {
        this.stake = stake.setScale(2, RoundingMode.DOWN);
        this.typeOfGame = typeOfGame;
    }

    public BigDecimal getStake() {
        return stake;
    }

    public void setStake(BigDecimal stake) {
        this.stake = stake.setScale(2, RoundingMode.DOWN);
    }

    public String getTypeOfGame() {
        return typeOfGame;
    }

    public void setTypeOfGame(String typeOfGame) {
        this.typeOfGame = typeOfGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRequest that = (GameRequest) o;
        return Objects.equals(stake, that.stake) && Objects.equals(typeOfGame, that.typeOfGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stake, typeOfGame);
    }

    @Override
    public String toString() {
        return "GameRequest{" +
                "stake=" + stake +
                ", typeOfGame='" + typeOfGame + '\'' +
                '}';
    }
}
