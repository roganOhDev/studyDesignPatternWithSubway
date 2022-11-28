package org.example.distribute.flyweight;

import org.example.Person;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Distribute {
    public List<NotReceived> action(final Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, final ArrayList<Person> people) {
        final var notReceivedPeople = new ArrayList<NotReceived>();

        people.forEach(person -> {
            giveSandwich(sandwichBasket,person, notReceivedPeople);
        });

        return notReceivedPeople;
    }

    private static void giveSandwich(Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, Person person, ArrayList<NotReceived> notReceivedPeople) {
        switch (person.getSandwichType()) {
            case EGG:
                openBasket(sandwichBasket, SandwichType.EGG, person,notReceivedPeople);
                break;

            case MEAT:
                openBasket(sandwichBasket, SandwichType.MEAT, person,notReceivedPeople);
                break;
        }
    }

    private static void openBasket(Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, SandwichType sandwichType, Person person, ArrayList<NotReceived> notReceivedPeople){
        final var sandwiches = sandwichBasket.get(sandwichType);

        if (sandwiches == null || sandwiches.size() == 0) {
            System.out.println("no more sandwich for " + person.getName() + " sandwichType : " + sandwichType);
            notReceivedPeople.add(new NotReceived(sandwichType, person));

        } else {
            sandwiches.remove(0);
            System.out.println("give " + sandwichType + " sandwich to " + person.getName());
        }
    }
}
