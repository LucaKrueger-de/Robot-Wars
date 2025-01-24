package com.btcag.bootcamp.BaseGame.Views;

import com.btcag.bootcamp.BaseGame.Models.Robot;

public class AttackView {
    public static void attackDisplay(Robot robot1,Robot robot2) {
        System.out.println("Spieler " + robot1.getName() + " hat dem Spieler " + robot2.getName() + " " + robot1.getDamage() + " Lebenspunkte abgezogen.");
               System.out.println("Verbleibende Lebenspunkte: ");
               System.out.println(robot1.getName()+" → " +robot1.getHp() + " \n" + robot2.getName() + " → " + robot2.getHp());
    }

    public static void noRange() {
        System.out.println("Dein Gegner ist nicht in Reichweite! ");
    }

}
