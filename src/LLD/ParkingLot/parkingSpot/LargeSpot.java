package LLD.ParkingLot.parkingSpot;

import LLD.ParkingLot.vehicle.Vehicle;
import LLD.ParkingLot.vehicle.VehicleType;

/**
 * @author parachau
 **/
public class LargeSpot extends ParkingSpot{

    public LargeSpot(String spotId){
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.TRUCK;
    }
}
