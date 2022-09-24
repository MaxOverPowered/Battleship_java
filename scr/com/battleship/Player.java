package scr.com.battleship;

import scr.com.battleship.Ship.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Ships> shipsList;
    private final int playerNumber;
    private final Board plyerBoard;
    private final Board shootingBoard;

    public Player(int playerNumber) {
        this.shipsList = new ArrayList<>();
        this.playerNumber = playerNumber;
        this.plyerBoard = new Board();
        this.shootingBoard = new Board();
        assignShips();
    }

    public int getPlayerBoard() {
        return playerNumber;
    }

    public Board getShootingBoard() {
        return shootingBoard;
    }

    public List<Ships> getShipsList() {
        return shipsList;
    }

    private void assignShips() {
        this.shipsList.add(new Carrier());
        this.shipsList.add(new Battleship());
        this.shipsList.add(new Cruiser());
        this.shipsList.add(new Submarine());
        this.shipsList.add(new Destroyer());
    }


}
