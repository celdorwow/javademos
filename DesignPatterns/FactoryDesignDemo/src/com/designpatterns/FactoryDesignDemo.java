package com.designpatterns;

import java.util.Scanner;

public class FactoryDesignDemo {
    public static void main(String[] args) {
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        Scanner userInput = new Scanner(System.in);

        System.out.print("What type of shit? (U/R/B): ");
        EnemyShip theEnemy;

        try {
            theEnemy = shipFactory.makeEnemyShip(userInput.nextLine());
            doStuffEnemy(theEnemy);
        } catch (IllegalArgumentException e) {
            theEnemy = null;
        } finally {
            System.out.printf(("Wrong input!%nMake sure you provide a valid ship!%n"));
        }
    }

    public static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
