package scr.com.battleship.Ship;

public class ShipPart {
    private ShipStatus status;
    private String sign;

    public ShipPart() {
        this.status = ShipStatus.STRONG;
        this.sign = "\uD83D\uDEA2";
    }

    public void asHit() {
        status = ShipStatus.HIT;
        sign = "\uD83D\uDD25";
    }

    public void asSunk() {
        status = ShipStatus.SUNK;
        sign = " \uD83D\uDD6F ";
    }

    public String getSign() {
        return sign;
    }

    public ShipStatus getStatus() {
        return status;
    }
}
