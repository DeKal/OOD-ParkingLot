package parking

import finance.MockParkingMoneyCharger
import vehicle.Bus
import vehicle.Car
import vehicle.Vehicle

class ParkingLotTest extends AbstractParkingLotTest{

    @Override
    protected void setUp() throws Exception {
        setUpParkingLot(new MockParkingMoneyCharger())
    }

    void testAddCarToParkingLot() throws Exception{
        boolean isSuccess = parkingLot.register(new Car(null, null))
        assertEquals(true, isSuccess)
    }

    void testFailedToRegister() throws Exception{
        parkingLot.register(new Bus(null, null))
        parkingLot.register(new Bus(null, null))
        boolean isSuccess = parkingLot.register(new Bus(null, null))
        assertEquals(false, isSuccess)
    }

    void testRetrieveVehicleByLicense() throws Exception {
        Vehicle vehicle = new Car("ABC123", "UserA")
        parkingLot.register(vehicle)
        Vehicle retrievedVehicle = parkingLot.retrieveByLicense("ABC123")
        assertSame(retrievedVehicle, vehicle)
    }

    void testRetrieveAndParkAgain() throws Exception {
        Vehicle vehicle = new Bus("ABC123", "UserA")
        parkingLot.register(vehicle)
        vehicle = new Bus("ABC124", "UserB")
        parkingLot.register(vehicle)

        parkingLot.retrieveByLicense("ABC124")

        vehicle = new Bus("ABC125", "UserC")
        assertEquals(true, parkingLot.register(vehicle))
    }

    void testRegisterSameLicenseName() {
        Vehicle vehicle = new Bus("ABC123", "UserA")
        parkingLot.register(vehicle)
        vehicle = new Bus("ABC123", "UserB")
        boolean isSuccess = parkingLot.register(vehicle)
        assertFalse(isSuccess)
    }
}
