package factory

import database.Database
import finance.MoneyCharger

class ChargerFactoryTest extends GroovyTestCase{
    ChargerFactory factory
    @Override
    protected void setUp() throws Exception {
        factory = new ChargerFactory(Database.getInstance())
    }

    void testCreate() throws Exception{
        MoneyCharger charger =  factory.create()
        assertNotNull(charger)
    }
}
