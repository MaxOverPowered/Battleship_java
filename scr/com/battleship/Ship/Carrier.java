package scr.com.battleship.Ship;

public class Carrier extends Ship {

    public static final int CARRIER_SIZER = 1;

    public Carrier() {
        super(CARRIER_SIZER);
    }

    @Override
    public String toString() {
        return "Carrier";
    }
}
