package com.games.craps.entity;

import java.util.List;
import java.util.Objects;

public class ResultFromMultipleGames {
    private MultipleGamesStats gameStats;
    private List<GameResponse> gameResponses;

    public ResultFromMultipleGames(MultipleGamesStats gameStats, List<GameResponse> gameResponses) {
        this.gameStats = gameStats;
        this.gameResponses = gameResponses;
    }

    public MultipleGamesStats getGameStats() {
        return gameStats;
    }

    public void setGameStats(MultipleGamesStats gameStats) {
        this.gameStats = gameStats;
    }

    public List<GameResponse> getGameResponses() {
        return gameResponses;
    }

    public void setGameResponses(List<GameResponse> gameResponses) {
        this.gameResponses = gameResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultFromMultipleGames that = (ResultFromMultipleGames) o;
        return Objects.equals(gameStats, that.gameStats) && Objects.equals(gameResponses, that.gameResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameStats, gameResponses);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultFromMultipleGames{");
        sb.append("gameStats=").append(gameStats);
        sb.append(", gameResponses=").append(gameResponses);
        sb.append('}');
        return sb.toString();
    }
}
