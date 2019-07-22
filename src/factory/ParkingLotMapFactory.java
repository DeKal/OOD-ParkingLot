package factory;

import database.DBFacade;
import parking.map.LinearParkingLotMap;
import parking.map.ParkingLotMap;
import spot.*;

import java.util.List;

import static consts.Const.*;

public class ParkingLotMapFactory {
    DBFacade db;
    public ParkingLotMapFactory(DBFacade db) {
        this.db = db;
    }

    public ParkingLotMap create() {
        ParkingLotMap parkingLotMap = new LinearParkingLotMap();
        List<Size> spotSizes = db.getSpotSizes();
        for (Size spotSize: spotSizes) {
            parkingLotMap.add(Spot.createBySize(spotSize));
        }
        return parkingLotMap;
    }

}
