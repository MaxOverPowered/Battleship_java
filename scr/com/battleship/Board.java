package scr.com.battleship;

import scr.com.battleship.Ship.orientation.Orienations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private int size;
    private final Spot[][] spots;

    public Board(int size) {
        this.spots = new Spot[size][size];
        this.size = size;
        initBoard();
    }

    public Spot[][] getSpots() {
        return spots;
    }
//    public Spot getSpot(Coordinates coordinates) {
//        return spots[coordinates.getX()][coordinates.getY()];
//    }

    public void setSize(int size) {
        this.size = size;
    }
    public void setBoardSpotEmpty(List<Spot> spots) {
        for (Spot spot : spots) {
            spot.setEmpty(false);
        }
    }
    public int getSize() {
        return size;
    }
    public List<Spot> getSpotsForShip(int shipSize, Orienations orientation, Coordinates coordinates) {
        List<Spot> validSpots = new ArrayList<>();
        switch (orientation) {
            case RIGHT -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpots()[coordinates.getX()][coordinates.getY() + i].isEmpty()) {
                        validSpots.add(this.getSpots()[coordinates.getX()][coordinates.getY() + i]);
                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpots()[coordinates.getX()][coordinates.getY() - i].isEmpty()) {
                        validSpots.add(this.getSpots()[coordinates.getX()][coordinates.getY() - i]);
                    }
                }
            }
            case UP -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpots()[coordinates.getX() - i][coordinates.getY()].isEmpty()) {
                        validSpots.add(this.getSpots()[coordinates.getX() - i][coordinates.getY()]);
                    }
                }
            }
            case DOWN -> {
                for (int i = 0; i < shipSize; i++) {
                    if (this.getSpots()[coordinates.getX() + i][coordinates.getY()].isEmpty()) {
                        validSpots.add(this.getSpots()[coordinates.getX() + i][coordinates.getY()]);
                    }
                }
            }
        }
        return validSpots;
    }
    public Spot getSpot(Coordinates coordinates) {

        return spots[coordinates.getX()][coordinates.getY()];
    }

    public void markHit(Coordinates coordinates, Board enemyBoard) {
        spots[coordinates.getX()][coordinates.getY()] = enemyBoard.getSpots()[coordinates.getX()][coordinates.getY()];
    }

    public boolean isHit(Coordinates coordinates) {
        return !spots[coordinates.getX()][coordinates.getY()].isEmpty();
    }

    public void markMiss(Coordinates coordinates) {
        spots[coordinates.getX()][coordinates.getY()].setMissSign();
    }
    private void initBoard() {
        for (int row = 0; row < size; row++)
            for (int column = 0; column < size; column++)
                spots[row][column] = new Spot();
    }


}
