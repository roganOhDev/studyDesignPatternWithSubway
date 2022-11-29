package org.example.cook.flyweight;

import org.example.kiosk.decorator.condiment.sandwich.EggSandwich;
import org.example.kiosk.decorator.condiment.sandwich.MeatSandwich;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

import java.util.HashMap;

public class Cook {
    private static final HashMap<SandwichType, Sandwich> sandwichMap= new HashMap<>();

    public static Sandwich cook(SandwichType sandwichType) {
        var sandwhichImpl = sandwichMap.get(sandwichType);

        if (sandwhichImpl == null) {
            if (sandwichType.equals(SandwichType.EGG)) {
                sandwhichImpl = new EggSandwich();

            } else if (sandwichType.equals(SandwichType.MEAT)) {
                sandwhichImpl = new MeatSandwich();
            }
        }

        sandwichMap.put(sandwichType, sandwhichImpl);

        return sandwhichImpl;
    }
}
