package spot;

import consts.Const.Size;
import size.SizeCompare;
import vehicle.DummyVehicle;
import vehicle.Vehicle;

public abstract class Spot {

    private Vehicle vehicle = DummyVehicle.getInstance();

    public void park(Vehicle vehicle) {
        if (!isOccupied() && canVehiclePark(vehicle)) {
            this.vehicle = vehicle;
        }
    }
    private boolean canVehiclePark(Vehicle vehicle) {
        return SizeCompare.compareVehicleToSpotSize(vehicle.getSize(), getSpotSize());
    }

    protected abstract Size getSpotSize();

    public boolean isOccupied() {
        return !Size.NONE.equals(vehicle.getSize());
    }

    public Vehicle retrieve() {
        Vehicle retrieveVehicle = vehicle;
        freeVehicle();
        return retrieveVehicle;
    }

    private void freeVehicle() {
        vehicle = DummyVehicle.getInstance();
    }

    abstract public boolean isFit(Size vehicleSize);

    public boolean containsVehicleWithLicense(String licenseName) {
        return vehicle.getLicenseName() != null
                && vehicle.getLicenseName().equals(licenseName);
    }
}
