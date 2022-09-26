package scr.com.battleship.Ship;

public class Battleship extends Ship {

    public static final int BATTLESHIP_SIZER = 3;

    public Battleship() {
        super(BATTLESHIP_SIZER);
    }

    @Override
    public String toString() {
        return "Battleship";
    }

}

