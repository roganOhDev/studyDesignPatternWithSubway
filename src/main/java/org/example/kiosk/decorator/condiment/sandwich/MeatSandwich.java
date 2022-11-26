package org.example.kiosk.decorator.condiment.sandwich;

public class MeatSandwich extends Sandwich{
    public MeatSandwich(){
        description = "고기샌드위치  ";
        type = SandwichType.MEAT;
    }

    @Override
    public int cost() {
        return 5000;
    }

    @Override
    public SandwichType getType() {
        return SandwichType.MEAT;
    }
}
