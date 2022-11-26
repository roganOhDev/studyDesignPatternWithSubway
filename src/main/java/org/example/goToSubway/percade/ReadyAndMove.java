package org.example.goToSubway.percade;

import org.example.goToSubway.percade.move.Move;
import org.example.goToSubway.percade.move.path.Arrive;
import org.example.goToSubway.percade.move.path.Cross;
import org.example.goToSubway.percade.move.path.Left;
import org.example.goToSubway.percade.move.path.Right;
import org.example.goToSubway.percade.move.path.Straight;
import org.example.goToSubway.percade.ready.Cloth;
import org.example.goToSubway.percade.ready.Shower;

public class ReadyAndMove {
    private final Cloth cloth;
    private final Shower shower;
    private final Move move;
    private final Cross cross;
    private final Left left;
    private final Right right;
    private final Straight straight;
    private final Arrive arrive;


    public ReadyAndMove(Cloth cloth, Shower shower, Move move, Cross cross, Left left, Right right, Straight straight, Arrive arrive) {
        this.cloth = cloth;
        this.shower = shower;
        this.move = move;
        this.cross = cross;
        this.left = left;
        this.right = right;
        this.straight = straight;
        this.arrive = arrive;
    }

    public void gotoSubway(){
        System.out.println("go to subway");

        shower.move();
        cloth.putOn();

        move.go();

        straight.go();
        straight.go();
        straight.go();
        cross.street();
        left.turn();
        right.turn();

        arrive.subway();
    }
}
