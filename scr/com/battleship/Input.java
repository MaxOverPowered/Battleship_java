package scr.com.battleship;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private final Display display;


    public Input() {
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }
}
