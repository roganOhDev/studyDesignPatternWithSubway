package org.example.distribute.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.Person;
import org.example.kiosk.decorator.condiment.sandwich.SandwichType;

@Getter
@AllArgsConstructor
public class NotReceived {
    private SandwichType sandwichType;
    private Person person;
}
