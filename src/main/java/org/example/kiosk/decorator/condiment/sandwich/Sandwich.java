package org.example.kiosk.decorator.condiment.sandwich;

public abstract class Sandwich {
    String description = "μλμμΉ";
    SandwichType type;

    public String getDescription(){
        return description;
    }

    public abstract int cost();

    public SandwichType getType(){
        return type;
    }
}
