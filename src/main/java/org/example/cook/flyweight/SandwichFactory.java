package org.example.cook.flyweight;

import org.example.Person;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;

public class SandwichFactory {
    Sandwich sandwich;
    String personName;

    public SandwichFactory(Sandwich sandwich, Person person) {
        this.sandwich = sandwich;
        this.personName = person.getName();

        System.out.println("cook sandwhich, type : " + person.getSandwichType() + "person : " + person.getName());
    }
}
