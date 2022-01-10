package com.example.library2.wildcards;

public class Tray {
    public void add(Glass<? extends Juice> juiceGlass){//here we used wildcard to accept any type of type argument
    }
    public void remove(Glass<? super CokeZero> colaGlass){}//any supertype of CokeZero
}
