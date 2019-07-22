package parking.map;

import exception.parkinglotmap.NoRegisteredLicenseError;
import exception.parkinglotmap.NoEmptySpotException;
import spot.Spot;
import java.util.LinkedList;
import java.util.List;
import static consts.Const.*;

public abstract class ParkingLotMap {
    public abstract int capacity();
    public abstract ParkingLotMap add(Spot spot);
    public abstract boolean checkDuplicatedLicenseName(String vehicleLicense);
    public abstract Spot findUnoccupied(Size vehicleSize) throws NoEmptySpotException;
    public abstract Spot retrieveByLicense(String licenseName) throws NoRegisteredLicenseError;
}
