package com.games.craps.entity;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class GameRequest {
    @DecimalMin(value="0.0", inclusive = false, message = "Stakes must be larger than 0.")
    private BigDecimal stake;

    @Pattern(regexp = "(?i)craps", message = "Type of game must be: 'craps'.")
    private String typeOfGame;

    public GameRequest(BigDecimal stake, String typeOfGame) {
        this.stake = stake.setScale(2, RoundingMode.DOWN);
        this.typeOfGame = typeOfGame.toLowerCase();
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
        this.typeOfGame = typeOfGame.toLowerCase();
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
