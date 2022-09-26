package scr.com.battleship;

import scr.com.battleship.Ship.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Player {
    private final List<Ships> shipsList;
    private final int playerNumber;
    private final Board playerBoard;
    private final Board shootingBoard;
    private final int size;

    public Player(int playerNumber, int size) {
        this.size = size;
        this.shipsList = new ArrayList<>();
        this.playerNumber = playerNumber;
        this.playerBoard = new Board(size);
        this.shootingBoard = new Board(size);
        assignShips();
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }


    public Board getShootingBoard() {
        return shootingBoard;
    }

    public List<Ships> getShipsList() {
        return shipsList;
    }


    public void checkPlayerShips() {
        for (Ships ship : shipsList) {
            ship.checkShipPartsStatuses();
        }
        removeSunkShip();
    }

    @Override
    public String toString() {
        return "Player " + playerNumber + " ";
    }

    private void removeSunkShip() {
        try {
            Ships ship = shipsList.stream()
                    .filter(Ships::isSunk)
                    .findAny()
                    .orElse(null);
            shipsList.remove(ship);
        } catch (NoSuchElementException ignored) {
        }
    }

    public void placeShip(Ships ship, List<Spot> validSpots) {
        if (validSpots.size() == ship.getSize()) {
            ship.setShipParts(validSpots);
            playerBoard.setBoardSpotEmpty(validSpots);
        }
    }

    private void assignShips() {
        this.shipsList.add(new Carrier());
        this.shipsList.add(new Battleship());
        this.shipsList.add(new Cruiser());
        this.shipsList.add(new Submarine());
        this.shipsList.add(new Destroyer());
    }


}
