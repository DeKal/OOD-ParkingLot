package finance;

import account.Account;

import static consts.Const.*;

public abstract class MoneyCharger {
    abstract public void loadAccount(Account account);
    abstract public void charge(String licenseName, VehicleType type) throws Exception;
}
