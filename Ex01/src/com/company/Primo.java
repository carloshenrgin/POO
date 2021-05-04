package com.company;

public class Primo{

    static public boolean ehPrimo(int x){
        if(x == 2)
            return true;
        for(int den = 2; den <= x/2; den++){
            if(x%den == 0){
                return false;
            }
        }

        return true;
    }
}