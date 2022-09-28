package scr.com.battleship;

import scr.com.battleship.Ship.Orientation;
import scr.com.battleship.Ship.Ship;

import java.util.List;

public class Game {
    private final Player player1;
    private final Player player2;
    private boolean gameIsRunning;
    private final Display display;
    private final Input input;

    public Game(Board board) {
        player1 = new Player(1, board.getSize());
        player2 = new Player(2, board.getSize());
        gameIsRunning = true;
        display = new Display();
        input = BattleshipGame.input;
    }

    public void startGame() {
        playerSetsShips(player1);
        playerSetsShips(player2);

        Player player = player1;
        while (gameIsRunning) {
            Coordinates coordinates;
            Board enemyBoard = getAnotherPlayer(player).getPlayerBoard();
            Board playerBoard = player.getPlayerBoard();
            Board shootingBoard = player.getShootingBoard();
            Player enemyPlayer = getAnotherPlayer(player);
            display.printMessage(player.toString() + " destroy the other player ships\n");
            display.printBoard(shootingBoard);
            coordinates = input.getCoordinates();
            if (enemyBoard.isHit(coordinates)) {
                enemyBoard.getSpot(coordinates).getShipPart().asHit();
                enemyPlayer.checkPlayerShips();
                shootingBoard.markHit(coordinates, enemyBoard);
            } else {
                shootingBoard.markMiss(coordinates);
            }

            doesEnemyLose(enemyPlayer);
            if (gameIsRunning) {
                display.printMessageInNewLine("\n\n\nShorting board "+ player);
                display.printBoard(shootingBoard);
                player = getAnotherPlayer(player);
            } else {
                display.printBoard(shootingBoard);
                display.playerWin(player);
            }
        }
    }

    private Player getAnotherPlayer(Player player) {
        if (player.equals(player1)) {
            player = player2;
        } else {
            player = player1;

        }
        return player;
    }

    private void doesEnemyLose(Player enemyPlayer) {
        if (enemyPlayer.getShipsList().isEmpty()) {
            gameIsRunning = false;
        }
    }

    private void playerSetsShips(Player player) {
        Coordinates coordinates;
        Orientation orientation;
        List<Spot> validSpots;

        display.printMessage(player.toString());
        for (Ship ship : player.getShipsList()) {
            if (ship.getSize() != 1) {
                display.printMessage("Place your " + ship + "! Size: " + ship.getSize() + "\n");
                display.printBoard(player.getPlayerBoard());
                coordinates = input.getCoordinates();
                display.askForOrientation();
                orientation = input.getOrientation();
                validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), orientation, coordinates);
                while (validSpots == null) {
                    coordinates = input.getCoordinates();
                    display.askForOrientation();
                    orientation = input.getOrientation();
                    validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), orientation, coordinates);
                }
                while (!player.placeShip(ship, validSpots)) {
                    coordinates = input.getCoordinates();
                    display.askForOrientation();
                    orientation = input.getOrientation();
                    validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), orientation, coordinates);
                }
            } else {
                display.printMessage("Place your " + ship + "! Size: " + ship.getSize() + "\n");
                display.printBoard(player.getPlayerBoard());
                coordinates = input.getCoordinates();
                validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), Orientation.RIGHT, coordinates);
                if (validSpots == null) {
                    coordinates = input.getCoordinates();
                    validSpots = player.getPlayerBoard().getSpotsForShip(ship.getSize(), Orientation.RIGHT, coordinates);
                }
                player.placeShip(ship, validSpots);

            }
        }
        display.printBoard(player.getPlayerBoard());
    }
}
