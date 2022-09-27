package scr.com.battleship;

import scr.com.battleship.Ship.ShipPart;

public class Spot {
    private String sign;
    private boolean empty;
    private ShipPart shipPart;

    public Spot() {
        this.empty = true;
        this.sign = "\uD83D\uDCA7";
        this.shipPart = null;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = String.valueOf(sign);
    }

    public void setMissSign() {
        this.sign = " \u2668";
    }

    public void setShipPart(ShipPart shipPart) {
        this.shipPart = shipPart;
    }

    public ShipPart getShipPart() {
        return shipPart;
    }
}
