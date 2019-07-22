package finance;

import account.Account;
import consts.Const;
import exception.parkinglotmap.NoRegisteredLicenseError;
import exception.NotPayableException;

import java.util.HashMap;
import java.util.Map;

import static consts.Const.*;

public class ParkingMoneyCharger extends MoneyCharger{
    private Map<String, Account> licenseMap;

    public ParkingMoneyCharger() {
        licenseMap = new HashMap<>();
    }

    public void loadAccount(Account account) {
        licenseMap.put(account.getLicenseName(), account);
    }

    public void chargeByLicense(String licenseName, int  money) throws Exception {
        if (licenseMap.containsKey(licenseName)) {
            Account account = licenseMap.get(licenseName);
            if (account.isPayable(money)) {
                account.charge(money);
            }
            else {
                throw new NotPayableException();
            }
        }
        else {
            throw new NoRegisteredLicenseError();
        }
    }

    public void charge(String licenseName, VehicleType type) throws Exception {
       switch (type){
           case MOTORBIKE:
               chargeByLicense(licenseName, Const.ChargeMoney.MOTORBIKE);
               break;
           case CAR:
               chargeByLicense(licenseName, Const.ChargeMoney.CAR);
               break;
           case BUS:
               chargeByLicense(licenseName, Const.ChargeMoney.BUS);
       }
    }
}
