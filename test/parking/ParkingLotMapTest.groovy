package parking

import consts.Const
import parking.map.LinearParkingLotMap
import parking.map.ParkingLotMap
import spot.CompactSpot
import spot.LargeSpot
import spot.MotorbikeSpot
import spot.Spot
import vehicle.Bike
import vehicle.Bus
import vehicle.Car

class ParkingLotMapTest extends GroovyTestCase {
    ParkingLotMap parkingSpots

    @Override
    protected void setUp() throws Exception {
        parkingSpots = new LinearParkingLotMap()
    }

    void testAddSpot() throws Exception {
        addMotorbikeSpots(2)
        addCompactSpots(3)
        addLargeSpots(2)
        assertEquals(7, parkingSpots.capacity())
    }

    void testAddSpotInline() throws Exception {
        parkingSpots.add(new CompactSpot())
                .add(new LargeSpot())
                .add(new MotorbikeSpot())
                .add(new LargeSpot())
                .add(new MotorbikeSpot());
        assertEquals(5, parkingSpots.capacity())
    }

    void testFindCompactSpot() {
        addMotorbikeSpots(4)
        addCompactSpots(4)
        addLargeSpots(4)

        Spot spot = parkingSpots.findUnoccupied(Const.Size.COMPACT)
        assertEquals(false, spot.isOccupied())

        spot.park(new Car(null, null))
        spot = parkingSpots.findUnoccupied(Const.Size.COMPACT)
        assertEquals(false, spot.isOccupied())
    }

    void testOccupiedSpotNotFound() throws Exception {
        addCompactSpots(2)
        addLargeSpots(1)
        Spot spot = parkingSpots.findUnoccupied(Const.Size.LARGE)
        spot.park(new Bus(null, null))
        shouldFail {
            spot = parkingSpots.findUnoccupied(Const.Size.LARGE)
        }
    }

    void addMotorbikeSpots(int num) {
        for (int i = 0; i < num; ++i) {
            parkingSpots.add(new MotorbikeSpot())
        }
    }

    void addCompactSpots(int num) {
        for (int i = 0; i < num; ++i) {
            parkingSpots.add(new CompactSpot())
        }
    }

    void addLargeSpots(int num) {
        for (int i = 0; i < num; ++i) {
            parkingSpots.add(new LargeSpot())
        }
    }

    void testFindSpotByLicenseName() throws Exception {
        addLargeSpots(3)
        addCompactSpots(2)
        addMotorbikeSpots(5)
        Spot spot = parkingSpots.findUnoccupied(Const.Size.MOTORBIKE)
        spot.park(new Bike("ABC123", null))

        Spot retrievedSpot = parkingSpots.retrieveByLicense("ABC123")
        assertSame(spot, retrievedSpot)

        shouldFail {
            retrievedSpot = parkingSpots.retrieveByLicense("ABC")
        }
    }

    void testFindUnoccupiedWithSameLicenseName() throws Exception {
        addLargeSpots(3)
        addCompactSpots(2)
        addMotorbikeSpots(5)
        Spot spot = parkingSpots.findUnoccupied(Const.Size.MOTORBIKE)
        spot.park(new Bike("ABC123", null))

        assertTrue(parkingSpots.checkDuplicatedLicenseName("ABC123"))
    }
}
