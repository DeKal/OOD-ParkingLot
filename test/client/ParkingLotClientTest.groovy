package client

import database.Database
import factory.ChargerFactory
import factory.ParkingLotFactory
import factory.ParkingLotMapFactory
import parking.ParkingLot
import vehicle.Bike
import vehicle.Vehicle

class ParkingLotClientTest extends GroovyTestCase {

    ParkingLot parkingLot

    @Override
    protected void setUp() throws Exception {
        Database db = Database.getInstance()
        ChargerFactory chargerFactory = new ChargerFactory(db)
        ParkingLotMapFactory mapFactory = new ParkingLotMapFactory(db)
        ParkingLotFactory parkingLotFactory = new ParkingLotFactory(chargerFactory, mapFactory)
        parkingLot = parkingLotFactory.create()
        parkingLot.register(new Bike("ABC123", "UserA"))
        parkingLot.register(new Bike("ABC124", "UserB"))
        parkingLot.register(new Bike("ABC125", "UserC"))
        parkingLot.register(new Bike("ABC126", "UserD1"))
        parkingLot.register(new Bike("ABC127", "UserD2"))
        parkingLot.register(new Bike("ABC128", "UserD3"))
    }

    void testNoMoreBikeSpot() throws Exception{
        boolean isSuccess = parkingLot.register(new Bike("ABC129", "UserD4"))
        assertFalse(isSuccess)
        shouldFail {
            parkingLot.retrieveByLicense("ABC129")
        }
    }

    void testRetrieveBike() throws Exception{
        Vehicle vehicle = parkingLot.retrieveByLicense("ABC123")
        parkingLot.register(vehicle)
        Vehicle vehicle2 = parkingLot.retrieveByLicense("ABC123")
        assertSame(vehicle, vehicle2)
    }
}
