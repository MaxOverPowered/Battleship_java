package scr.com.battleship;

import scr.com.battleship.Ship.Orientation;

import java.util.Scanner;

public class Input {
    public final Scanner scanner;
    private final Display display;
    int sizeBord;


    public Input() {
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }

    public int inputInt() {
        display.menu();
        int number = scanner.nextInt();
        return number;
    }

    public int readInput() {
        do {
            display.printMessageInNewLine("Choose a board size between 10 and 20 ");
            while (!scanner.hasNextInt()) {
                String userScan = scanner.next();
                if (!userScan.equalsIgnoreCase("quit")) {
                    display.printMessageInNewLine("That is not a number,Try again");
                } else {
                    System.exit(0);
                }
            }
            sizeBord = scanner.nextInt();
        } while (validateBoardSize());
        display.printMessageInNewLine(String.format("%d", sizeBord));
        return sizeBord;
    }

    private boolean validateBoardSize() {
        return sizeBord < 10 || sizeBord > 20;
    }


    public Coordinates getCoordinates() {
        String chosenCoord;
//        Scanner scanner = new Scanner(System.in);
        do {
            display.askForCoordinates();
            chosenCoord = scanner.next();
        } while (!validUserInput(chosenCoord));
        int row = Character.getNumericValue(chosenCoord.charAt(0)) - 10;
        int colFirstDigit = Character.getNumericValue(chosenCoord.charAt(1));
        switch (chosenCoord.length()) {
            case 2 -> {
                return new Coordinates(row, colFirstDigit - 1);
            }
            case 3 -> {
                int colSecondDigit = Character.getNumericValue(chosenCoord.charAt(2));
                String addedDigits = (colFirstDigit) + "" + (colSecondDigit);
                int col = Integer.parseInt(addedDigits);
                return new Coordinates(row, col - 1);
            }
        }
        return new Coordinates(0, 0);
    }

    private boolean validUserInput(String chooseCoord) {
        switch (chooseCoord.length()) {
            case 2 -> {
                try {
                    char isCharValid = chooseCoord.charAt(0);
                    char isFirstDigitValid = chooseCoord.charAt(1);

                    if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
//                    if (Character.isAlphabetic(isCharValid)) {
                        return Character.toString(isFirstDigitValid).matches("^[1-9]*$");
                    }
                    System.out.println("Something wrong, try again...");
                    return false;
                } catch (Exception e) {
                    System.out.println("Something wrong, try again...");
                    return false;
                }
            }
            case 3 -> {
                try {
                    char isCharValid = chooseCoord.charAt(0);
                    char isFirstDigitValid = chooseCoord.charAt(1);
                    char isSecondDigitValid = chooseCoord.charAt(2);

                    String addedDigits = (isFirstDigitValid) + "" + (isSecondDigitValid);
                    int row = Integer.parseInt(addedDigits);
                    if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
                        return row > 0 && row <= sizeBord;

                    }
                    System.out.println("Something wrong, try again...");
                    return false;
                } catch (Exception e) {
                    System.out.println("Something wrong, try again...");
                    return false;
                }
            }
            default -> {
                System.out.println("Something wrong, try again...");
                return false;
            }
        }
    }

    public Orientation getOrientation() {
//        Scanner scanner = new Scanner(System.in);
        int chosenOrientation = scanner.nextInt();
        try {
            switch (chosenOrientation) {
                case 1 -> {
                    return Orientation.UP;
                }
                case 2 -> {
                    return Orientation.RIGHT;
                }
                case 3 -> {
                    return Orientation.DOWN;
                }
                default -> {
                    return Orientation.LEFT;
                }
            }
        } catch (Exception ignored) {
            display.printMessageInNewLine("Something is wrong, Try again !");
            return null;
        }
    }

}
