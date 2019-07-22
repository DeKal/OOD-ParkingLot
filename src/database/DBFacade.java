package database;

import account.Account;

import java.util.List;

import static consts.Const.*;

public abstract class DBFacade {
    public abstract List<Account> getAccounts();
    public abstract List<Size> getSpotSizes();
}
