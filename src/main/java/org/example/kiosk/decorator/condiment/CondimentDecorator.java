package org.example.kiosk.decorator.condiment;

import org.example.kiosk.decorator.condiment.sandwich.Sandwich;

public abstract class CondimentDecorator extends Sandwich {
    protected Sandwich sandwich;

    @Override
    public abstract String getDescription();
}
