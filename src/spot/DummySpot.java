package spot;

import consts.Const;
import vehicle.Vehicle;

public class DummySpot extends Spot {
    private static DummySpot dummySpot = null;

    public static Spot getInstance() {
        if (dummySpot == null)
            dummySpot = new DummySpot();
        return dummySpot;
    }

    private DummySpot() {}
    @Override
    public void park(Vehicle vehicle) {
        //do nothing since it dummy spot
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    protected Const.Size getSpotSize() {
        return Const.Size.NONE;
    }

    @Override
    public boolean isFit(Const.Size vehicleSize) {
        return false;
    }
}
