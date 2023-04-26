package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class PipeMan extends Cat {
    //attributes
    public PipeMan(String colour) {
        super(colour, 24, 24, 6, 8, 0);
    }

    //actions
    @Override
    public void uniqueAbility() {//Increases defence power +1 by consuming 1 attack point!
        if (this.attackPower > 1) {
            this.attackPower -= 1;
            this.defencePower += 1;
        }
    }
}