package LLD.ParkingLot.parkingSpot;

import LLD.ParkingLot.vehicle.Vehicle;

/**
 * @author parachau
 **/
public abstract class ParkingSpot {
    private String spotId;
    private boolean isAvailable;
    private Vehicle vehicle;

    protected ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public synchronized boolean isAvailable() {
        return isAvailable;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if(!isAvailable){ return false;}
        this.vehicle = vehicle;
        isAvailable = false;
        return true;
    }

    public synchronized void removeVehicle() {
        this.vehicle = null;
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                '}';
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);
}
