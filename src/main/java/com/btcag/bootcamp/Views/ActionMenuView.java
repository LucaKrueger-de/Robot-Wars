package com.btcag.bootcamp.Views;

import java.util.Scanner;

public class ActionMenuView {
    public static int action() {
        Scanner readIn = new Scanner(System.in);
        System.out.println( " Welche Aktion wollen Sie durchführen ? [1] Bewegen! [2] Angreifen! ");
        return readIn.nextInt();
    }


}
