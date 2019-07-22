package exception.parkinglotmap;

public class NoEmptySpotException extends ParkingLotMapException {
    @Override
    public String getMessage() {
        return "No empty spot in the parking lot !!!";
    }
}
