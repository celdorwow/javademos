package com.designpatterns;

import java.lang.IllegalArgumentException;

public class EnemyShipFactory {
    public EnemyShip makeEnemyShip(String newShipType)
    throws IllegalArgumentException {
        newShipType = newShipType.toLowerCase();
        EnemyShip newShip = switch (newShipType) {
            case "u" -> new UFOEnemyShip();
            case "r" -> new RocketEnemyShip();
            case "b" -> new BigUFOEnemyShip();
            default -> null;
        };
        if (newShip == null) {
            throw new IllegalArgumentException("Unknown ship");
        }
        return newShip;
    }
}
