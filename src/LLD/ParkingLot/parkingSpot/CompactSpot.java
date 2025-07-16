package LLD.ParkingLot.parkingSpot;

import LLD.ParkingLot.vehicle.Vehicle;
import LLD.ParkingLot.vehicle.VehicleType;

/**
 * @author parachau
 **/
public class CompactSpot extends ParkingSpot{

    public CompactSpot(String spotId){
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.CAR
                || vehicle.getVehicleType() == VehicleType.AUTO;
    }
}
