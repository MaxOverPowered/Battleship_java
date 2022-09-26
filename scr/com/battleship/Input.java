package scr.com.battleship;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private final Display display;


    public Input() {
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }

    public int validation() {
//        Scanner size = new Scanner(System.in);
        int sizeBord;
        do {
//            System.out.println();
//            System.out.println("Choose a board size between 10 and 20 ");
            while (!scanner.hasNextInt()) {
                String userScan = scanner.next();
                if (!userScan.equalsIgnoreCase("quit")) {
                    display.printMessageInNewLine("That is not a number,Try again");
//                    System.out.println("Choose a board size between 10 and 20 ");
                } else {
                    System.exit(0);
                }
            }
            sizeBord = scanner.nextInt();
            display.printMessageInNewLine(String.format("%d",sizeBord));
            return sizeBord;
        } while (sizeBord < 5 || sizeBord > 20);
    }
}
