package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Items;
import com.btcag.bootcamp.Models.Robot;

public class ItemView {
    public  static void effectView(Items item){
        System.out.println("Sie haben ein Item eingesammelt. Der Effekt: "+item.effectName()+ " "+item.getValue());
    }

}
