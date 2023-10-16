package com.games.craps.entity;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Component
public class GameResponse {
    private BigDecimal stake;
    private String typeOfGame;
    private String outcomeOfRound;
    private BigDecimal payout;
    private List<List<Integer>> roundDetails;

    public GameResponse() {}

    public GameResponse(BigDecimal stake, String typeOfGame, String outcomeOfRound, BigDecimal payout, List<List<Integer>> roundDetails) {
        this.stake = stake;
        this.typeOfGame = typeOfGame;
        this.outcomeOfRound = outcomeOfRound;
        this.payout = payout;
        this.roundDetails = roundDetails;
    }

    public BigDecimal getStake() {
        return stake;
    }

    public void setStake(BigDecimal stake) {
        this.stake = stake;
    }

    public String getTypeOfGame() {
        return typeOfGame;
    }

    public void setTypeOfGame(String typeOfGame) {
        this.typeOfGame = typeOfGame;
    }

    public String getOutcomeOfRound() {
        return outcomeOfRound;
    }

    public void setOutcomeOfRound(String outcomeOfRound) {
        this.outcomeOfRound = outcomeOfRound;
    }

    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }

    public List<List<Integer>> getRoundDetails() {
        return roundDetails;
    }

    public void setRoundDetails(List<List<Integer>> roundDetails) {
        this.roundDetails = roundDetails;
    }

    public void addRoundDetails(List<Integer> diceRolls) {
        roundDetails.add(diceRolls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResponse that = (GameResponse) o;
        return Objects.equals(stake, that.stake) && Objects.equals(payout, that.payout) && Objects.equals(typeOfGame, that.typeOfGame) && Objects.equals(outcomeOfRound, that.outcomeOfRound) && Objects.equals(roundDetails, that.roundDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stake, typeOfGame, outcomeOfRound, payout, roundDetails);
    }

    @Override
    public String toString() {
        return "Round{" +
                "stake=" + stake +
                ", typeOfGame='" + typeOfGame + '\'' +
                ", outcomeOfRound='" + outcomeOfRound + '\'' +
                ", payout=" + payout +
                ", roundDetails='" + roundDetails + '\'' +
                '}';
    }
}
