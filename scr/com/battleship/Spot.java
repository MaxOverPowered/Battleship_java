package scr.com.battleship;

import scr.com.battleship.Ship.ShipPart;

public class Spot {
    private char sign;
    private boolean empty;
    private ShipPart shipPart;

    public Spot(){
        this.empty=true;
        this.sign='~';
        this.shipPart=null;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void setShipPart(ShipPart shipPart) {
        this.shipPart = shipPart;
    }

    public ShipPart getShipPart() {
        return shipPart;
    }
}
