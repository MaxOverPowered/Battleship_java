package scr.com.battleship;

import scr.com.battleship.Ship.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Ship> shipsList;
    private final int playerNumber;
    private final Board playerBoard;
    private final Board shootingBoard;
    private final int boardSize;
    private Display display;

    public Player(int playerNumber, int boardSize) {
        this.boardSize = boardSize;
        this.shipsList = new ArrayList<>();
        this.playerNumber = playerNumber;
        this.playerBoard = new Board(boardSize);
        this.shootingBoard = new Board(boardSize);
        assignShips();
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }


    public Board getShootingBoard() {
        return shootingBoard;
    }

    public List<Ship> getShipsList() {
        return shipsList;
    }


    public void checkPlayerShips() {
        for (Ship ship : shipsList) {
            ship.checkShipPartsStatuses();
        }
        removeSunkShip();
    }

    @Override
    public String toString() {
        return "Player " + playerNumber + " \n";
    }

    private void removeSunkShip() {
            Ship ship = shipsList.stream()
                    .filter(Ship::isSunk)
                    .findAny()
                    .orElse(null);
            shipsList.remove(ship);



    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean placeShip(Ship ship, List<Spot> validSpots) {
        if (validSpots.size() == ship.getSize()) {
            ship.setShipParts(validSpots);
            playerBoard.setBoardSpotEmpty(validSpots);
            return true;
        }
        System.out.println("The ship cannot fit because of another ship");
        return false;
    }

    private void assignShips() {
        shipsList.add(new Carrier());
        shipsList.add(new Battleship());
        shipsList.add(new Cruiser());
        shipsList.add(new Submarine());
        shipsList.add(new Destroyer());
    }
}
