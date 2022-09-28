package scr.com.battleship;

public class BattleshipGame {
    static Display display = new Display();

    static Input input = new Input();


    public static void main(String[] args) {
        display.shipArt();
        boolean exit = false;
        do {
            int menu = input.inputInt();
            switch (menu) {
                case 1 -> {
                    int boardSize = input.readInput();
                    Board board = new Board(boardSize);
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
            }
        } while (!exit);


    }
}