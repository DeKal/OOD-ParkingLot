package factory

import database.Database
import parking.ParkingLot

class ParkingLotFactoryTest extends GroovyTestCase {
    ParkingLotFactory factory

    @Override
    protected void setUp() throws Exception {
        ChargerFactory chargerFactory = new ChargerFactory(Database.getInstance())
        ParkingLotMapFactory mapFactory = new ParkingLotMapFactory(Database.getInstance())
        factory = new ParkingLotFactory(chargerFactory, mapFactory)
    }

    void testCreateParkingLot() throws Exception {
        ParkingLot parkingLot = factory.create()
        assertNotNull(parkingLot)
    }
}
