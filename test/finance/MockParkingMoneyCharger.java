package finance;

import account.Account;
import consts.Const;

public class MockParkingMoneyCharger extends MoneyCharger{
    @Override
    public void loadAccount(Account account) {

    }

    @Override
    public void charge(String licenseName, Const.VehicleType type) throws Exception {

    }

    @Override
    public void chargeByLicense(String licenseName, int money) throws Exception {

    }
}
