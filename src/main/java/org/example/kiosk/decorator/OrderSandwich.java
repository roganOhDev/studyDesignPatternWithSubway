package org.example.kiosk.decorator;

import org.example.Person;
import org.example.cook.flyweight.Cook;
import org.example.cook.flyweight.SandwichFactory;
import org.example.kiosk.decorator.condiment.Cheese.American;
import org.example.kiosk.decorator.condiment.Cheese.Shred;
import org.example.kiosk.decorator.condiment.Souce.Sault;
import org.example.kiosk.decorator.condiment.Souce.Sugar;
import org.example.kiosk.decorator.condiment.Vegetable.Lettuce;
import org.example.kiosk.decorator.condiment.Vegetable.Tomato;
import org.example.kiosk.decorator.condiment.sandwich.EggSandwich;
import org.example.kiosk.decorator.condiment.sandwich.MeatSandwich;
import org.example.kiosk.decorator.condiment.sandwich.Sandwich;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;
import org.example.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSandwich implements Order {
    @Override
    public Map<SandwichType, ArrayList<Sandwich>> order(List<Person> people) {
        showMenus();

        final var shoppingBasket = new HashMap<SandwichType, ArrayList<Sandwich>>();
        final var cookSandwiches = new ArrayList<SandwichFactory>();

        final var eggShoppingBasket = new ArrayList<Sandwich>();
        final var meatShoppingBasket = new ArrayList<Sandwich>();

        people.forEach(person -> {
            if (person.getSandwichType().equals(SandwichType.MEAT)) {
                meatShoppingBasket.add(order(person, cookSandwiches));

            } else if (person.getSandwichType().equals(SandwichType.EGG)) {
                eggShoppingBasket.add(order(person, cookSandwiches));
            }
        });

        shoppingBasket.put(SandwichType.EGG, eggShoppingBasket);
        shoppingBasket.put(SandwichType.MEAT, meatShoppingBasket);

        return shoppingBasket;
    }

    private static void showMenus() {
        System.out.println("--------------------------------------------");
        System.out.println("에그 샌드위치 : 4000원");
        System.out.println("고기 샌드위치 : 5000원\n\n");

        System.out.println("양상추 추가 : 300원");
        System.out.println("토마토 추가 : 500원\n\n");

        System.out.println("아메리칸 치즈 추가 : 100원");
        System.out.println("슈레드 치즈 추가 : 200원\n\n");

        System.out.println("소금 소스 추가 : 20원");
        System.out.println("설탕 소스 추가 : 10원");
        System.out.println("--------------------------------------------");
    }

    private static Sandwich order(final Person person, ArrayList<SandwichFactory> cookedSandwiches) {
        var sandwich = chooseSandwich(person.getSandwichType());

        sandwich = addLettuce(sandwich);
        sandwich = addAmericanCheese(sandwich);
        sandwich = addSault(sandwich);

        System.out.println(sandwich.getDescription() + " : " + sandwich.cost() + "원");

        final var cookedSandwich = new SandwichFactory(Cook.cook(person.getSandwichType()), person);
        cookedSandwiches.add(cookedSandwich);

        return sandwich;
    }

    private static Sandwich addLettuce(Sandwich sandwich) {
        return new Lettuce(sandwich);
    }

    private static Sandwich addTomato(Sandwich sandwich) {
        return new Tomato(sandwich);
    }

    private static Sandwich addSault(Sandwich sandwich) {
        return new Sault(sandwich);
    }

    private static Sandwich addSugar(Sandwich sandwich) {
        return new Sugar(sandwich);
    }

    private static Sandwich addAmericanCheese(Sandwich sandwich) {
        return new American(sandwich);
    }

    private static Sandwich addShredCheese(Sandwich sandwich) {
        return new Shred(sandwich);
    }

    private static Sandwich chooseSandwich(final SandwichType type) {
        switch (type) {
            case EGG:
                return new EggSandwich();

            case MEAT:
                return new MeatSandwich();
        }

        throw new RuntimeException("error");
    }
}
