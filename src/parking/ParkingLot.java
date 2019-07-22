package parking;

import exception.parkinglotmap.ExistedLicenseException;
import exception.parkinglotmap.ParkingLotMapException;
import finance.MoneyCharger;
import parking.map.ParkingLotMap;
import spot.Spot;
import vehicle.Vehicle;

public class ParkingLot {
    private final ParkingLotMap parkingLotMap;
    private MoneyCharger charger;

    public ParkingLot(ParkingLotMap parkingLotMap, MoneyCharger charger) {
        this.parkingLotMap = parkingLotMap;
        this.charger = charger;
    }

    public boolean register(Vehicle vehicle) {
        try {
            if (parkingLotMap.checkDuplicatedLicenseName(vehicle.getLicenseName())){
                throw new ExistedLicenseException();
            }

            Spot spot = parkingLotMap.findUnoccupied(vehicle.getSize());
            spot.park(vehicle);
            return true;
        } catch (ParkingLotMapException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Vehicle retrieveByLicense(String licenseName) throws Exception {
        Spot retrievedSpot = parkingLotMap.retrieveByLicense(licenseName);
        Vehicle retrievedVehicle = retrievedSpot.retrieve();
        charger.charge(retrievedVehicle.getLicenseName(), retrievedVehicle.getType());
        return retrievedVehicle;
    }

}
