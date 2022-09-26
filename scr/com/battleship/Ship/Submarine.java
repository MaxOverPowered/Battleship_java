package scr.com.battleship.Ship;

public class Submarine extends Ship {

    private static final int SUBMARINE_SIZER = 4;

    public Submarine() {
        super(SUBMARINE_SIZER);
    }

    @Override
    public String toString() {
        return "Submarine";
    }
}
