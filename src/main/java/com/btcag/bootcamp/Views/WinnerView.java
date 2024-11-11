package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Robot;

public class WinnerView {
    public static void display(Robot winner) {
        System.out.println(winner.getName() + " hat den Kampf gewonnen!");
    }

}
