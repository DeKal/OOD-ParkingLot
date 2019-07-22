package parking.map;

import consts.Const;
import exception.parkinglotmap.NoEmptySpotException;
import exception.parkinglotmap.NoRegisteredLicenseError;
import spot.Spot;

import java.util.LinkedList;
import java.util.List;

public class LinearParkingLotMap extends ParkingLotMap{
    private List<Spot> spotList;

    public LinearParkingLotMap() {
        spotList = new LinkedList<>();
    }

    public ParkingLotMap add(Spot spot) {
        spotList.add(spot);
        return this;
    }

    public Spot findUnoccupied(Const.Size vehicleSize) throws NoEmptySpotException {
        for (Spot spot : spotList) {
            if (!spot.isOccupied() && spot.isFit(vehicleSize)) {
                return spot;
            }
        }
        throw new NoEmptySpotException();
    }

    public boolean checkDuplicatedLicenseName(String vehicleLicense) {
        for (Spot spot : spotList) {
            if (spot.containsVehicleWithLicense(vehicleLicense))
                return true;
        }
        return false;
    }

    public Spot retrieveByLicense(String licenseName) throws NoRegisteredLicenseError {
        for (Spot spot : spotList) {
            if (spot.isOccupied() && spot.containsVehicleWithLicense(licenseName)) {
                return spot;
            }
        }
        throw new NoRegisteredLicenseError();
    }

    @Override
    public int capacity() {
        return spotList.size();
    }
}
