package spot;

import consts.Const.Size;
import size.SizeCompare;

public class LargeSpot extends Spot{

    @Override
    protected Size getSpotSize() {
        return Size.LARGE;
    }

    @Override
    public boolean isFit(Size vehicleSize) {
        return SizeCompare.compareVehicleToSpotSize(vehicleSize, Size.LARGE);
    }
}
