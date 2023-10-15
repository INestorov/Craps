package com.games.craps.Validator;

import com.games.craps.Entity.GameRequest;

import java.math.BigDecimal;

public class RequestValidator {
    public static boolean validateRequest(GameRequest gameRequest) {
        if(gameRequest.getStake().compareTo(BigDecimal.ZERO) > 0) return gameRequest.getTypeOfGame().equalsIgnoreCase("craps");
        return false;
    }
}
