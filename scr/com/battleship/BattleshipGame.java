package scr.com.battleship;

import java.util.Scanner;

public class BattleshipGame {
    static Display display = new Display();

    static Input input = new Input();


    public static void main(String[] args) {
        display.shipArt();

        int menu = input.inputInt();
        switch (menu) {
            case 1 -> {
                int boardSize = input.readInput();
                Board board = new Board(boardSize);
//        board.setSize(boardSize);
                display.printBoard(board);
                Game game = new Game(board);
                game.startGame();
            }
            case 2 -> {
                display.howToPlay();
            }
            case 0 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("Something wrong, try again...");
        }
//        if(menu==1){
//
//        }if(menu==2){}
////        int boardSize = input.readInput();
////        Board board = new Board(boardSize);
//////        board.setSize(boardSize);
//        display.printBoard(board);
//        Game game = new Game(board);
//        game.startGame();

        }
    }
}