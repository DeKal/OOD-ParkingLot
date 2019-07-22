package vehicle

import consts.Const

class VehicleTypeTest extends GroovyTestCase{
    Vehicle vehicle

    void testMotorbikeType() throws Exception {
        vehicle = new Bike(null, null)
        assertEquals(Const.VehicleType.MOTORBIKE, vehicle.getType())
    }

    void testCarType() throws Exception {
        vehicle = new Car(null, null)
        assertEquals(Const.VehicleType.CAR, vehicle.getType())
    }

    void testBusType() throws Exception {
        vehicle = new Bus(null, null)
        assertEquals(Const.VehicleType.BUS, vehicle.getType())
    }
}
