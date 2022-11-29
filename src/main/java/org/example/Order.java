package org.example;

import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Order {
    Map<SandwichType, ArrayList<Sandwich>> order(List<Person> people);
}
