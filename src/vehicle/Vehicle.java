package vehicle;

import static consts.Const.*;

public abstract class Vehicle {
    private String licenseName;
    private String ownerName;

    public Vehicle(String licenseName, String ownerName) {
        this.licenseName = licenseName;
        this.ownerName = ownerName;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract Size getSize();
    public abstract VehicleType getType();
}
