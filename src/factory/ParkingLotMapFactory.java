package factory;

import database.IDatabase;
import parking.map.LinearParkingLotMap;
import parking.map.ParkingLotMap;
import spot.*;

import java.util.List;

import static consts.Const.*;

public class ParkingLotMapFactory {
    IDatabase db;
    public ParkingLotMapFactory(IDatabase db) {
        this.db = db;
    }

    public ParkingLotMap create() {
        ParkingLotMap parkingLotMap = new LinearParkingLotMap();
        List<Size> spotSizes = db.getSpotSizes();
        for (Size spotSize: spotSizes) {
            parkingLotMap.add(createSlot(spotSize));
        }
        return parkingLotMap;
    }

    private static Spot createSlot(Size size) {
        switch (size) {
            case MOTORBIKE:
                return new MotorbikeSpot();
            case COMPACT:
                return new CompactSpot();
            case LARGE:
                return new LargeSpot();
        }
        return DummySpot.getInstance();
    }
}
