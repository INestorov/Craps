package com.games.craps.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MultipleGamesStats {
    private BigDecimal stakes;
    private BigDecimal totalWin;
    private BigDecimal returnToPlayer;

    public MultipleGamesStats() {
        this.stakes = new BigDecimal("0.00").setScale(2, RoundingMode.DOWN);
        this.totalWin = new BigDecimal("0.00").setScale(2, RoundingMode.DOWN);
        this.returnToPlayer = new BigDecimal("0.00");
    }

    public MultipleGamesStats(BigDecimal stakes, BigDecimal totalWin, BigDecimal returnToPlayer) {
        this.stakes = stakes;
        this.totalWin = totalWin;
        this.returnToPlayer = returnToPlayer;
    }

    public BigDecimal getStakes() {
        return stakes;
    }

    public void setStakes(BigDecimal stakes) {
        this.stakes = stakes;
    }

    public BigDecimal getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(BigDecimal totalWin) {
        this.totalWin = totalWin;
    }

    public BigDecimal getReturnToPlayer() {
        return returnToPlayer;
    }

    public void setReturnToPlayer(BigDecimal returnToPlayer) {
        this.returnToPlayer = returnToPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipleGamesStats gameStats = (MultipleGamesStats) o;
        return Objects.equals(stakes, gameStats.stakes) && Objects.equals(totalWin, gameStats.totalWin) && Objects.equals(returnToPlayer, gameStats.returnToPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stakes, totalWin, returnToPlayer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MultipleGamesStats{");
        sb.append("stakes=").append(stakes);
        sb.append(", totalWin=").append(totalWin);
        sb.append(", returnToPlayer=").append(returnToPlayer);
        sb.append('}');
        return sb.toString();
    }
}
