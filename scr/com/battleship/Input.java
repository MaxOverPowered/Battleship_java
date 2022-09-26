package scr.com.battleship;

import scr.com.battleship.Ship.orientation.Orienations;

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
        int sizeBord = 0;
        do {
//            System.out.println();
            System.out.println("Choose a board size between 10 and 30 ");
            while (!scanner.hasNextInt()) {
                String userScan = scanner.next();
                if (!userScan.equalsIgnoreCase("quit")) {
                    display.printMessageInNewLine("That is not a number,Try again");
//                    System.out.println("Choose a board size between 10 and 20 ");
                } else {
                    System.exit(0);
                }
            }
          sizeBord= scanner.nextInt();
        } while (sizeBord <= 10 || sizeBord > 30);
        display.printMessageInNewLine(String.format("%d", sizeBord));
        return sizeBord;
    }

    public Coordinates getCoordinates() {
        String chosenCoordinates;
        Scanner scanner = new Scanner(System.in);
        do {
            display.askForCoordinates();
            chosenCoordinates = scanner.next();
        } while (!validUserInput(chosenCoordinates));

        int row = Character.getNumericValue(chosenCoordinates.charAt(0)) - 10;
        int colFirstDigit = Character.getNumericValue(chosenCoordinates.charAt(1));

        switch (chosenCoordinates.length()) {
            case 2 -> {
                return new Coordinates(row, colFirstDigit - 1);
            }
            case 3 -> {
                int colSecondDigit = Character.getNumericValue(chosenCoordinates.charAt(2));
                String addedDigits = (colFirstDigit) + "" + (colSecondDigit);
                int col = Integer.parseInt(addedDigits);
                return new Coordinates(row, col - 1);
            }
        }
        return new Coordinates(0, 0);
    }

    private boolean validUserInput(String chosenCoordinates) {
        switch (chosenCoordinates.length()) {
            case 2 -> {
                try {
                    char isCharValid = chosenCoordinates.charAt(0);
                    char isFirstDigitValid = chosenCoordinates.charAt(1);

                    if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
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
                    char isCharValid = chosenCoordinates.charAt(0);
                    char isFirstDigitValid = chosenCoordinates.charAt(1);
                    char isSecondDigitValid = chosenCoordinates.charAt(2);

                    String addedDigits = (isFirstDigitValid) + "" + (isSecondDigitValid);
                    int row = Integer.parseInt(addedDigits);
                    if (Character.toString(isCharValid).matches("^[a-jA-J]*$")) {
                        return row > 0 && row <= 10;

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

    public Orienations getOrientation() {
        Scanner scanner = new Scanner(System.in);
        int chosenOrientation = scanner.nextInt();
        switch (chosenOrientation) {
            case 1 -> {
                return Orienations.UP;
            }
            case 2 -> {
                return Orienations.RIGHT;
            }
            case 3 -> {
                return Orienations.DOWN;
            }
            default -> {
                return Orienations.LEFT;
            }
        }
    }

    public void pressAnyKeyToContinue() {
    }
}
