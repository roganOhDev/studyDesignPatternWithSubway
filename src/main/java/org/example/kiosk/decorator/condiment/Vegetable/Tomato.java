package org.example.kiosk.decorator.condiment.Vegetable;

import org.example.kiosk.decorator.condiment.CondimentDecorator;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;

public class Tomato extends CondimentDecorator {
    public Tomato(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + "토마토 추가  ";
    }

    @Override
    public int cost() {
        return sandwich.cost() + 500;
    }
}
