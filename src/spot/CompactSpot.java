package spot;

import consts.Const.Size;
import size.SizeCompare;

public class CompactSpot extends Spot {

    @Override
    protected Size getSpotSize() {
        return Size.COMPACT;
    }

    @Override
    public boolean isFit(Size vehicleSize) {
        return SizeCompare.compareVehicleToSpotSize(vehicleSize, Size.COMPACT);
    }
}
