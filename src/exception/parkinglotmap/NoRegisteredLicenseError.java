package exception.parkinglotmap;

public class NoRegisteredLicenseError extends ParkingLotMapException {
    @Override
    public String getMessage() {
        return "No such license is registered in the system";
    }
}
