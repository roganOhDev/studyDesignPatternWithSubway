package org.example.distribute.flyweight;

import org.example.Person;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Distribute {
    public List<NotReceived> action(final Map<SandwichType, List<Sandwich>> sandwiches, final ArrayList<Person> people) {
        final var eggSandwiches = openEggSandwichesBasket(sandwiches);
        final var meatSandwiches = openMeatSandwichesBasket(sandwiches);
        final var notReceivedPeople = new ArrayList<NotReceived>();

        people.forEach(person -> {
            giveSandwich(eggSandwiches, meatSandwiches, person, notReceivedPeople);
        });

        return notReceivedPeople;
    }

    private static ArrayList<Sandwich> openEggSandwichesBasket(Map<SandwichType, List<Sandwich>> sandwiches) {
        if (sandwiches.get(SandwichType.EGG) == null) {
            return null;
        }
        return new ArrayList<>(sandwiches.get(SandwichType.EGG));
    }

    private static ArrayList<Sandwich> openMeatSandwichesBasket(Map<SandwichType, List<Sandwich>> sandwiches) {
        if (sandwiches.get(SandwichType.MEAT) == null) {
            return null;
        }
        return new ArrayList<>(sandwiches.get(SandwichType.MEAT));
    }

    private static void giveSandwich(ArrayList<Sandwich> eggSandwiches, ArrayList<Sandwich> meatSandwiches, Person person, ArrayList<NotReceived> notReceivedPeople) {
        switch (person.getSandwichType()) {
            case EGG:
                if (eggSandwiches == null || eggSandwiches.size() == 0) {
                    System.out.println("no more sandwich for " + person.getName() + " sandwichType : " + SandwichType.EGG);
                    notReceivedPeople.add(new NotReceived(SandwichType.EGG, person));

                } else {
                    eggSandwiches.remove(0);
                    System.out.println("give " + SandwichType.EGG + " sandwich to " + person.getName());
                }
                break;

            case MEAT:
                if (meatSandwiches == null || meatSandwiches.size() == 0) {
                    System.out.println("no more sandwich for " + person.getName() + " sandwichType : " + SandwichType.MEAT);
                    notReceivedPeople.add(new NotReceived(SandwichType.MEAT, person));

                } else {
                    meatSandwiches.remove(0);
                    System.out.println("give " + SandwichType.MEAT + " sandwich to " + person.getName());
                }
                break;
        }
    }
}
