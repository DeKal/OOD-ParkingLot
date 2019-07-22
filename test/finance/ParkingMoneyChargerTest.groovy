package finance

import account.Account
import account.payment.Payment
import consts.Const

class ParkingMoneyChargerTest extends GroovyTestCase{
    ParkingMoneyCharger charger
    @Override
    protected void setUp() throws Exception {
        charger = new ParkingMoneyCharger()
    }

    void testLoadAccountToCharger() throws Exception{
        Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
        Account acc2 = new Account("UserA", "ABC124", Payment.getPayment(0, 100000))

        charger.loadAccount(acc1)
        charger.loadAccount(acc2)

        charger.chargeByLicense("ABC123", 5000)
        charger.chargeByLicense("ABC124", 10000)

        assertEquals(true, acc1.isPayable(95000))
        assertEquals(true, acc2.isPayable(90000))

        assertEquals(false, acc1.isPayable(100000))
        assertEquals(false, acc2.isPayable(100000))
    }

    void testAccountNotEnoughMoney() throws Exception {
        shouldFail {
            Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
            charger.loadAccount(acc1)
            charger.chargeByLicense("ABC123", 500000)
        }
    }

    void testChargeMotorBike() throws  Exception {
        Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
        charger.loadAccount(acc1)
        charger.charge("ABC123", Const.VehicleType.MOTORBIKE)
        assertEquals(true, acc1.isPayable(95000))
        assertEquals(false, acc1.isPayable(100000))
    }

    void testChargeCar() throws  Exception {
        Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
        charger.loadAccount(acc1)
        charger.charge("ABC123", Const.VehicleType.CAR)
        assertEquals(true, acc1.isPayable(50000))
        assertEquals(false, acc1.isPayable(100000))
    }

    void testChargeBus() throws Exception {
        Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 1000000))
        charger.loadAccount(acc1)
        charger.charge("ABC123", Const.VehicleType.BUS)
        assertEquals(true, acc1.isPayable(500000))
        assertEquals(false, acc1.isPayable(1000000))
    }

    void testNoLicenseRegister() throws Exception {
        Account acc1 = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
        charger.loadAccount(acc1)
        shouldFail {
            charger.charge("ABC124", Const.VehicleType.BUS)
        }
    }
}
