package scr.com.battleship;

public class BattleshipGame {
    static Display consoleView = new Display();
    static Input consoleInput = new Input();


    public static void main(String[] args) {
        int boardSize = consoleInput.readInput();
        Board board = new Board(boardSize);
//        board.setSize(boardSize);
        consoleView.printBoard(board);
        Game game = new Game(board);
        game.startGame();

    }}