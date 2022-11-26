package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private SandwichType sandwichType;
}
