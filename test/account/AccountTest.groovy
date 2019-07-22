package account

import account.payment.CreditPayment
import account.payment.Payment

class AccountTest extends GroovyTestCase {
    void testCashAccount() throws Exception{
        Account account = new Account("UserA", "ABC123", Payment.getPayment(0, 100000))
        account.charge(5000)
        assertEquals("ABC123", account.getLicenseName())
        assertEquals(true, account.isPayable(45000))
    }

    void testCreditAccount() throws Exception{
        Account account = new Account("UserA", "ABC123", Payment.getPayment(1, 100000))
        account.charge(5000)
        assertEquals("ABC123", account.getLicenseName())
        assertEquals(true, account.isPayable(45000))
    }

    void testInvalidCreditAccount () throws Exception {
        Payment payment = new CreditPayment(1000000, null, null)
        Account account = new Account("UserA", "ABC123", payment)
        account.charge(5000)

        assertEquals(false, account.isPayable(45000))
        assertEquals(false, account.isPayable(10000000))
    }
}
