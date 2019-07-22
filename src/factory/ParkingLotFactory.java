package factory;

import finance.MoneyCharger;
import parking.ParkingLot;
import parking.map.ParkingLotMap;

public class ParkingLotFactory {

    private ChargerFactory chargerFactory;
    private ParkingLotMapFactory mapFactory;

    public ParkingLotFactory(ChargerFactory chargerFactory, ParkingLotMapFactory mapFactory) {
        this.chargerFactory = chargerFactory;
        this.mapFactory = mapFactory;
    }

    private MoneyCharger createMoneyCharger() {
        return chargerFactory.create();
    }

    private ParkingLotMap createParkingLotMap() {
        return mapFactory.create();
    }

    public ParkingLot create() {
        MoneyCharger charger = createMoneyCharger();
        ParkingLotMap map = createParkingLotMap();
        return new ParkingLot(map, charger);
    }
}
