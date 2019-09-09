package finance;

import account.Account;
import consts.Const;
import exception.parkinglotmap.NoRegisteredLicenseError;
import exception.NotPayableException;

import java.util.HashMap;
import java.util.Map;

import static consts.Const.*;

public class ParkingMoneyCharger extends MoneyCharger {
    private Map<String, Account> licenseMap;

    public ParkingMoneyCharger() {
        licenseMap = new HashMap<>();
    }

    public void loadAccount(Account account) {
        licenseMap.put(account.getLicenseName(), account);
    }

    public void charge(String licenseName, VehicleType type) throws Exception {
        if (licenseMap.containsKey(licenseName)) {
            int chargedMoney = getChargedMoneyByVehicleType(type);
            Account account = licenseMap.get(licenseName);
            chargeByLicense(account, chargedMoney);
        }
        else {
            throw new NoRegisteredLicenseError();
        }

    }

    private int getChargedMoneyByVehicleType(VehicleType type) {
        switch (type){
            case MOTORBIKE:
                return ChargeMoney.MOTORBIKE;
            case CAR:
                return ChargeMoney.CAR;
            case BUS:
                return ChargeMoney.BUS;
        }
        return 0;
    }

    private void chargeByLicense(Account account, int  money) throws Exception {
        if (account.isPayable(money)) {
            account.charge(money);
        }
        else {
            throw new NotPayableException();
        }
    }
}
