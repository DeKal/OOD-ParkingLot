package account.payment;

public abstract class Payment {

    public static Payment getPayment(int paymentType, int money) {
        if (paymentType == 0) {
            return new CashPayment(money);
        } else {
            return new CreditPayment(money, "111111111", "071111");
        }
    }

    private int money;

    public Payment(int money) {
        this.money = money;
    }

    public boolean isPayable(int money){
        return this.money >= money;
    }

    public void charge(int money) {
        this.money -= money;
    }
}
