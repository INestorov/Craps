package com.games.craps.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class GameResponse {
    private BigDecimal stake;
    private String typeOfGame;
    private String outcomeOfRound;
    private BigDecimal payout;
    private List<DiceThrow> roundDetails;

    public GameResponse() {}

    public GameResponse(BigDecimal stake, String typeOfGame, String outcomeOfRound, BigDecimal payout, List<DiceThrow> roundDetails) {
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

    public List<DiceThrow> getRoundDetails() {
        return roundDetails;
    }

    public void setRoundDetails(List<DiceThrow> roundDetails) {
        this.roundDetails = roundDetails;
    }

    public void addRoundDetails(DiceThrow diceRolls) {
        roundDetails.add(diceRolls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResponse that = (GameResponse) o;
        return Objects.equals(stake, that.stake) && Objects.equals(typeOfGame, that.typeOfGame) && Objects.equals(outcomeOfRound, that.outcomeOfRound) && Objects.equals(payout, that.payout) && Objects.equals(roundDetails, that.roundDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stake, typeOfGame, outcomeOfRound, payout, roundDetails);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameResponse{");
        sb.append("stake=").append(stake);
        sb.append(", typeOfGame='").append(typeOfGame).append('\'');
        sb.append(", outcomeOfRound='").append(outcomeOfRound).append('\'');
        sb.append(", payout=").append(payout);
        sb.append(", roundDetails=").append(roundDetails);
        sb.append('}');
        return sb.toString();
    }
}
