package org.example.kiosk.decorator.condiment.sandwich;

public abstract class Sandwich {
    String description = "샌드위치";
    SandwichType type;

    public String getDescription(){
        return description;
    }

    public abstract int cost();

    public SandwichType getType(){
        return type;
    }
}
