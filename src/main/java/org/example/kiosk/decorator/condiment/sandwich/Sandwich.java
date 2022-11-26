package org.example.kiosk.decorator.condiment.sandwich;

import lombok.ToString;

public abstract class Sandwich {
    String description = "샌드위치";

    public String getDescription(){
        return description;
    }

    public abstract int cost();
}
