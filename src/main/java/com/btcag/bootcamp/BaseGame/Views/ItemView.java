package com.btcag.bootcamp.BaseGame.Views;

import com.btcag.bootcamp.BaseGame.Models.Items;

public class ItemView {
    public  static void effectView(Items item){
        System.out.println("Sie haben ein Item eingesammelt. Der Effekt: "+item.effectName()+ " "+item.getValue());
    }

}
