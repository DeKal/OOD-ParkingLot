package account.payment;

public class CreditPayment extends Payment{
    private String creditNumber;
    private String creditPIN;

    public CreditPayment(int money, String creditNumber, String creditPIN) {
        super(money);
        this.creditNumber = creditNumber;
        this.creditPIN = creditPIN;
    }

    @Override
    public boolean isPayable(int money) {
        if (isValidateCreditCard())
            return super.isPayable(money);
        else
            return false;
    }

    private boolean isValidateCreditCard() {
        return (creditNumber != null && creditPIN != null);
    }
}
