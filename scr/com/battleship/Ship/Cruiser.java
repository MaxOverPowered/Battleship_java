package scr.com.battleship.Ship;

public class Cruiser extends Ship {

    public static final int CRUISER_SIZE = 2;

    public Cruiser() {
        super(CRUISER_SIZE);
    }

    @Override
    public String toString() {
        return "Cruiser";
    }

}
