package vehicle;

import static consts.Const.*;

public class DummyVehicle extends Vehicle{
    private static DummyVehicle dummyVehicle = null;

    public static final DummyVehicle getInstance() {
        if (dummyVehicle == null)
            dummyVehicle = new DummyVehicle();
        return dummyVehicle;
    }

    private DummyVehicle() {
        super(null, null);
    }

    @Override
    public Size getSize() {
        return Size.NONE;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.NONE;
    }
}
