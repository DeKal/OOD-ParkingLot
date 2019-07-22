package consts

class MoneyChargerTest extends GroovyTestCase {
    private final static int BIKE_MONEY_CHARGER = 5000
    private final static int CAR_MONEY_CHARGER = 50000
    private final static int BUS_MONEY_CHARGER = 500000


    void testMoneyCharger() throws Exception {
        Const.ChargeMoney chargeMoney = new Const.ChargeMoney()
        assertEquals(BIKE_MONEY_CHARGER, chargeMoney.MOTORBIKE)
        assertEquals(CAR_MONEY_CHARGER, chargeMoney.CAR)
        assertEquals(BUS_MONEY_CHARGER, chargeMoney.BUS)
    }
}
