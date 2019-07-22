package vehicle

import consts.Const
import consts.Const.Size

class VehicleSizeTest extends GroovyTestCase {
    void testCarSize() throws Exception {
        Vehicle vehicle = new Car(null, null)
        assertEquals(Size.COMPACT, vehicle.getSize())
    }

    void testBusSize() throws Exception {
        Vehicle vehicle = new Bus(null, null)
        assertEquals(Size.LARGE, vehicle.getSize())
    }

    void testBikeSize() throws  Exception {
        Vehicle vehicle = new Bike(null, null)
        assertEquals(Size.MOTORBIKE, vehicle.getSize())
    }

    void testDummyVehicle() throws Exception {
        Vehicle vehicle = DummyVehicle.getInstance()
        assertEquals(Size.NONE, vehicle.getSize())
        assertEquals(null, vehicle.getLicenseName())
        assertEquals(null, vehicle.getOwnerName())
        assertEquals(Const.VehicleType.NONE, vehicle.getType())
    }
}
