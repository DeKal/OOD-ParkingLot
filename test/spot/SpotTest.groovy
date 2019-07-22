package spot

import vehicle.Car
import vehicle.Vehicle

class SpotTest extends GroovyTestCase{
    void testFullSpot()throws Exception {
        Spot spot = new CompactSpot()
        Vehicle vehicle = new Car("aaa", "aaa")
        spot.park(vehicle)
        assertEquals(true, spot.containsVehicleWithLicense("aaa"))

        vehicle = new Car("bbb", "bbb")
        spot.park(vehicle)
        assertEquals(false, spot.containsVehicleWithLicense("bbb"))

        Vehicle retrieveVehicle = spot.retrieve()
        assertEquals("aaa", retrieveVehicle.getLicenseName())
        assertEquals("aaa", retrieveVehicle.getOwnerName())
    }
}
