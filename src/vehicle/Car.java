package vehicle;
import static consts.Const.*;

public class Car extends Vehicle {

    public Car(String licenseName, String ownerName) {
        super(licenseName, ownerName);
    }

    @Override
    public Size getSize() {
        return Size.COMPACT;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
