package LLD.ParkingLot;

import LLD.ParkingLot.parkingSpot.ParkingSpot;
import LLD.ParkingLot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

/**
 * @author parachau
 **/
public class Floor {
    private int floorNo;
    private List<ParkingSpot> parkingSpotList;

    public Floor(int floorNo, List<ParkingSpot> parkingSpotList) {
        this.floorNo = floorNo;
        this.parkingSpotList = parkingSpotList;
    }

    public synchronized Optional<ParkingSpot> getAvailableParkingSpot(Vehicle vehicle) {
        return parkingSpotList.stream()
                .filter(parkingSpot -> parkingSpot.isAvailable() && parkingSpot.canFitVehicle(vehicle))
                .findFirst();
    }

    public int getFloorNo() {
        return floorNo;
    }
}
