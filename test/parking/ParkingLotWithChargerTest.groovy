package parking

import account.Account
import account.payment.Payment
import finance.ParkingMoneyCharger
import vehicle.Bus
import vehicle.Car
import vehicle.Vehicle

class ParkingLotWithChargerTest extends AbstractParkingLotTest {
    ParkingMoneyCharger charger
    Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
    Account acc2 = new Account("UserB", "ABC124", Payment.getPayment(0, 100000))
    Account acc3 = new Account("UserC", "ABC125", Payment.getPayment(0, 100000))
    Account acc4 = new Account("UserD", "ABC126", Payment.getPayment(0, 100000))

    @Override
    protected void setUp() throws Exception {
        setUpCharger()
        setUpParkingLot(charger)
    }

    private void setUpCharger() {
        charger = new ParkingMoneyCharger()
        charger.loadAccount(acc1)
        charger.loadAccount(acc2)
        charger.loadAccount(acc3)
        charger.loadAccount(acc4)
    }

    void testRetrieveCarByLicense() throws Exception {
        Vehicle vehicle = new Car("ABC123", "UserA")
        parkingLot.register(vehicle)
        parkingLot.retrieveByLicense("ABC123")
        assertEquals(true, acc1.isPayable(50000))
        assertEquals(false, acc1.isPayable(100000))
    }

    void testFailedRetrieveBusByLicense() throws Exception {
        Vehicle vehicle = new Bus("ABC123", "UserA")
        parkingLot.register(vehicle)
        shouldFail {
            parkingLot.retrieveByLicense("ABC123")
        }
    }
}
