package database;

import account.Account;
import account.payment.Payment;

import java.util.LinkedList;
import java.util.List;

import static consts.Const.*;

public class Database implements IDatabase {
    private static Database db;

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
            db.connect();
        }
        return db;
    }

    private void connect() {

    }
    private Database() {}

    public List<Account> getAccounts() {
        List<Account> accounts = new LinkedList<>();
        accounts.add(new Account("UserA", "ABC123", Payment.getPayment(0, 1000000)));
        accounts.add(new Account("UserB", "ABC124", Payment.getPayment(1, 1000000)));
        accounts.add(new Account("UserC", "ABC125", Payment.getPayment(0, 1000000)));
        accounts.add(new Account("UserD", "ABC126", Payment.getPayment(1, 1000000)));
        accounts.add(new Account("UserE", "ABC127", Payment.getPayment(0, 1000000)));
        accounts.add(new Account("UserF", "ABC128", Payment.getPayment(1, 1000000)));
        accounts.add(new Account("UserH", "ABC130", Payment.getPayment(1, 1000000)));
        accounts.add(new Account("UserG", "ABC131", Payment.getPayment(0, 1000000)));
        accounts.add(new Account("UserJ", "ABC132", Payment.getPayment(1, 1000000)));
        accounts.add(new Account("UserK", "ABC133", Payment.getPayment(1, 1000000)));
        return accounts;
    }



    public List<Size> getSpotSizes() {
        List<Size> slotSizes = new LinkedList<>();
        slotSizes.add(Size.MOTORBIKE);
        slotSizes.add(Size.COMPACT);
        slotSizes.add(Size.MOTORBIKE);
        slotSizes.add(Size.COMPACT);
        slotSizes.add(Size.MOTORBIKE);
        slotSizes.add(Size.LARGE);
        slotSizes.add(Size.MOTORBIKE);
        slotSizes.add(Size.COMPACT);
        slotSizes.add(Size.MOTORBIKE);
        slotSizes.add(Size.LARGE);
        slotSizes.add(Size.MOTORBIKE);

        return slotSizes;
    }
}
