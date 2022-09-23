package scr.com.battleship.Ship;

import scr.com.battleship.Spot;

import java.util.ArrayList;
import java.util.List;

public abstract class Ships {
    private final int size;
    private boolean sunk;
    private List<ShipPart> shipParts;

    public Ships(int size) {
        this.size = size;
        this.sunk = false;
        this.shipParts = new ArrayList<>();

    }

    public int getSize() {
        return size;
    }

    public boolean isSunk() {
        return sunk;
    }

    public void setShipParts(List<Spot> spots) {
        for (Spot spot : spots) {
            ShipPart shipPart = new ShipPart();
            shipParts.add(shipPart);
            spot.setShipPart(shipPart);
        }
    }

    public void checkShipPartsStatuses() {
        if (shipParts.stream().noneMatch(shipPart -> (shipPart.getStatus().equals(ShipStatus.STRONG)))) {
            for (ShipPart part : shipParts) {
                part.asSunk();
            }
            this.sunk = true;

        }
    }
}
