package org.example.distribute;

import org.example.Person;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Distribute {
    public List<Person> action(final Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, final ArrayList<Person> people) {
        final var notReceivedPeople = new ArrayList<Person>();

        people.forEach(person -> {
            giveSandwich(sandwichBasket, person, notReceivedPeople);
        });

        return notReceivedPeople;
    }

    private static void giveSandwich(Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, Person person, ArrayList<Person> notReceivedPeople) {
        openBasket(sandwichBasket, person, notReceivedPeople);
    }

    private static void openBasket(Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, Person person, ArrayList<Person> notReceivedPeople) {
        final var sandwichType = person.getSandwichType();
        final var sandwiches = sandwichBasket.get(sandwichType);

        if (sandwiches == null || sandwiches.size() == 0) {
            System.out.println("no more sandwich for " + person.getName() + " sandwichType : " + sandwichType);
            notReceivedPeople.add(person);

        } else {
            sandwiches.remove(0);
            System.out.println("give " + sandwichType + " sandwich to " + person.getName());
        }
    }
}
