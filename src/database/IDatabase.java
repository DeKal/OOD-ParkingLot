package database;

import account.Account;

import java.util.List;

import static consts.Const.*;

public interface IDatabase {
    List<Account> getAccounts();
    List<Size> getSpotSizes();
}
