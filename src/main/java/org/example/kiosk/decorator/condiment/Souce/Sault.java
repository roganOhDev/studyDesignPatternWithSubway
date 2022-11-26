package org.example.kiosk.decorator.condiment.Souce;

import org.example.kiosk.decorator.condiment.CondimentDecorator;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;

public class Sault extends CondimentDecorator {
    public Sault(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + "소금 추가  ";
    }

    @Override
    public int cost() {
        return sandwich.cost() + 20;
    }
}
