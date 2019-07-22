package spot;

import consts.Const.Size;
import size.SizeCompare;

public class MotorbikeSpot extends Spot{

    @Override
    protected Size getSpotSize() {
        return  Size.MOTORBIKE;
    }

    @Override
    public boolean isFit(Size vehicleSize) {
        return SizeCompare.compareVehicleToSpotSize(vehicleSize, Size.MOTORBIKE);
    }
}
