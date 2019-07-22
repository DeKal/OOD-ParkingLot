package parking

import finance.MoneyCharger
import parking.map.LinearParkingLotMap
import parking.map.ParkingLotMap
import spot.CompactSpot
import spot.LargeSpot
import spot.MotorbikeSpot

abstract class AbstractParkingLotTest extends GroovyTestCase {
    protected ParkingLot parkingLot

    protected void setUpParkingLot(MoneyCharger charger) {
        ParkingLotMap parkingSpots = new LinearParkingLotMap()
        addCompactSpots(parkingSpots, 3)
        addMotoSpots(parkingSpots, 5)
        addLargeSpots(parkingSpots, 2)
        parkingLot = new ParkingLot(parkingSpots, charger)
    }

    protected void addCompactSpots(ParkingLotMap parkingSpots, int num) {
        for (int i = 0; i < num; ++i) {
            parkingSpots.add(new CompactSpot())
        }
    }

    protected void addMotoSpots(ParkingLotMap parkingSpots, int num) {
        for (int i = 0; i < num; ++i) {
            parkingSpots.add(new MotorbikeSpot())
        }
    }

    protected void addLargeSpots(ParkingLotMap parkingSpots, int num) {
        for (int i = 0; i < num; ++i) {
            parkingSpots.add(new LargeSpot())
        }
    }
}
