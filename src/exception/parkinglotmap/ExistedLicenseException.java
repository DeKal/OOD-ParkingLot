package exception.parkinglotmap;

public class ExistedLicenseException extends ParkingLotMapException{
    @Override
    public String getMessage() {
        return "The License Name is Existed and can not be registered again";
    }
}
