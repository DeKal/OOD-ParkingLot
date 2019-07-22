package spot;

import consts.Const.Size;
import size.SizeCompare;
import vehicle.DummyVehicle;
import vehicle.Vehicle;

public abstract class Spot {

    public static Spot createBySize(Size size) {
        switch (size) {
            case MOTORBIKE:
                return new MotorbikeSpot();
            case COMPACT:
                return new CompactSpot();
            case LARGE:
                return new LargeSpot();
        }
        return DummySpot.getInstance();
    }

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
    abstract public boolean isFit(Size vehicleSize);


    public Vehicle retrieve() {
        Vehicle retrieveVehicle = vehicle;
        freeVehicle();
        return retrieveVehicle;
    }

    private void freeVehicle() {
        vehicle = DummyVehicle.getInstance();
    }

    public boolean isOccupied() {
        return !Size.NONE.equals(vehicle.getSize());
    }

    public boolean containsVehicleWithLicense(String licenseName) {
        return vehicle.getLicenseName() != null
                && vehicle.getLicenseName().equals(licenseName);
    }
}
