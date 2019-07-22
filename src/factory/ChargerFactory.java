package factory;

import account.Account;
import database.DBFacade;
import database.Database;
import finance.MoneyCharger;
import finance.ParkingMoneyCharger;

import java.util.List;

public class ChargerFactory {
    private DBFacade db;

    public ChargerFactory(DBFacade db) {
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
