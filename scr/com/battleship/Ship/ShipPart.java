package scr.com.battleship.Ship;

public class ShipPart {
    private ShipStatus status;
    private char sign;

    public ShipPart() {
        this.status = ShipStatus.STRONG;
        this.sign = '$';
    }

    public void asHit() {
        status = ShipStatus.HIT;
        sign = '@';
    }

    public void asSunk() {
        status = ShipStatus.SUNK;
        sign = '*';
    }

    public char getSign() {
        return sign;
    }

    public ShipStatus getStatus() {
        return status;
    }
}
