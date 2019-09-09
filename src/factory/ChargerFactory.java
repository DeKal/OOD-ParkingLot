package factory;

import account.Account;
import database.IDatabase;
import finance.MoneyCharger;
import finance.ParkingMoneyCharger;

import java.util.List;

public class ChargerFactory {
    private IDatabase db;

    public ChargerFactory(IDatabase db) {
        this.db = db;
    }

    public MoneyCharger create() {
        List<Account> accounts = db.getAccounts();
        MoneyCharger charger = new ParkingMoneyCharger();
        for (Account account: accounts) {
            charger.loadAccount(account);
        }
        return charger;
    }
}
