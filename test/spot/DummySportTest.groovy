package spot

import consts.Const
import vehicle.DummyVehicle
import vehicle.Vehicle

class DummySportTest extends  GroovyTestCase {
    void testDummySpot() throws Exception {
        Spot spot = DummySpot.getInstance()
        assertEquals(true, spot.isOccupied())
        assertEquals(false, spot.isFit(Const.Size.COMPACT))
        assertEquals(false, spot.isFit(Const.Size.LARGE))
        assertEquals(false, spot.isFit(Const.Size.MOTORBIKE))
        spot.park(null)
        Vehicle vehicle = spot.retrieve()
        assertEquals(vehicle, DummyVehicle.getInstance())
        assertEquals(Const.Size.NONE, spot.getSpotSize())
    }
}
