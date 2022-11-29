package org.example;

import org.example.distribute.Distribute;
import org.example.goToSubway.percade.ReadyAndMove;
import org.example.goToSubway.percade.move.Run;
import org.example.goToSubway.percade.move.Walk;
import org.example.goToSubway.percade.move.path.Arrive;
import org.example.goToSubway.percade.move.path.Cross;
import org.example.goToSubway.percade.move.path.Left;
import org.example.goToSubway.percade.move.path.Right;
import org.example.goToSubway.percade.move.path.Straight;
import org.example.goToSubway.percade.ready.Cloth;
import org.example.goToSubway.percade.ready.Shower;
import org.example.kiosk.decorator.OrderSandwich;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;
import org.example.friendOrder.proxy.FriendOrderSandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final var A = new Person("A", SandwichType.EGG);
        final var B = new Person("B", SandwichType.EGG);
        final var C = new Person("C", SandwichType.MEAT);
        final var people = new ArrayList<>(List.of(A, B, C));

        gotoSubway();
        final var sandwichBasket = orderSandwich(people);

        final var notReceivedPeople = distribute(sandwichBasket, people);

        friendOrderSandwich(notReceivedPeople);
    }

    private static void gotoSubway() {
        final var run = new Run();
        final var walk = new Walk();
        final var readyAndMove = new ReadyAndMove(new Cloth(), new Shower(), run, new Cross(), new Left(), new Right(), new Straight(), new Arrive());

        readyAndMove.gotoSubway();
        System.out.println("\n");
    }

    private static Map<SandwichType, ArrayList<Sandwich>> orderSandwich(List<Person> people) {
        final var orderSandwich = new OrderSandwich();

        return orderSandwich.order(people);
    }

    private static List<Person> distribute(final Map<SandwichType, ArrayList<Sandwich>> sandwichBasket, final List<Person> people) {
        final var distribute = new Distribute();

        final var D = new Person("D", SandwichType.MEAT);
        final var E = new Person("E", SandwichType.EGG);
        final var F = new Person("F", SandwichType.EGG);

        final var newPeopleGroup = new ArrayList<>(people);
        newPeopleGroup.add(D);
        newPeopleGroup.add(E);
        newPeopleGroup.add(F);

        return distribute.action(sandwichBasket, newPeopleGroup);
    }

    private static void friendOrderSandwich(List<Person> notReceivedPeople) {
        final var order = new FriendOrderSandwich();

        order.order(notReceivedPeople);
    }
}
