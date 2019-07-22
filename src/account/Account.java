package account;

import account.payment.Payment;

public class Account {
    private String name;
    private String licenseName;
    private Payment payment;

    public Account(String name, String licenseName, Payment payment) {
        this.name = name;
        this.payment = payment;
        this.licenseName = licenseName;
    }

    public boolean isPayable(int money) {
        return payment.isPayable(money);
    }

    public void charge(int money) {
        payment.charge(money);
    }

    public String getLicenseName() {
        return licenseName;
    }
}
