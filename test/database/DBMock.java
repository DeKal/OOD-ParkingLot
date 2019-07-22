package database;

import account.Account;
import account.payment.Payment;
import consts.Const;

import java.util.LinkedList;
import java.util.List;

public class DBMock extends DBFacade {
    @Override
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

    @Override
    public List<Const.Size> getSpotSizes() {
        List<Const.Size> slotSizes = new LinkedList<>();
        slotSizes.add(Const.Size.MOTORBIKE);
        slotSizes.add(Const.Size.COMPACT);
        slotSizes.add(Const.Size.MOTORBIKE);
        slotSizes.add(Const.Size.COMPACT);
        slotSizes.add(Const.Size.MOTORBIKE);
        slotSizes.add(Const.Size.LARGE);
        slotSizes.add(Const.Size.MOTORBIKE);
        slotSizes.add(Const.Size.COMPACT);
        slotSizes.add(Const.Size.MOTORBIKE);
        slotSizes.add(Const.Size.LARGE);
        slotSizes.add(Const.Size.MOTORBIKE);
        slotSizes.add(Const.Size.NONE);
        return slotSizes;
    }
}
