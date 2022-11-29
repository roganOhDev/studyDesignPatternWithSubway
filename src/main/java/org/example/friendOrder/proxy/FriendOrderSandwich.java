package org.example.friendOrder.proxy;

import org.example.Order;
import org.example.Person;
import org.example.kiosk.decorator.OrderSandwich;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FriendOrderSandwich implements Order {
    @Override
    public Map<SandwichType, ArrayList<Sandwich>> order(List<Person> people) {
        System.out.println("\n");
        System.out.println("전화 거는 중 ..");
        System.out.println("전화 대기 중 ..");

        final var orderSandwich = new OrderSandwich();

        return orderSandwich.order(people);
    }
}
