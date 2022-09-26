package scr.com.battleship.Ship;

public class Destroyer extends Ship {

    private static final int DESTROYER_SIZER=5;

    public Destroyer() {
        super(DESTROYER_SIZER);
    }

    @Override
    public String toString() {
        return "Destroyer";
    }

}
