package vehicle;

import static consts.Const.*;

public class Bus extends Vehicle {
    public Bus(String licenseName, String ownerName) {
        super(licenseName, ownerName);
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
}
