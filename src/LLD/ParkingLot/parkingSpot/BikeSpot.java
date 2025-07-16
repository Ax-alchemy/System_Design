package LLD.ParkingLot.parkingSpot;

import LLD.ParkingLot.vehicle.Vehicle;
import LLD.ParkingLot.vehicle.VehicleType;

/**
 * @author parachau
 **/
public class BikeSpot extends ParkingSpot{
    public BikeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.BIKE;
    }
}
