package vehicle;

import static consts.Const.*;

public class Bike extends Vehicle {

    public Bike(String licenseName, String ownerName) {
        super(licenseName, ownerName);
    }

    @Override
    public Size getSize() {
        return Size.MOTORBIKE;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MOTORBIKE;
    }
}
