package org.example.kiosk.decorator.condiment.sandwich;

public class EggSandwich extends Sandwich{
    public EggSandwich(){
        description = "에그샌드위치  ";
    }

    @Override
    public int cost() {
        return 4000;
    }
}
