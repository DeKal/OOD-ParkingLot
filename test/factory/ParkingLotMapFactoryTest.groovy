package factory

import database.DBMock
import parking.map.ParkingLotMap

class ParkingLotMapFactoryTest extends GroovyTestCase{
    ParkingLotMapFactory factory
    @Override
    protected void setUp() throws Exception {
        factory = new ParkingLotMapFactory(new DBMock())
    }

    void testCreateMap() throws Exception {
        ParkingLotMap parkingLotMap = factory.create()
        assertNotNull(parkingLotMap)
    }
}
