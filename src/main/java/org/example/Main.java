package org.example;

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

public class Main {
    public static void main(String[] args) {
        gotoSubway();
        orderSandwich();
    }

    private static void gotoSubway() {
        final var run = new Run();
        final var walk = new Walk();
        final var readyAndMove = new ReadyAndMove(new Cloth(), new Shower(), run, new Cross(), new Left(), new Right(), new Straight(), new Arrive());

        readyAndMove.gotoSubway();
    }

    private static void orderSandwich() {
        final var orderSandwich = new OrderSandwich();
        orderSandwich.order();
    }
}
