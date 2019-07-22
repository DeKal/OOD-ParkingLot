package spot

import consts.Const
import vehicle.Bike
import vehicle.Bus
import vehicle.Car
import vehicle.Vehicle

class MotorbikeSpotTest extends GroovyTestCase{
    Spot spot

    @Override
    protected void setUp() throws Exception {
        spot = new MotorbikeSpot()
    }

    void testParkBikeToBikeSpot() throws Exception {

        Vehicle vehicle = new Car(null, null)
        spot.park(vehicle)
        assertEquals(false, spot.isOccupied())
    }

    void testParkMotorbikeToBikeSpot() throws Exception {
        Vehicle vehicle = new Bike(null, null)
        spot.park(vehicle)
        assertEquals(true, spot.isOccupied())
    }

    void testParkBusToBikeSpot() throws Exception {
        Vehicle vehicle = new Bus(null, null)
        spot.park(vehicle)
        assertEquals(false, spot.isOccupied())
    }

    void testRetrieveVehicle() throws Exception {
        Vehicle vehicle = new Bike("aaa", "bbb")
        spot.park(vehicle)
        Vehicle retrievedVehicle = spot.retrieve()
        assertEquals("aaa", retrievedVehicle.getLicenseName())
        assertEquals("bbb", retrievedVehicle.getOwnerName())
        assertEquals(false, spot.isOccupied())
    }

    void testSpotFit() throws Exception{
        assertEquals(true, spot.isFit(Const.Size.MOTORBIKE))
        assertEquals(false, spot.isFit(Const.Size.COMPACT))
        assertEquals(false, spot.isFit(Const.Size.LARGE))
    }
}
